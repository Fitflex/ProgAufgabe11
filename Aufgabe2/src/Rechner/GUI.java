package Rechner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Ein Programm für eine einfache Berechnung.
 * Man kann eine Basiszahl und einen Exponenten definieren und dies dann berechnen lassen.
 * 
 * @author Marlon, u29739, m21899
 */

public class GUI extends JFrame {

	private JPanel contentPane;
    public JTextField txtBasis;
	public JTextField txtExponent;
	public JLabel lblBasis;
	public JLabel lblExponent;
	public JLabel lblAusgabe;
	public int intErgebnis = 0;
	public String strErgebnis;
	public int intBasis;
	public int intExponent;
	public JButton btnBerechnen;
	
	/**
	 * Hauptprogramm
	 * 
	 * Erstellen eines Fensters mit Ein-und Ausgabefenstern und einem Button 
	 */

	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBasis = new JLabel("Basis");
		lblBasis.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBasis.setBounds(49, 29, 72, 37);
		contentPane.add(lblBasis);
		
		lblExponent = new JLabel("Exponent");
		lblExponent.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblExponent.setBounds(49, 76, 125, 42);
		contentPane.add(lblExponent);
		
		txtBasis = new JTextField();
		txtBasis.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBasis.setText("Bitte hier eintragen");
		txtBasis.setColumns(10);
		txtBasis.setBounds(186, 36, 192, 31);
		contentPane.add(txtBasis);
		txtBasis.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				txtBasis.setText("");
			}
		});
		
		txtExponent = new JTextField();
		txtExponent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtExponent.setText("Bitte hier eintragen");
		txtExponent.setColumns(10);
		txtExponent.setBounds(186, 86, 192, 31);
		contentPane.add(txtExponent);
		txtExponent.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				txtExponent.setText("");
			}
		});
		
		btnBerechnen = new JButton("Berechnen");
		btnBerechnen.addActionListener(new ActionListener() {
			/**
			 * Berechnung wird bei Aktivierung des Buttons ausgeführt
			 */
			public void actionPerformed(ActionEvent arg0) {
				String strBasis = txtBasis.getText();
				String strExponent = txtExponent.getText();
				/**
				 * Überprüfung der Eingabe, ob nur Zahlen eingegeben wurden
				 */
				if(strBasis.matches("[0-9]*") && strExponent.matches("[0-9]*")){
					intBasis = Integer.parseInt(strBasis.toString());
					intExponent = Integer.parseInt(strExponent.toString());
					intErgebnis = intBasis;
					/**
					 * Berechnung
					 */
					for(int i=0; i<(intExponent-1); i++){
						intErgebnis = intErgebnis * intBasis;
					}
					strErgebnis = Integer.toString(intErgebnis);
					lblAusgabe.setText(strErgebnis);
					/**
					 * Hinweis auf falche Eingabe, bei inkorrekter Eingabe
					 */
	              } else {
	                  JOptionPane.showMessageDialog(null,"Es können nur Zahlen eingegeben werden.");
	                  lblAusgabe.setText("Bitte nur Zahlen eingeben");
	              }
			}
		});
		btnBerechnen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBerechnen.setBounds(120, 144, 172, 37);
		contentPane.add(btnBerechnen);
		
		lblAusgabe = new JLabel("Ergebnis");
		lblAusgabe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAusgabe.setBounds(49, 194, 582, 37);
		contentPane.add(lblAusgabe);
	}
}
