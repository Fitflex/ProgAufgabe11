package Test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Notizbuch.Notizbuch;
import Notizbuch.Startfenster;

/**
 * Ein Programm zum Testen des Programmes.
 * 
 * @author Marlon, u29739, m21899
 */

public class NotizbuchTest {

	Notizbuch notiz = new Notizbuch(0);
	Startfenster start = new Startfenster();
	
	@Test
	public void test() {
		try {
			start.leeren();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		notiz.verfassen.setText("Hallo Welt!");
		try {
			notiz.lesen();
			notiz.schreiben();
			notiz.lesen();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String welttext = notiz.erhalten.getText();
		assertEquals("Hallo Welt!", welttext);
	}

}
