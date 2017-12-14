package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Rechner.GUI;

/**
 * Testklasse
 * Test mit einer falschen Eingabe
 * 
 * @author Marlon, u29739, m21899
 */
public class GUITest_falscheEingabe extends GUI{
	
	GUI gui = new GUI();
	
	@Test
	public void test() {
		gui.txtBasis.setText("2");
		gui.txtExponent.setText("s");
		gui.btnBerechnen.doClick();	
		String testAusgabe = gui.lblAusgabe.getText();
		assertEquals(testAusgabe, "Bitte nur Zahlen eingeben");
	}
}
