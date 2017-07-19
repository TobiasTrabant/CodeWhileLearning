import javax.swing.JOptionPane;

public class BackwardsReader2 {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter Text");
		String output = "";
		for(int i = input.length() ; i > 0; i--) {
			output += input.charAt(i - 1);
		}
		JOptionPane.showMessageDialog(null, output);
	}
}
