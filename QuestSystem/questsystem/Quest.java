package questsystem;

public class Quest {
	private Dialog[] dialoge;
	private String beschreibung;
	private int nummer;
	private String sonstiges;
	
	public Quest(String beschreibung, int nummer, Dialog[] dialoge) {
		this.beschreibung = beschreibung;
		this.nummer = nummer;
		this.dialoge = dialoge;
	}
	
	public Dialog[] getDialoge() {
		return dialoge;
	}
	public void setDialoge(Dialog[] dialoge) {
		this.dialoge = dialoge;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public String getSonstiges() {
		return sonstiges;
	}
	public void setSonstiges(String sonstiges) {
		this.sonstiges = sonstiges;
	}
	
	
}
