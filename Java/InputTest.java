import java.time.Duration;
import java.time.LocalTime;

import javax.swing.JOptionPane;

public class InputTest {

	public static void main(String[] args) {
		
		String correctString = "Fischers Fritz fischt frische Fische".toLowerCase();
		boolean inputCorrect = false;
		
		LocalTime startInput = LocalTime.now();
		String inputString = JOptionPane.showInputDialog("Enter: Fischers Fritz fischt frische Fische").toLowerCase();
		LocalTime endInput = LocalTime.now();
		
		Duration inputTime = Duration.between(startInput, endInput);
		long inputMinutes = inputTime.toMinutes();
		long inputSeconds = inputTime.getSeconds() - inputMinutes * 60;
		long inputMillis = inputTime.toMillis() - inputSeconds * 1000;
		
		if(inputString.length() == correctString.length()) {
			for(int i = 0; i < correctString.length(); i++) {
				if(inputString.charAt(i) != correctString.charAt(i)) {
					inputCorrect = false;
				}else {
					inputCorrect = true;
				}
			}
		}
		
		if(inputCorrect) {
			System.out.println("Eingabe korrekt");
		}else {
			System.out.println("Eingabe falsch");
		}
		System.out.println(inputMinutes + " Minuten " + inputSeconds + " Sekunden " + inputMillis + " Milliseconds ");

	}

}
