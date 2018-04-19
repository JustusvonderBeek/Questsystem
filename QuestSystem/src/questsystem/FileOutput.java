package questsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutput {
	private static PrintWriter writer;
	
	public static void createFile (String name, String insert) {
		try {
			File file = new File(name + ".xml");
			writer = new PrintWriter(file);
			addLine(insert);
			writer.close();
			System.out.println("Abgeschlossen");
		} catch (FileNotFoundException e) {
			System.out.println("Datei kann nicht erstellt werden.");
			System.out.println("Bitte geben Sie einen anderen Namen an.");
			e.printStackTrace();
		}
		
	}
	
	public static void oopSave(Quest quest, String filename) {
		
	}
	
	public static void save(Quest quest, String filename) {
		File file = new File("save/" + filename);
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.err.println("Beim erstellen der Datei ist ein Fehler aufgetreten.");
			e.printStackTrace();
		}
		addLine("<Questsystem Version=\"0.1\" encoding=\"UTF-8\">");
		saveQuest(quest);
		addLine("</Questsystem>");
		writer.close();
		System.out.println("Datei gespeichert unter " + filename);
	}
	
	private static void saveQuest(Quest quest) {
		addLine("<Quest id=\"" + quest.getNummer() + "\" Dialoge=\"" + quest.getDialoge().length + "\">");
		addLine("<Beschreibung>" + quest.getBeschreibung() + "</Beschreibung>");
		if (quest.getSonstiges() == null) {
			addLine("<Sonstiges>Keine Angabe</Sonstiges>");
		} else {
			addLine("<Sonstiges>" + quest.getSonstiges() + "</Sonstiges>");
		}
		saveDialog(quest.getDialoge());
		addLine("</Quest>");
	}
	
	private static void saveDialog(Dialog[] dialog) {
		for (int i = 0; i < dialog.length; i++) {
			addLine("<Dialog id=\"" + dialog[i].getDialognummer() + "\">");
			addLine("<Gesprächsteilnehmer Anzahl=\"" + dialog[i].getGespraechsteilnehmer() + "\"/>");
			addLine("<Beschreibung>" + dialog[i].getBeschreibung() + "</Beschreibung>");
			String[] localFragen = dialog[i].getFragen();
			addLine("<FragenContainer Anzahl=\"" + localFragen.length + "\">");
			for (int j = 0; j < localFragen.length; j++) {
				addLine("<Frage Nr=\"" + j + "\">" + localFragen[j] + "</Frage>");
			}
			addLine("</FragenContainer>");
			String[] localAntworten = dialog[i].getAntworten();
			addLine("<AntwortContainer Anzahl=\"" + localAntworten.length + "\">");
			for (int j = 0; j < localAntworten.length; j++) {
				addLine("<Antwort Nr=\"" + j + "\">" + localAntworten[j] + "</Antwort>");
			}
			addLine("</AntwortContainer>");
			addLine("</Dialog>");
		}
	}
	
	private static void addLine (String line) {
		writer.println(line);
	}
	
}
