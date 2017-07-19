import javax.swing.JOptionPane;

public class DeleteVowels {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter text");
		StringBuffer buffer = new StringBuffer(input.length());
		
		for(int i = 0; i < input.length(); i++) {
			switch(input.charAt(i)) {
			case 'a': 
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			break;
			default: buffer.append(input.charAt(i));
		}
		}
		
		String output = buffer.toString();
		
		System.out.println(output);
	}

}
