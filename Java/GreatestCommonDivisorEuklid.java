import javax.swing.JOptionPane;

public class GreatestCommonDivisorEuklid {

	public static void main(String[] args) {
		int m;
		int n;
		int r;
		
		String mInput = JOptionPane.showInputDialog("Enter value number one");
		String nInput = JOptionPane.showInputDialog("Enter value number two");
		
		m = Integer.parseInt(mInput);
		n = Integer.parseInt(nInput);
		r = m % n;
		
		while(r > 0) {
			m = n;
			n = r;
			r = m % n;
		}
		
		System.out.println(n);

	}

}
