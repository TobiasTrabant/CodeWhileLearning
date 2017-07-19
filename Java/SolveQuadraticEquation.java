import javax.swing.JOptionPane;

public class SolveQuadraticEquation {

	public static void main(String[] args) {
		String aInput;
		String bInput;
		String cInput;
		
		aInput = JOptionPane.showInputDialog("Enter value for a");
		bInput = JOptionPane.showInputDialog("Enter value for b");
		cInput = JOptionPane.showInputDialog("Enter value for c");
		
		double aValue = Double.parseDouble(aInput);
		double bValue = Double.parseDouble(bInput);
		double cValue = Double.parseDouble(cInput);
		
		double calculateD = bValue * bValue - 4 * aValue * cValue;
		
		if(calculateD == 0) {
			JOptionPane.showMessageDialog(null, "There is one solution");		
		}else if (calculateD > 0) {
			JOptionPane.showMessageDialog(null, "There are two solutions");
		}else if(calculateD < 0) {
			JOptionPane.showMessageDialog(null, "There is no solution");
		}
	}
}
