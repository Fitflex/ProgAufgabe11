package Notizbuch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

/**
 * Ein Programm zum erstellen von Notizen die sich untereinander lesen.
 * 
 * @author Marlon, u29739, m21899
 */

public class Notizbuch extends JFrame {

	private JPanel contentPane;
	public JTextPane erhalten;
	public TextArea verfassen;
	public String speicher1;
	public String speicher2;
	public String speicher3;
	public String speicher4;
	public String speicher5;
	int count;

	public Notizbuch(int counter){	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 518);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		verfassen = new TextArea();
		verfassen.setBounds(0, 291, 540, 180);
		contentPane.add(verfassen);
		
		count = counter;
		
		Button button = new Button("Senden");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					schreiben();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Dialog", Font.PLAIN, 17));
		button.setBounds(541, 294, 105, 88);
		contentPane.add(button);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					panelSpeichern();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnSpeichern.setBounds(541, 388, 105, 39);
		contentPane.add(btnSpeichern);
		
		JButton btnLaden = new JButton("Laden");
		btnLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					panelLaden();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLaden.setBounds(541, 432, 105, 39);
		contentPane.add(btnLaden);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(0, 0, 646, 286);
		contentPane.add(scrollPane_1);
		
		erhalten = new JTextPane();
		scrollPane_1.setViewportView(erhalten);
		setLocationRelativeTo(null);
		erhalten.setText("");
		
		try {
			schreiben();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		TimerTask action = new TimerTask(){
			public void run(){
				try {
					lesen();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		Timer caretaker = new Timer();
		caretaker.schedule(action, 1000, 1000);
	}
	
	public void lesen() throws IOException{
		FileReader fr1 = new FileReader("Save.txt");
		BufferedReader br1 = new BufferedReader(fr1);
		String zeile1 = "";
		speicher1 = "";
		
		while( (zeile1 = br1.readLine()) != null){
			speicher1 = speicher1+zeile1; 
	    }
	    br1.close();
	    fr1.close();
		
		FileReader fr2 = new FileReader("Zwischenspeicher"+count+".txt");
		BufferedReader br2 = new BufferedReader(fr2);
		String zeile2 = "";
		speicher2 = "";
		
		while( (zeile2 = br2.readLine()) != null){
			speicher2 = speicher2+zeile2;   	 
	    }
	    br2.close();
	    fr2.close();
	    
		if(speicher1.equals(speicher2)){
			
		}else {
			
		    FileWriter fw = new FileWriter("Zwischenspeicher"+count+".txt");
			BufferedWriter bw = new BufferedWriter(fw);		
			bw.write(speicher1);
			bw.close();
			fw.close();
			
			FileWriter fw1 = new FileWriter("Save.txt");
			BufferedWriter bw1 = new BufferedWriter(fw1);		
			bw1.write(speicher1);
			bw1.close();
			fw1.close();
			
			erhalten.setText(speicher1);
		}
	}
	
	public void schreiben() throws IOException{
		if(verfassen.getText() != null){
			speicher3 = verfassen.getText();
			speicher5 = erhalten.getText();
			
			FileWriter fw2 = new FileWriter("Save.txt");
			BufferedWriter bw2 = new BufferedWriter(fw2);	
			bw2.write(speicher5);
			bw2.write(" \r\n");
			bw2.write(speicher3);
			bw2.close();
			fw2.close();
		}
	}
	
	public void panelSpeichern() throws IOException{
		FileOutputStream fileOut = new FileOutputStream("Panel.ser");
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    out.writeObject(erhalten);
        out.close();
        fileOut.close();
	}
	
	public void panelLaden() throws IOException, ClassNotFoundException{
		FileInputStream fileIn = new FileInputStream("Panel.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        erhalten = (JTextPane) in.readObject();
        in.close();
        fileIn.close();
	}
}
