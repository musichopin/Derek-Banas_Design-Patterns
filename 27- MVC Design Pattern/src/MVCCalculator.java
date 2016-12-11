public class MVCCalculator {
    
//	Main could access the view, but the controller does all of the work. 
//	we don’t want to tightly couple the view and controller by having the view created by the controller
    public static void main(String[] args) {
    	
    	CalculatorView theView = new CalculatorView();
        
    	CalculatorModel theModel = new CalculatorModel();
        
        CalculatorController theController = new CalculatorController(theView,theModel);
        
        theView.setVisible(true);
//     **daha doðrusu calculatorview class içerisinde "this.setVisible(true);" demekti**
        
    }
}