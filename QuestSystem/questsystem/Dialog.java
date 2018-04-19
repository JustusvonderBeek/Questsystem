package questsystem;

public class Dialog {
	private int dialognummer;
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
	
	
	
}
