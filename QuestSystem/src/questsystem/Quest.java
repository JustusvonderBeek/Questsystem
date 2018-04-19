package questsystem;

public class Quest {
	private Dialog[] dialoge;
	private String beschreibung;
	private int id;
	private String sonstiges;

	public Quest(String beschreibung, int nummer, Dialog[] dialoge) {
		this.beschreibung = beschreibung;
		this.id = nummer;
		this.dialoge = dialoge;
	}
	
	public Quest(String beschreibung, int nummer, Dialog dialoge) {
		this.beschreibung = beschreibung;
		this.id = nummer;
		Dialog[] localBridge = new Dialog[1];
		localBridge[0] = dialoge;
		this.dialoge = localBridge;
	}

	public Dialog[] getDialoge() {
		return dialoge;
	}

	public void setDialoge(Dialog[] dialoge) {
		this.dialoge = dialoge;
	}
	
	public void setDialoge(Dialog dialoge) {
		this.dialoge[0] = dialoge;
	}
	
	public void setDialogeAt (int number, Dialog dialog) {
		dialoge[number] = dialog;
	}

	public Dialog getDialogAt (int number) {
		return dialoge[number];
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public int getNummer() {
		return id;
	}

	public void setNummer(int nummer) {
		this.id = nummer;
	}

	public String getSonstiges() {
		return sonstiges;
	}

	public void setSonstiges(String sonstiges) {
		this.sonstiges = sonstiges;
	}

	@Override
	public String toString() {
		String result = "";
		result += "Quest ID: " + id + "\n";
		result += "Beschreibung: " + beschreibung + "\n";
		result += "Sonstiges: " + sonstiges + "\n";
		for (int i = 0; i < dialoge.length; i++) {
			result += dialoge[i] + "\n";
		}
		result += "-------------------\n";
		return result;
	}
	
}
