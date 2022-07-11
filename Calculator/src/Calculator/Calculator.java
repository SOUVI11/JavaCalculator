package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// gui and event handling and listeners
public class Calculator extends JFrame {
	// variables

	// text field
	protected static JTextField textField; // where the user will see his input

	// text area
	protected static JTextArea history; // history output

	// buttons
	private JButton button;

	// label
	private JLabel historyLabel; // history area label

	// panels;
	private JPanel forText; // for the text field
	private JPanel mainButtons; // for all the buttons
	private JPanel memoryButtons; // for the memory buttons
	private JPanel allButtons; // add all buttons together
	private JPanel bigPanel; // the big panel where all the panels goes into
	private JPanel historyPanel; // the panel for the text area and history label

	// listeners
	protected static String buttonLabel = ""; // labels for the buttons
	protected static String elements = ""; // where we form the numbers and operators for storing to the array

	protected static int max = 100; // maximum number of elements input from the user.

	protected static String infixArray[] = new String[max]; // users input
	protected static int infixArrayCount = 0; // the index of the next available spot for the user input

	protected static String postfixArray[] = new String[max]; // POSTFIX RESULT
	protected static int postfixArrayCount; // the count of the postfixStackArray

	// button listener
	private ButtonListener readLabel = new ButtonListener();

	// memoryButtons variables
	protected static String MS = ""; // where we store in memory

	// constructor GUI
	public Calculator() {
		super("G4 Calculator");// title name
		// text field
		forText = new JPanel();// the panel for the text field
		textField = new JTextField("", 25); // the text field with no predefined text, and a limit of 25 characters
		//label
		textField.setHorizontalAlignment(JTextField.RIGHT); // the position of the input (right)
		textField.setEditable(false); // no input from the keyboard - input just from the buttons
		textField.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		//font color white
		textField.setForeground(Color.cyan); // set the font color white (default is black)
		textField.setFont(new Font("Arial", Font.BOLD, 15)); // change the font and size of the textfield
		forText.setLayout(new GridLayout(1, 1));
		forText.add(textField); // adding the text field to the panel
		forText.setPreferredSize(new Dimension(300, 100)); // setting the panel size of input area

		// all buttons
		mainButtons = new JPanel(); // the panel for all the buttons
		mainButtons.setLayout(new GridLayout(6, 4, 3, 3)); // 6 rows, 4 columns, 3 space between buttons

		// // FIRST ROW
		// space = new JPanel(); // added spaces instead of button
		// mainButtons.add(space);
		// space = new JPanel();

		//pi button
		button = new JButton("\u03c0"); // pi button
		button.setPreferredSize(new Dimension(100, 100)); // set the size of the button
		button.setBackground(Color.darkGray); // set the background color to dark gray
		button.setForeground(Color.cyan); // set the font color to white
		button.setFont(new Font("Arial", Font.BOLD, 15)); // change the font and size of the button
		button.addActionListener(readLabel); // add the listener to the button
		mainButtons.add(button); // add the button to the panel

		

		// exponential button-->in progress
		button = new JButton("^"); // the button for the exponential function
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Exponential"); // tooltip for the button
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)

        button = new JButton("!");	// the button for the factorial
		button.addActionListener(readLabel);
		mainButtons.add(button);		
		button.setToolTipText("Factorial");	
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)



		// delete button -> /u232b is the unicode for backspace symbol
		button = new JButton("\u232b"); // the button for the backspace function
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Backspace");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)
		// END FIRST ROW

		// adding the main buttons

		// clear button
		button = new JButton("C");
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Clear");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)
		// parentheses button
		button = new JButton("(");
		button.addActionListener(readLabel);
		button.setToolTipText("Open Parenthese");
		mainButtons.add(button);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)
		// modular button
		button = new JButton(")");
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Close Parenthese");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)
		// division button
		button = new JButton("/");
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Division");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)
		// 7 button
		button = new JButton("7");
		button.addActionListener(readLabel);
		button.setBackground(Color.cyan);
		mainButtons.add(button);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// 8 button
		button = new JButton("8");
		button.addActionListener(readLabel);
		button.setBackground(Color.cyan);
		mainButtons.add(button);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// 9 button
		button = new JButton("9");
		button.addActionListener(readLabel);
		button.setBackground(Color.cyan);
		mainButtons.add(button);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// multiplication button
		button = new JButton("*");
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Multiplication");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)
		// 4 button
		button = new JButton("4");
		button.addActionListener(readLabel);
		button.setBackground(Color.cyan);
		mainButtons.add(button);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// 5 button
		button = new JButton("5");
		button.addActionListener(readLabel);
		button.setBackground(Color.cyan);
		mainButtons.add(button);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// 6 button
		button = new JButton("6");
		button.addActionListener(readLabel);
		button.setBackground(Color.cyan);
		mainButtons.add(button);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// subtraction button
		button = new JButton("-");
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Subtraction");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)
		// 1 button
		button = new JButton("1");
		button.addActionListener(readLabel);
		button.setBackground(Color.cyan);
		mainButtons.add(button);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// 2 button
		button = new JButton("2");
		button.addActionListener(readLabel);
		button.setBackground(Color.cyan);
		mainButtons.add(button);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// 3 button
		button = new JButton("3");
		button.addActionListener(readLabel);
		button.setBackground(Color.cyan);
		mainButtons.add(button);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// + button
		button = new JButton("+");
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Addition");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)
		// negative button
		button = new JButton("\u2212");
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Negative Number");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// 0 button
		button = new JButton("0");
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setBackground(Color.cyan);
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		// decimal point button
		button = new JButton(".");
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Decimal Point");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.white); // set the font color white (default is black)
		
		// equal button
		button = new JButton("=");
		button.addActionListener(readLabel);
		mainButtons.add(button);
		button.setToolTipText("Equal");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.black); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)
		// set the dimensions to the button's panel
		mainButtons.setPreferredSize(new Dimension(300, 300));

		// MEMORY buttons
		memoryButtons = new JPanel(); // the panel for the memory buttons
		memoryButtons.setLayout(new GridLayout(1, 3, 2, 2)); // 1 row and 3 colums

		button = new JButton("MS"); // memory 1
		button.addActionListener(readLabel);
		button.setToolTipText("Store in memory");
		button.setFont(button.getFont().deriveFont(20f));
		memoryButtons.add(button); // adding the button to the panel
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)

		button = new JButton("MR"); // memory 2
		button.addActionListener(readLabel);
		memoryButtons.add(button); // adding the button to the panel
		button.setToolTipText("Memory Recall");
		button.setFont(button.getFont().deriveFont(20f));
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)

		button = new JButton("MC"); // memory 1
		button.addActionListener(readLabel);
		button.setToolTipText("Clear Memory");
		button.setFont(button.getFont().deriveFont(20f));
		memoryButtons.add(button); // adding the button to the panel
		button.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		button.setForeground(Color.cyan); // set the font color white (default is black)

		// the panel for all panels with buttons
		allButtons = new JPanel();
		allButtons.setLayout(new BorderLayout());
		allButtons.add(mainButtons, BorderLayout.NORTH);
		allButtons.add(memoryButtons, BorderLayout.SOUTH);



		// history screen
		history = new JTextArea();
		history.setPreferredSize(new Dimension(320, 410));
		history.setEditable(false); // no input from the user, just display the history
		history.setFont(new Font("Arial", Font.BOLD, 16));
		history.setBackground(Color.cyan);
		historyLabel = new JLabel("HISTORY:");
		history.setBackground(Color.darkGray); // set the background white (default is grey from not being editable)
		history.setForeground(Color.cyan); // set the font color white (default is black)
		//hisory

		// panel for the history text area and history label
		historyPanel = new JPanel();
		historyPanel.setLayout(new BorderLayout());
		historyPanel.add(historyLabel, BorderLayout.NORTH);
		historyPanel.add(history, BorderLayout.SOUTH);

		// adding all panels to the main panel
		bigPanel = new JPanel();
		bigPanel.setLayout(new BorderLayout());
		bigPanel.add(forText, BorderLayout.NORTH);
		bigPanel.add(allButtons, BorderLayout.SOUTH);


		// add the big panel to the frame;
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(bigPanel);
		add(historyPanel);
		pack();
	} // end GUI

	// LISTENERS
	// listeners for number buttons
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent readLabel) {
			// getting the labels symbols from the buttons and print
			// them to the text field
			buttonLabel = readLabel.getActionCommand();
			textField.setText(textField.getText() + buttonLabel);

			// CLEAR button
			if (buttonLabel.equals("C"))
				ButtonFunction.clear();

			// BACKSPACE button
			if (buttonLabel.equals("\u232b"))
				ButtonFunction.backspace();

			// NUMBER buttons
			if (buttonLabel.equals("0")) // if the condition is true: the user presses a DIGIT button
				ButtonFunction.operandButton();

			else if (buttonLabel.equals("1"))
				ButtonFunction.operandButton();

			else if (buttonLabel.equals("2"))
				ButtonFunction.operandButton();

			else if (buttonLabel.equals("3"))
				ButtonFunction.operandButton();

			else if (buttonLabel.equals("4"))
				ButtonFunction.operandButton();

			else if (buttonLabel.equals("5"))
				ButtonFunction.operandButton();

			else if (buttonLabel.equals("6"))
				ButtonFunction.operandButton();

			else if (buttonLabel.equals("7"))
				ButtonFunction.operandButton();

			else if (buttonLabel.equals("8"))
				ButtonFunction.operandButton();

			else if (buttonLabel.equals("9"))
				ButtonFunction.operandButton();
			// DECIMAL POINT
			else if (buttonLabel.equals("."))
				ButtonFunction.checkDecimalPoint();
			// NEGATIVE SIGN
			else if (buttonLabel.equals("\u2212"))
				ButtonFunction.negativeSign();
				//button label for pi
			else if (buttonLabel.equals("\u03c0"))
				ButtonFunction.operandButton();
			// end NUMBERS

			// OPERATORS
			// DIVISION button
			if (buttonLabel.equals("/"))
				ButtonFunction.operatorButton();

			// EXPONENTIAL button
			else if (buttonLabel.equals("^"))
				ButtonFunction.operatorButton();

			// FACTORIAL button
			else if (buttonLabel.equals("!"))
				ButtonFunction.operatorButton();
			// MULTIPLICATION button
			else if (buttonLabel.equals("*"))
				ButtonFunction.operatorButton();

			// MINUS button
			else if (buttonLabel.equals("-"))
				ButtonFunction.operatorButton();

			// PLUS button
			else if (buttonLabel.equals("+"))
				ButtonFunction.operatorButton();

			// OPEN parentheses button
			else if (buttonLabel.equals("("))
				ButtonFunction.operatorButton();

			// CLOSE parentheses button
			else if (buttonLabel.equals(")"))
				ButtonFunction.operatorButton();

			// EQUAL button
			else if (buttonLabel.equals("="))
				ButtonFunction.equal();

			// MEMORY buttons
			// MEMORY STORE BUTTON
			if (buttonLabel.equals("MS"))
				ButtonFunction.memoryStore();

			// MEMORY CLEAR BUTTON
			if (buttonLabel.equals("MC"))
				ButtonFunction.memoryClear();

			// RECALL MEMORY BUTTON
			if (buttonLabel.equals("MR"))
				ButtonFunction.memoryRecall();

			// FOR PROGRAMMERS USE:
			// visualize the elements into the array - CONSOLE READING
			System.out.println("*************************************************");
			for (int i = 0; i < infixArrayCount + 1; i++) {
				if (infixArray[i] != null)
					System.out.println(infixArray[i] + " INFIX " + i + "\t");
			}
			System.out.println("=================================================");
		}
	} // end of LISTENTERS
}
