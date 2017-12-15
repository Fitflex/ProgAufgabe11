package Notizbuch;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * Ein Programm zum erstellen von Notizen die sich untereinander lesen.
 * 
 * @author Marlon, u29739, m21899
 */

public class Startfenster extends JFrame {

	private JPanel contentPane;
	private int counter = 0;

	public Startfenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 170);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnNotizbuch = new JButton("Notizbuch");
		btnNotizbuch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							leeren();
						} catch (IOException e) {
							e.printStackTrace();
						}
						Notizbuch notiz = new Notizbuch(counter);
						notiz.setVisible(true);
						counter++;
					}
	        	});
			}
		});
		btnNotizbuch.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNotizbuch.setBounds(10, 10, 300, 100);
		contentPane.add(btnNotizbuch);
	}
	
	public void leeren() throws IOException{
		FileWriter fw1 = new FileWriter("Save.txt");
		BufferedWriter bw1 = new BufferedWriter(fw1);		
		bw1.write("");
		bw1.close();
		
	    FileWriter fw = new FileWriter("Zwischenspeicher"+counter+".txt");
		BufferedWriter bw = new BufferedWriter(fw);		
		bw.write("");
		bw.close();
	}
}

