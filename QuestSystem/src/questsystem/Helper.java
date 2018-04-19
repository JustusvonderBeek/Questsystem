package questsystem;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Helper {
	
	private static JFrame frame = new JFrame();

	public String input(String frage) {
		return JOptionPane.showInputDialog(frame, frage);
	}
	
	public String toStringArrayWithLineNumber(String[] array) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result += i + ": " + array[i] + "\n";
		}
		return result;
	}
	
	public String toStringArray(String[] array) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result += array[i] + "\n";
		}
		return result;
	}
	
}
