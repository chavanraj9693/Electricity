/*
	ELECTRICITY BILL CALCULATOR
	GUI based program in JAVA to calculate electricity cost based on per unit charges.
	Using Java Swing and AWT.
*/

import java.awt.event.*;  
import java.awt.Color;
import javax.swing.*;  


public class Electricity
{
	// Function to calculate the total cost of electricity of the passed units. 
	static int calculate(int units)
	{
		/**
		 * ELECTRICITY CHARGES
		 * First 100 units: INR 10 / unit
		 * Second 100 units: INR 15 / unit
		 * Third 100 units: INR 20 / unit
		 * Units above 300: INR 25 / unit
		 * */

		if (units <= 100)
		{
			return units*10;
		}
		else if (units <= 200)
		{
			return (100 * 10) + ((units - 100) * 15);
		}
		else if (units <= 300)
		{
			return (100 * 10) + (100 * 15) + ((units - 200) * 20);
		}
		else return (100 * 10) + (100 * 15) + (100 * 20) + ((units - 300) * 25);
	}

	// Function to convert KWh to Kilo Joules
	static int kwhToJoules(int units)
	{
		return (units)*3600;
	}

	// Function to calculate the truncated percentage of users consumption compared to average Indian consumtion. 
	static int calConsumtion(int units)
	{
		// Average per capita per month consumtion in India is 210 KWh (units).
		// Source: statista.com/statistics/597796/household-consumption-of-electricity-per-capita-in-india/
		double percentage = ( units / 210.0) * 100.0;
		return (int) percentage; 
	}

	// Functiont to check wether the passed string is numeric
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) 
	    {
	    	return false;    
	    }
	    try 
	    {
	        int i = Integer.parseInt(strNum);
	    } 
	    catch (NumberFormatException nfe) 
	    {
	        return false;
	    }
	    return true;
	}

	// main function starts here
	public static void main(String[] args) 
	{  
		// Creating instance of JFrame with the title
		JFrame frame = new JFrame("Electricity Bill Calculator");  

		// Creating the title label (instacne of JLabel)
		JLabel title = new JLabel("<html><h1><b>Electricity Bill Calculator</b></h1></html>");
		// Setting bounds of the JComponent: x axis, y axis, width, height 
		title.setBounds(0,50,400,30); 
		// Setting the text alignment to center
		title.setHorizontalAlignment(SwingConstants.CENTER);

		// Creating the hint label (inctance of JLabel)
		JLabel label1 = new JLabel("Enter the number of units");
		// Setting bounds of the JComponent: x axis, y axis, width, height 
		label1.setBounds(125, 100, 150, 30);

		// Creating the Text Field for the input (instance of JTextField)
		JTextField textfield1 = new JTextField();
		// Setting bounds of the JComponent: x axis, y axis, width, height 
		textfield1.setBounds(125, 130, 150, 30);           

		// Creating the Calculate button (instance of JButton)
		JButton button1 = new JButton("Calculate"); 
		// Setting bounds of the JComponent: x axis, y axis, width, height 
		button1.setBounds(150, 180, 100, 40);

		// Creting the results label (instance of JLabel)
		JLabel result = new JLabel();
		// Setting bounds of the JComponent: x axis, y axis, width, height
		result.setBounds(20,230,360,150);
		// Setting the text alignment to center
		result.setHorizontalAlignment(SwingConstants.CENTER);
		// Making the label invisible (initially)
		result.setVisible(false);

		// Creting the save electricity label (instance of JLabel)
		JLabel label2 = new JLabel("Save Electricity, Save the Planet!");
		// Setting bounds of the JComponent: x axis, y axis, width, height
		label2.setBounds(0,400,400,30);
		// Setting the text alignment to center
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Adding an ActionListener to the button to detect clicks
		button1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					// Taking the input from the textfield1 and storing it in a variable
					String text = textfield1.getText();

					// Varialbe to store the string to be displayed by the result label
					String resultString;

					// Checking if the input is numeric (Input Validation)
					if (isNumeric(text))
					{
						// Storing the number of units in an integer variale
						int units = Integer.parseInt(text);

						// Preparing the resultString
						resultString = 
						"<html><body><center><h3>" +
						"Results<br>" +
						"Total Energy Consumtion: " + kwhToJoules(units) + " KiloJoules<br>" +
						"Electricity Cost: INR " + calculate(units) + "<br><br>" +
						"You consume " + calConsumtion(units) + "% of the per capita / month consumtion of India" +
						"</h3></center></body></html>";

						//\u20B9 is the escape sequence for the Indian Rupee Unicode symbol
					}
					else
					{
						// Storing the error message in resultString
						resultString =
						"<html><body><center><h3>" +
						"Please enter a valid numeric value" +
						"</h3></center></body></html>";
					}

					// Setting the text of the result label to resultString
					result.setText(resultString);
					// Making the result label visible
					result.setVisible(true);
				}
			});  

		// Adding all the components to the frame
		frame.add(title);
		frame.add(label1);
		frame.add(textfield1);
		frame.add(button1); 
		frame.add(result);
		frame.add(label2);
		 
		// Setting the size of the frame to 400 width and 500 height          
		frame.setSize(400,500);
		// Setting the background color to blue
		frame.getContentPane().setBackground(Color.yellow);
		// Setting the Calculate button as the default button
		frame.getRootPane().setDefaultButton(button1);
		// Using no layout managers   
		frame.setLayout(null);
		// Making the frame visible 
		frame.setVisible(true);   
	}  

}  