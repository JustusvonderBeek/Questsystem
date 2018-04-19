package questsystem;

public class Dialog {
	private static int counter = 0;
	private int dialognummer = counter++;
	private int gespraechsteilnehmer;
	private String beschreibung;
	private String[] fragen;
	private String[] antworten;
	
	public Dialog(int dialognummer, int gespraechsteilnehmer, String beschreibung, String[] fragen,
			String[] antworten) {
		this.dialognummer = dialognummer;
		this.gespraechsteilnehmer = gespraechsteilnehmer;
		this.beschreibung = beschreibung;
		this.fragen = fragen;
		this.antworten = antworten;
	}
	
	public void addFrage(String frage) {
		enlargeFragen(1);
		fragen[fragen.length-1] = frage;
		System.out.println(" -- Neue Frage angefügt -- ");
		printDialog();
	}
	
	public void removeFrage(int index) {
		String removedQuestion = fragen[index];
		for (int i = index; i < fragen.length-1; i++) {
			fragen[i] = fragen[i+1];
		}
		shortenFragen(1);
		System.out.println(" -- Frage: " + removedQuestion + " an Index " + index + " entfernt.");
		printDialog();
	}
	
	public void editFrage(int index, String newFrage) {
		fragen[index] = newFrage;
		printDialog();
	}
	
	private void shortenFragen(int amount) {
		if (amount > fragen.length) {
			throw new RuntimeException("Anzahl an zu kürzenden Feldern größer als das Array");
		} else {
			String[] newFragen = new String[fragen.length-amount];
			for (int i = 0; i < newFragen.length; i++) {
				newFragen[i] = fragen[i];
			}
			setFragen(newFragen);
			printDialog();
		}
	}
	
	private void enlargeFragen(int amount) {
		if (fragen.length + amount > 4 * fragen.length) {
			System.out.println("Sicher, dass die 4-fache Größe richtig ist?");
		}
		String[] newFragen = new String[fragen.length + amount];
		for (int i = 0; i < fragen.length; i++) {
			newFragen[i] = fragen[i];
		}
		System.out.println("Die Fragen um " + amount + " Felder vergrößert");
		setFragen(newFragen);
		printDialog();
	}
	
	public void editAntwort(int index, String newAntwort) {
		antworten[index] = newAntwort;
		printDialog();
	}
	
	public int getDialognummer() {
		return dialognummer;
	}
	
	public void setDialognummer(int dialognummer) {
		this.dialognummer = dialognummer;
	}
	
	public int getGespraechsteilnehmer() {
		return gespraechsteilnehmer;
	}
	
	public void setGespraechsteilnehmer(int gespraechsteilnehmer) {
		this.gespraechsteilnehmer = gespraechsteilnehmer;
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}
	
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	public String[] getFragen() {
		return fragen;
	}
	
	public void setFragen(String[] fragen) {
		this.fragen = fragen;
	}
	
	public String[] getAntworten() {
		return antworten;
	}
	
	public void setAntworten(String[] antworten) {
		this.antworten = antworten;
	}
	
	private void printDialog() {
		System.out.println("Für Debugzwecke Fragen:\n - " + toStringArray(fragen));
	}
	
	private String toStringArray(String[] array) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				result += i + ": -- Noch nicht ausgefüllt -- \n";
			} else {
				result += i + ": " + array[i] + "\n";
			}
		}
		return result;
	}
	
	public String toString() {
		String result = "Dialog Nummer: " + dialognummer + "\n";
		result += "Beschreibung: " + beschreibung + "\n\nFragen: \n";
		result += toStringArray(fragen);
		result += "Antworten: \n";
		result += toStringArray(antworten);
		return result;
	}
	
}
