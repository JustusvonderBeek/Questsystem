package questsystem;

public class Editing {

	private Quest quest;
	private Dialog[] dialog;
	private Dialog localDialog;
	private Helper help = new Helper();
	private String eingabe = "";
	private int dialogid = -1;
	
	public Editing(Quest quest) {
		this.quest = quest;
		this.dialog = quest.getDialoge();
		for (int i = 0; i < dialog.length; i++) {
			System.out.println("Dialog " + dialog[i].getDialognummer() + ": " + dialog[i].getBeschreibung());
		}
		boolean schleife = true;
		while(schleife) {
			eingabe = help.input("Welche Dialogreihe wollen Sie bearbeiten?");
			try {
				dialogid = Integer.parseInt(eingabe);
				if (dialogid < 0 || dialogid >= dialog.length) {
					System.out.println("Die zu bearbeitende Dialogreihe existiert nicht");
					continue;
				} else {
					localDialog = dialog[dialogid];
					schleife = false;
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("Keine gültige Nummer. Eingabe bitte wiederholen.");
			}
		}
		
	}
	
	
	public void editFragen() {
		int fragenAnzahl;
		boolean outerSchleife = true;
		boolean schleife = true;
		System.out.println("\nFragen:\nWas soll bearbeitet werden?\n 1 - Anzahl an Fragen\n 2 - Eine bestimmte Frage\n 3 - Alle Fragen löschen\n 4 - Alle Fragen bearbeiten\n 5 - zurück");
		while (outerSchleife) {
			eingabe = help.input("Bitte wählen Sie, was bearbeitet werden soll.");
			switch (eingabe) {
				case "1":
					while (schleife) {
						eingabe = help.input("Zur Zeit besteht die Questreihe aus " + quest.getDialoge()[dialogid].getFragen().length + " Fragen. Wie viele Fragen soll der Dialog enthalten?");
						try {
							fragenAnzahl = Integer.parseInt(eingabe);
							if (fragenAnzahl < 0 || fragenAnzahl > 2000) {
								System.out.println("Bitte wähle eine Fragenanzahl zwischen 0 und 2000");
								continue;
							} else if (fragenAnzahl <= localDialog.getFragen().length) {
								eingabe = help.input("Sollen die alten Fragen soweit wie möglich übernommen werden?");
								if (eingabe.equals("Ja") || eingabe.equals("ja")) {
									System.out.println("Alten Fragen werden übernommen");
									String[] tmp = new String[fragenAnzahl];
									for (int i = 0; i < tmp.length; i++) {
										tmp[i] = localDialog.getFragen()[i];
									}
									localDialog.setFragen(tmp);
								} else if (eingabe.equals("Nein") || eingabe.equals("nein")) {
									System.out.println("Alten Fragen werden nicht übernommen");
									dialog[dialogid].setFragen(new String[fragenAnzahl]);
									for (int i = 0; i < localDialog.getFragen().length; i++) {
										localDialog.editFrage(i, help.input("Bitte geben Sie die Frage " + i + " ein."));
									}
								} else {
									System.out.println("Ihre Eingabe konnte nicht verarbeitet werden. Bitt erneut eingeben.");
								}
								schleife = false;
								continue;
							} else {
								boolean innerSchleife = true;
								while (innerSchleife) {
									eingabe = help.input("Sollen die alten Fragen übernommen werden?");
									if (eingabe.equals("Ja") || eingabe.equals("ja")) {
										System.out.println("Alten Fragen werden übernommen...");
										String[] tmp = new String[fragenAnzahl];
										for (int i = 0; i < localDialog.getFragen().length; i++) {
											tmp[i] = localDialog.getFragen()[i];
										}
										for (int i = localDialog.getFragen().length; i < tmp.length; i++) {
											tmp[i] = help.input("Bitte geben Sie Frage " + i + " ein");
										}
										localDialog.setFragen(tmp);
										innerSchleife = false;
									} else if (eingabe.equals("Nein") || eingabe.equals("nein")) {
										System.out.println("Alten Fragen werden nicht übernommen");
										dialog[dialogid].setFragen(new String[fragenAnzahl]);
										for (int i = 0; i < localDialog.getFragen().length; i++) {
											localDialog.editFrage(i, help.input("Bitte geben Sie die Frage " + i + " ein."));
										}
										innerSchleife = false;
									} else {
										System.out.println("Ihre Eingabe konnte nicht verarbeitet werden. Bitte erneut eingeben.");
									}
								}
								schleife = false;
								continue;
							}
						} catch (NumberFormatException e) {
							System.out.println("Keine gültige Nummer. Eingabe bitte wiederholen.");
						}
					}
					schleife = true;
					break;
				case "2":
					while (schleife) {
						System.out.println("Fragen:\n" + help.toStringArrayWithLineNumber(localDialog.getFragen()));
						eingabe = help.input("Welche Frage soll bearbeitet werden?");
						try {
							int frage = Integer.parseInt(eingabe);
							if (frage < 0 || frage >= localDialog.getFragen().length) {
								System.out.println("Bitte wähle eine Frage zwischen 0 und " + localDialog.getFragen().length + ".");
								continue;
							} else {
								localDialog.editFrage(frage, help.input("Bitte gib die neue Frage ein."));
								System.out.println("Zu Debugzwecken:\n" + help.toStringArrayWithLineNumber(localDialog.getFragen()));
								schleife = false;
								continue;
							}
						} catch (NumberFormatException e) {
							System.out.println("Keine gültige Nummer. Eingabe bitte wiederholen");
						}
					}
					schleife = true;
					break;
				case "3":
					System.out.println("Zur Zeit noch nicht implementiert.");
					break;
				case "4":
					System.out.println("Zur Zeit noch nicht implementiert.");
					break;
				case "5":
					System.out.println("Kehre zurück zum Hauptprogramm.");
					outerSchleife = false;
					break;
				default:
					System.out.println("Ihre Eingabe konnte nicht verarbeitet werden. Bitte wiederholen Sie die Eingabe");
			}
		}
	}
	
	public void editAntworten() {
		
	}
	
	public void save() {
		
	}
	
	public Quest writeBack() {
		dialog[dialogid] = localDialog;
		quest.setDialoge(dialog);
		return quest;
	}
	
}
