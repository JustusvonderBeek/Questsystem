package questsystem;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	private static String eingabe = "";
	private static int operation;
	private static String message = "Bitte gib deine Auswahl ein";
	private static boolean zustand = true;
	private static JFrame frame = new JFrame();
	private static int internQuestNumber = 0;
	private static Quest quest;
	private static Dialog dialog;
	private static Dialog[] dialoge;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Willkommen im Questsystem\nVersion: 1.0\nAlle Rechte Vorbehalten");
		System.out.println("Da ich bisher noch keine Graphische Oberfläche habe, muss vorerst diese Konsolenversion herhalten");
		System.out.println("Wähle bitte aus, was du machen möchstest");
		System.out.println("1 - Neue Quest\n2 - Quest bearbeiten\n3 - Neuer Dialog\n4 - Dialog bearbeiten\n5 - vorerst nicht belegt (beenden)");
		FileOutput.createFile("Test", "Das ist ein einfacher Test");	// Hier kann der Pfadname mit angegeben werden, und darunter wird die Datei gespeichert
		while (zustand) {
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
				zustand = false;
				break;
			case 5:
				System.out.println("Programm wird beendet...");
				System.exit(0);
			default:
				System.out.println("Falsche Eingabe");
				break;
			}
		}
		FileOutput printer = new FileOutput();
		printer.save(quest, "QuestsystemTest");
		System.out.println(quest);
		System.exit(0);
	}
	
	private static void createQuest() {
		int tmpInt = 0;
		boolean schleife = true;
		eingabe = JOptionPane.showInputDialog(frame, "Bitte geben Sie eine Beschreibung ein.");
		String tmp = eingabe;
		frame.dispose();
		while (schleife) {
			eingabe = JOptionPane.showInputDialog(frame, "Wie viele Dialogreihen soll die Quest beinhalten?");
			try {
				tmpInt = Integer.parseInt(eingabe);
				if (tmpInt <= 0) {
					System.out.println("Negative oder keine Dialogreihe sind nicht möglich!");
					continue;
				}
				dialoge = new Dialog[tmpInt];
				schleife = false;
				continue;
			} catch (NumberFormatException e) {
				System.out.println("Fehler bei der Eingabe der Questzahlnummer.");
			}
		}
		createDialog();
		if (tmpInt == 1) {
			quest = new Quest(tmp, internQuestNumber++, dialog);
		} else {
			quest = new Quest(tmp, internQuestNumber++, dialoge);
		}
	}
	
	private static void editQuest() {
		System.out.println("Bearbeite Quest...\n-------------------------");
		FileReader reader = new FileReader();
		quest = reader.ReadFiles("QuestsystemTest");
		System.out.print("Was soll bearbeitet werden?");
		dialoge = quest.getDialoge();
		System.out.println("Zum Test kannst du die Fragen bearbeiten");
		Editing edit = new Editing(quest);
		edit.editFragen();
		quest = edit.writeBack();
		FileOutput printer = new FileOutput();
		printer.save(quest, "QuestsystemTest2");
		System.out.println("Die geänderte Quest:");
		System.out.println(quest);
	}
	
	private static void createDialog() {
		int gesprächsteilnehmer = 0;
		int fragenNummer = 0;
		int antwortenNummer = 0;
		boolean schleife = true;
		int tmp = Integer.parseInt(eingabe);
		for (int i = 0; i < tmp; i++) {
			System.out.println("Eine neue Dialogreihe wird erstellt.");
			while (schleife) {
				try {
					gesprächsteilnehmer = Integer.parseInt(JOptionPane.showInputDialog(frame, "Bitte geben Sie die Anzahl an Gesprächsteilnehmern an."));
					if (gesprächsteilnehmer <= 0) {
						System.out.println("Negative oder keine Gesprächsteilnehmer sind nicht möglich!");
						continue;
					}
					schleife = false;
					continue;
				} catch (NumberFormatException e) {
					System.out.println("Ihre Eingabe konnte nicht verarbeitet werden. Bitte wiederholen Sie die Eingabe");
				}
			}
			schleife = true;
			String beschreibung = JOptionPane.showInputDialog(frame, "Bitte geben Sie eine Beschreibung ein.");
			while (schleife) {
				try {
					fragenNummer = Integer.parseInt(JOptionPane.showInputDialog(frame, "Wie viele Fragen sollen erstellt werden?"));
					if (fragenNummer <= 0) {
						System.out.println("Negative oder keine Fragen sind nicht möglich!");
						continue;
					}
					schleife = false;
					continue;
				} catch (NumberFormatException e) {
					System.out.println("Ihre Eingabe konnte nicht verarbeitet werden. Bitte wiederholen Sie die Eingabe");
				}
			}
			schleife = true;
			String[] fragen = new String[fragenNummer];
			for (int j = 0; j < fragen.length; j++) {
				fragen[j] = JOptionPane.showInputDialog(frame, "Gib die Frage " + j + " ein.");
			}
			while (schleife) {
				try {
					antwortenNummer = Integer.parseInt(JOptionPane.showInputDialog(frame, "Wie viele Antworten sollen erstellt werden?"));
					if (antwortenNummer <= 0) {
						System.out.println("Negative oder keine Antworten sind nicht möglich!");
						continue;
					}
					schleife = false;
					continue;
				} catch (NumberFormatException e) {
					System.out.println("Ihre Eingabe konnte nicht verarbeitet werden. Bitte wiederholen Sie die Eingabe");
				}
			}
			String[] antworten = new String[antwortenNummer];
			for (int j = 0; j < antworten.length; j++) {
				antworten[j] = JOptionPane.showInputDialog(frame, "Gib die Antwort " + j + " ein.");
			}
			if (tmp == 1) {
				dialog = new Dialog(i, gesprächsteilnehmer, beschreibung, fragen, antworten);
			} else {
				dialoge[i] = new Dialog(i, gesprächsteilnehmer, beschreibung, fragen, antworten);
			}
		}
	}
}
