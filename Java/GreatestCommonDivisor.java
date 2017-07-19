import javax.swing.JOptionPane;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		int m;
		int n;
		
		String mInput = JOptionPane.showInputDialog("Enter value number one");
		String nInput = JOptionPane.showInputDialog("Enter value number two");
		
		m = Integer.parseInt(mInput);
		n = Integer.parseInt(nInput);
		
		while(m != n) {
			if(m > n) {
				m -= n;
			}else {
				n -= m;
			}
		}
		
		System.out.println(m);

	}

}
