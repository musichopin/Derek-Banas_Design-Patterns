import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model

public class CalculatorController {
	
	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		// ***Tell the View that when ever the calculate button
		// is clicked execute the actionPerformed method
		// in the CalculateListener inner class***
		this.theView.addCalculateListener(new CalculateListener());
	}
	
//	***triggered when event (clicking) is done***
	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int firstNumber, secondNumber = 0;
			
			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered
			
			try{
//				***view get -> model set -> model get -> view set***
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
				
				theModel.addTwoNumbers(firstNumber, secondNumber);
//				***öncelikle view'in getiyle model set ediliyor
//				ardýndan model'ýn getiyle view set ediliyor***
				theView.setCalcSolution(theModel.getCalculationValue());
				
//				*sonucu print etmek isteseydik view'in geti kullanýlacaktý:*
//				System.out.println(theView.getCalcSolution());
				
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				theView.displayErrorMessage("You Need to Enter 2 Integers");
				
			}
			
		}
		
	}
	
}