package questsystem;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {

	private static Quest result;
	String[] fragen = new String[1];
	String[] antworten = new String[1];
	private boolean beschreibung = false;
	private boolean sonstiges = false;
	private boolean frage = false;
	private boolean antwort = false;
	private boolean inDialog = false;
	private int dialogid = -1;
	private int fragennummer = 0;
	private int antwortennummer = 0;
	
	public UserHandler() {
		result = new Quest("Beschreibung", 0, new Dialog (0, 0, "Beschreibung", fragen, antworten));
	}
	
	public Quest returnQuest() {
		return result;
	}
	
	public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("QUEST")) {
			result.setNummer(Integer.parseInt(attributes.getValue("id")));
			int dialogAnzahl = Integer.parseInt(attributes.getValue("Dialoge"));
			Dialog[] tmp = new Dialog[dialogAnzahl];
			System.out.println("Länge des Dialogarrays: " + dialogAnzahl);
			if (dialogAnzahl > 1) {
				for (int i = 0; i < dialogAnzahl; i++) {
					tmp[i] = new Dialog(i, 0, "Beschreibung", fragen, antworten);
				}
				result.setDialoge(tmp);
			}
		}
		if (qName.equalsIgnoreCase("BESCHREIBUNG")) {
			beschreibung = true;
		}
		if (qName.equalsIgnoreCase("SONSTIGES")) {
			sonstiges = true;
		}
		if (qName.equalsIgnoreCase("DIALOG")) {
			dialogid = Integer.parseInt(attributes.getValue("id"));
			System.out.println("Dialog ID: " + dialogid);
			result.getDialoge()[dialogid].setDialognummer(dialogid);
			System.out.println("Gesetze Dialognummer: " + result.getDialoge()[dialogid].getDialognummer());
			inDialog = true;
		}
		if (qName.equalsIgnoreCase("GESPRÄCHSTEILNEHMER")) {
			result.getDialoge()[dialogid].setGespraechsteilnehmer(Integer.parseInt(attributes.getValue("Anzahl")));
		}
		if (qName.equalsIgnoreCase("FRAGENCONTAINER")) {
			fragen = new String[Integer.parseInt(attributes.getValue("Anzahl"))];	
		}
		if (qName.equalsIgnoreCase("FRAGE")) {
			fragennummer = Integer.parseInt(attributes.getValue("Nr"));
			frage = true;
		}
		if (qName.equalsIgnoreCase("ANTWORTCONTAINER")) {
			antworten = new String[Integer.parseInt(attributes.getValue("Anzahl"))];
		}
		if (qName.equalsIgnoreCase("ANTWORT")) {
			antwortennummer = Integer.parseInt(attributes.getValue("Nr"));
			antwort = true;
		}
	}

	public void endElement (String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("BESCHREIBUNG")) {
			beschreibung = false;
		}
		if (qName.equalsIgnoreCase("SONSTIGES")) {
			sonstiges = false;
		}
		if (qName.equalsIgnoreCase("FRAGE")) {
			frage = false;
		}
		if (qName.equalsIgnoreCase("ANTWORT")) {
			antwort = false;
		}
		if (qName.equalsIgnoreCase("DIALOG")) {
			inDialog = false;
			result.getDialoge()[dialogid].setFragen(fragen);
			result.getDialoge()[dialogid].setAntworten(antworten);
		}
	}
	
	public void characters (char ch[], int start, int length) throws SAXException {
		if (beschreibung && !inDialog) {
			System.out.println("Beschreibung: " + new String (ch, start, length));
			result.setBeschreibung(new String(ch, start, length));
		}
		if (beschreibung && inDialog) {
			result.getDialoge()[dialogid].setBeschreibung(new String (ch,start,length));
		}
		if (sonstiges) {
			System.out.println("Beschreibung: " + new String (ch, start, length));
			result.setSonstiges(new String(ch, start, length));
		}	
		if (frage) {
			System.out.println("Frage " + fragennummer + ": " + new String(ch, start, length));
			fragen[fragennummer] = new String(ch, start, length);
		}
		if (antwort) {
			System.out.println("Antwort " + antwortennummer + ": " + new String(ch, start, length));
			antworten[antwortennummer] = new String (ch, start, length);
		}
	}
	
}
