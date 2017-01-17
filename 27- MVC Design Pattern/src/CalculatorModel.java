// The Model performs all the calculations needed
// and that is it. It doesn't know the View 
// exists

public class CalculatorModel {

	// Holds the value of the sum of the numbers
	// entered in the view
	
	private int calculationValue;
	
//	**triggered by controller class when event (clicking) is done**
	public void addTwoNumbers(int firstNumber, int secondNumber){
		
		calculationValue = firstNumber + secondNumber;
		
	}
	
//	**triggered by controller class when event (clicking) is done**
	public int getCalculationValue(){
		
		return calculationValue;
		
	}
	
}