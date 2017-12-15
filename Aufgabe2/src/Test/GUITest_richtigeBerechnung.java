package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Rechner.GUI;

/**
 * Testklasse
 * Test einer richtigen Berechnung
 * 
 * @author Marlon, u29739, m21899
 */

public class GUITest_richtigeBerechnung {

	GUI gui = new GUI();

	@Test
	public void test() {
		gui.txtBasis.setText("2");
		gui.txtExponent.setText("4");
		gui.btnBerechnen.doClick();
		String testAusgabe = gui.lblAusgabe.getText();
		assertEquals(testAusgabe, "16");
	}
}
