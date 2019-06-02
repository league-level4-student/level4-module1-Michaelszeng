package _03_Switch_Statement_Practice;

import javax.swing.JOptionPane;

public class CustomButtonOptionPanes {
	public static void main(String[] args) {
		String[] options = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		int input = JOptionPane.showOptionDialog(null, "Choose a day of the week", "Custom Buttons", 0, -1, null, options, 0);

		String choice = options[input];
		
		//use a switch statement to do something cool for each option
		switch(choice) {
		case "Sunday":
			JOptionPane.showMessageDialog(null, "7");
			break;
		case "Monday":
			JOptionPane.showMessageDialog(null, "1");
			break;
		case "Tuesday":
			JOptionPane.showMessageDialog(null, "2");
			break;
		case "Wednesday":
			JOptionPane.showMessageDialog(null, "3");
			break;
		case "Thursday":
			JOptionPane.showMessageDialog(null, "4");
			break;
		case "Friday":
			JOptionPane.showMessageDialog(null, "5");
			break;
		case "Saturday":
			JOptionPane.showMessageDialog(null, "6");
			break;
		default: 
			System.out.println("Something went wrong :(");
			break;
		}
	}
}
