package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Rechner.GUI;

/**
 * Testklasse
 * Test mit einer definierten Basiszahl
 * 
 * @author Marlon, u29739, m21899
 */

public class GUITest_definierteBasis {

	GUI gui = new GUI();

	@Test
	public void test() {
		gui.txtBasis.setText("10");
		gui.txtExponent.setText("3");
		gui.btnBerechnen.doClick();
		String testAusgabe = gui.lblAusgabe.getText();
		assertEquals(testAusgabe, "1000");
	}
}
