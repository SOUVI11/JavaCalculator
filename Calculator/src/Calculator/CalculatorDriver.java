package Calculator;

import javax.swing.JFrame;

public class CalculatorDriver {
	public static void main(String[] args) {
		//isEqual
		System.out.println(ArithmeticOperations.isEqual("abc","abc"));
		Calculator myWindow = new Calculator();// create a new window
		myWindow.setLocation(500, 200);// set the location of the window
		myWindow.setVisible(true);// set the window to visible
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// set the window to close when the X is clicked
	}
}
