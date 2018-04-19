package questsystem;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static String eingabe = "";
	private static int operation;
	private static String message = "Bitte gib deine Auswahl ein";
	private static boolean zustand = true;
//	private static JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		System.out.println("Willkommen im Questsystem\nVersion: 1.0\nAlle Rechte Vorbehalten");
		System.out.println("Da ich bisher noch keine Graphische Oberfläche habe, muss vorerst diese Konsolenversion herhalten");
		System.out.println("Wähle bitte aus, was du machen möchstest");
		System.out.println("1 - Neue Quest\n2 - Quest bearbeiten\n3 - Neuer Dialog\n4 - Dialog bearbeiten\n5 - vorerst nicht belegt (beenden)");
		while (zustand) {
			JFrame frame = new JFrame();
			eingabe = JOptionPane.showInputDialog(frame, message);
//			eingabe = JOptionPane.showInternalInputDialog(frame, "Bitte gib deine Auswahl ein", "Questsystem", JOptionPane.INFORMATION_MESSAGE);
			try {
				operation = Integer.parseInt(eingabe); 
			} catch (NumberFormatException e) {
//				eingabe = JOptionPane.showInternalInputDialog(frame, "Bitte gib deine Auswahl ein", "Questsystem", JOptionPane.INFORMATION_MESSAGE);
			}
			frame.dispose();
			switch (operation) {
			case 1:
				System.out.println("Eine neue Quest wird erstellt.");
				createQuest();
				zustand = false;
				break;
			case 2:
				System.out.println("Eine Quest wird bearbeitet");
				editQuest();
				zustand = false;
				break;
			case 3:
				System.out.println("Ein neuer Dialog wird erstellt");
				createDialog();
				zustand = false;
				break;
			case 4:
				System.out.println("Ein Dialog wird bearbeitet.");
				editDialog();
				zustand = false;
				break;
			default:
				System.out.println("Falsche Eingabe");
				break;
			}
		}
	}
	
	private static void createQuest() {
		
	}
	
	private static void editQuest() {
		
	}
	
	private static void createDialog() {
		
	}
	
	private static void editDialog() {
		
	}
}
