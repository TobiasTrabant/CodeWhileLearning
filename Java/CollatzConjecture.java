import javax.swing.JOptionPane;

public class CollatzConjecture {

	public static void main(String[] args) {
		int startingNumber;
		
		String startInput = JOptionPane.showInputDialog("Enter whole number to start with");
		startingNumber = Integer.parseInt(startInput);
		System.out.println(startingNumber);
		
		int currentNumber = startingNumber;
		
		while(currentNumber != 1) {
			if(currentNumber % 2 == 0) {
				currentNumber = currentNumber / 2;
				System.out.println(currentNumber);
			}else if(currentNumber % 2 != 0) {
				currentNumber = 3 * currentNumber + 1;
				System.out.println(currentNumber);
			}
		}

	}

}
