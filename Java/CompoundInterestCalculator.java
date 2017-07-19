import javax.swing.JOptionPane;

public class CompoundInterestCalculator {

	public static void main(String[] args) {
		int years;
		double startCapital;
		double interest;
		
		String yearsInput = JOptionPane.showInputDialog("Enter the number of years that the capital will be invested");
		String startCapitalInput = JOptionPane.showInputDialog("Enter your starting capital");
		String interestInput = JOptionPane.showInputDialog("Enter yearly interest rate");
		
		years = Integer.parseInt(yearsInput);
		startCapital = Double.parseDouble(startCapitalInput);
		interest = Double.parseDouble(interestInput);
		
		int counter = 0;
		double previousOutput = startCapital;
		
		while(counter < years) {
			double output = previousOutput * (1 + interest / 100); 
			System.out.println(output);
			previousOutput = output;
			counter++;
		}

	}

}
