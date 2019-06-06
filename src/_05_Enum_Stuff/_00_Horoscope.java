package _05_Enum_Stuff;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class _00_Horoscope {
	// 1. Create an enum in a separate file called Zodiac that contains a category for
	//    all 12 zodiac signs.
	
	// 2. Write a method that takes in a Zodiac enum object and uses a JOPtionPane to display
	//    a different horoscope based on the Zodiac's state.
	public static void showHoroscope(Zodiac z) {
		switch(z) {
		
		case ARIES:
			JOptionPane.showMessageDialog(null, "ARIES horoscope");
			break;
		}
	}
	
	public static void otherRandomTest(int i) {
		switch(i) {
			
		case 7:
			System.out.println("WORKS");
			break;
		
		}
	}
	// 3. Make a main method to test your method
	public static void main(String[] args) {
		Zodiac z = Zodiac.ARIES;
		//showHoroscope(z);
		ArrayList<String> a = new ArrayList<String>();
		a.add("s");
		a.add("STRING");
		otherRandomTest(7);
	}
}
