// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it. 

import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorView extends JFrame{

	private JTextField firstNumber  = new JTextField(10);
	private JLabel additionLabel = new JLabel("+");
	private JTextField secondNumber = new JTextField(10);
	private JButton calculateButton = new JButton("Calculate");
	private JTextField calcSolution = new JTextField(10);
	
	CalculatorView(){
		
		// Sets up the view and adds the components
		
		JPanel calcPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);
		
		calcSolution.setEditable(false);
		
		calcPanel.add(firstNumber);
		calcPanel.add(additionLabel);
		calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		
		this.add(calcPanel);
		
		// End of setting up the components --------
		
	}
	
//	**triggered when event (clicking) is done**
	public int getFirstNumber(){
		
		return Integer.parseInt(firstNumber.getText());
		
	}
	
//	**triggered when event (clicking) is done**
	public int getSecondNumber(){
		
		return Integer.parseInt(secondNumber.getText());
		
	}
	
//	**not used but declared in case of need**
	public int getCalcSolution(){
		
		return Integer.parseInt(calcSolution.getText());
		
	}
	
//	**triggered when event (clicking) is done**
	public void setCalcSolution(int solution){
		
//		*we gotta convert to string*
		calcSolution.setText(Integer.toString(solution));
		
	}
	
	// Open a popup that contains the error message passed
//	**triggered when event (clicking) is done and error found**
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
	
	// ***If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed.
	//	(this statement prepares the event handling)***
	void addCalculateListener(ActionListener listenForCalcButton){
//		**alt: addCalculateListener(CalculatorController.CalculateListener listenForCalcButton)**
		
		calculateButton.addActionListener(listenForCalcButton);
//		**calculateButton private olduðu için calculatorview classý dýþýnda kullanýlamýyor**
	}
	
}