package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import questsystem.FileOutput;
import questsystem.FileReader;
import questsystem.Helper;
import questsystem.Quest;

public class ActionHandler implements ActionListener, ChangeListener {

	private Quest quest;
	private FileOutput printer;
	private File folder;
	
	private JTextArea[] txtAArray;
	private JTextField[] txtFArray;
	private JButton[] btnArray;
	private JSpinner[] sArray;
	private JMenuItem[] mIArray;
	private int dialogID;
	private int QuestID;
	private File filepath;
	private String filepathS;
	
	private JFileChooser fc;
	
	public ActionHandler(JTextArea[] txtA, JTextField[] txtF, JButton[] btn, JSpinner[] s, JMenuItem[] mI) {
		this.txtAArray = txtA;
		this.txtFArray = txtF;
		this.btnArray = btn;
		this.sArray = s;
		this.mIArray = mI;
		folder = new File("save/");
		File[] listOfAllFiles = folder.listFiles();
		String tmp = "";
		for (int i = 0; i < listOfAllFiles.length; i++) {
			tmp += listOfAllFiles[i].getName() + "\n";
		}
		System.out.println("Alle Dateien:\n" + tmp);
		printer = new FileOutput();
		fc = new JFileChooser();
		fc.setCurrentDirectory(folder);
		fc.showOpenDialog(null);
		filepath = fc.getSelectedFile();
		System.out.println("Debug: " + filepath.getName() + " " + filepath.getAbsolutePath());
		filepathS = filepath.getName();
		initalize();
		aktualisiereQuest();
	}
	
	private void initalize() {
		FileReader reader = new FileReader();
		quest = reader.ReadFiles(filepath.getAbsolutePath());
		if (getSpinnerWithName("sDialogauswahl") != null && (int) getSpinnerWithName("sDialogauswahl").getValue() <= quest.getDialoge().length-1) {
			dialogID = (int) getSpinnerWithName("sDialogauswahl").getValue();
		} else {
			dialogID = 0;
		}
		if (getTextAreaWithName("txtAAlteBeschreibung") != null) {
			getTextAreaWithName("txtAAlteBeschreibung").setText(quest.getBeschreibung());
		}
		if (getTextAreaWithName("txtAAlteFragenanzahl") != null) {
			getTextAreaWithName("txtAAlteFragenanzahl").setText("" + quest.getDialoge()[dialogID].getFragen().length);
			getSpinnerWithName("sFragenanzahl").setValue(quest.getDialoge()[dialogID].getFragen().length);
		}
		if (getTextAreaWithName("txtAAlteAntwortenanzahl") != null) {
			getTextAreaWithName("txtAAlteAntwortenanzahl").setText("" + quest.getDialoge()[dialogID].getAntworten().length);
			getSpinnerWithName("sAntwortenanzahl").setValue(quest.getDialoge()[dialogID].getAntworten().length);
		}
		if (getTextAreaWithName("txtAAlteFrageOutput") != null) {
			getTextAreaWithName("txtAAlteFrageOutput").setText(quest.getDialoge()[dialogID].getFragen()[(int) getSpinnerWithName("sFragenauswahl").getValue()]);
		}
		if (getTextAreaWithName("txtAAlteAntwort") != null) {
			getTextAreaWithName("txtAAlteAntwort").setText(quest.getDialoge()[dialogID].getAntworten()[(int) getSpinnerWithName("sAntwortenauswahl").getValue()]);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getButtonWithName("btnBeschreibungÜbernehmen")) {
			quest.setBeschreibung(getTextFieldWithName("txtFNeueBeschreibung").getText());
			getTextAreaWithName("txtAAlteBeschreibung").setText(quest.getBeschreibung());
		}
		if (e.getSource() == getButtonWithName("btnBeschreibungLöschen")) {
			quest.setBeschreibung("");
			getTextAreaWithName("txtAAlteBeschreibung").setText(quest.getBeschreibung());
			getTextFieldWithName("txtFNeueBeschreibung").setText("");
		}
		if (e.getSource() == getButtonWithName("btnFragenanzahlÜbernehmen")) {
			String[] tmp = new String[(int) getSpinnerWithName("sFragenanzahl").getValue()];
			for (int i = 0; i < tmp.length; i++) {
				if (i >= quest.getDialoge()[dialogID].getFragen().length) {
					break;
				} else {
					tmp[i] = quest.getDialoge()[dialogID].getFragen()[i];
				}
			}
			quest.getDialoge()[dialogID].setFragen(tmp);
			getTextAreaWithName("txtAAlteFragenanzahl").setText("" + quest.getDialoge()[dialogID].getFragen().length);
		}
		if (e.getSource() == getButtonWithName("btnFragenanzahlLöschen") || e.getSource() == getButtonWithName("btnFrageFieldLöschen")) {
			quest.getDialoge()[dialogID].setFragen(new String[0]);
			getTextAreaWithName("txtAAlteFragenanzahl").setText("" + quest.getDialoge()[dialogID].getFragen().length);
			getSpinnerWithName("sFragenanzahl").setValue(quest.getDialoge()[dialogID].getFragen().length);
			getSpinnerWithName("sFragenauswahl").setValue(quest.getDialoge()[dialogID].getFragen().length);
		}
		if (e.getSource() == getButtonWithName("btnAntwortenanzahlÜbernehmen")) {
			String[] tmp = new String[(int) getSpinnerWithName("sAntwortenanzahl").getValue()];
			for (int i = 0; i < tmp.length; i++) {
				if (i >= quest.getDialoge()[dialogID].getAntworten().length) {
					break;
				} else {
					tmp[i] = quest.getDialoge()[dialogID].getAntworten()[i];
				}
			}
			quest.getDialoge()[dialogID].setAntworten(tmp);
			getTextAreaWithName("txtAAlteAntwortenanzahl").setText("" + quest.getDialoge()[dialogID].getAntworten().length);
		}
		if (e.getSource() == getButtonWithName("btnAntwortenanzahlLöschen") || e.getSource() == getButtonWithName("btnAntwortFieldLöschen")) {
			quest.getDialoge()[dialogID].setAntworten(new String[0]);
			getTextAreaWithName("txtAAlteAntwortenanzahl").setText("" + quest.getDialoge()[dialogID].getAntworten().length);
			getSpinnerWithName("sAntwortenanzahl").setValue(quest.getDialoge()[dialogID].getAntworten().length);
			getSpinnerWithName("sAntwortenauswahl").setValue(quest.getDialoge()[dialogID].getAntworten().length);
		}
		if (e.getSource() == getButtonWithName("btnFrageLöschen")) {
			String[] tmp = new String[quest.getDialoge()[dialogID].getFragen().length-1];
			for (int i = 0; i < quest.getDialoge()[dialogID].getFragen().length-1; i++) {
				if (i >= (int) getSpinnerWithName("sFragenauswahl").getValue()) {
					tmp[i] = quest.getDialoge()[dialogID].getFragen()[i+1];
				} else {
					tmp[i] = quest.getDialoge()[dialogID].getFragen()[i];
				}
			}
			quest.getDialoge()[dialogID].setFragen(tmp);
			getTextAreaWithName("txtAAlteFrageOutput").setText(quest.getDialoge()[dialogID].getFragen()[(int) getSpinnerWithName("sFragenauswahl").getValue()]);
			getTextAreaWithName("txtAAlteFragenanzahl").setText("" + quest.getDialoge()[dialogID].getFragen().length);
		}
		if (e.getSource() == getButtonWithName("btnFrageFieldÜbernehmen")) {
			quest.getDialoge()[dialogID].editFrage((int) getSpinnerWithName("sFragenauswahl").getValue(), getTextFieldWithName("txtFFrageInput").getText());
			getTextAreaWithName("txtAAlteFrageOutput").setText(quest.getDialoge()[dialogID].getFragen()[(int) getSpinnerWithName("sFragenauswahl").getValue()]);
			getTextAreaWithName("txtAAlteFragenanzahl").setText("" + quest.getDialoge()[dialogID].getFragen().length);
		}
		if (e.getSource() == getButtonWithName("btnAntwortLöschen")) {
			String[] tmp = new String[quest.getDialoge()[dialogID].getAntworten().length-1];
			for (int i = 0; i < quest.getDialoge()[dialogID].getAntworten().length-1; i++) {
				if (i >= (int) getSpinnerWithName("sAntwortenauswahl").getValue()) {
					tmp[i] = quest.getDialoge()[dialogID].getAntworten()[i+1];
				} else {
					tmp[i] = quest.getDialoge()[dialogID].getAntworten()[i];
				}
			}
			quest.getDialoge()[dialogID].setAntworten(tmp);
			getTextAreaWithName("txtAAlteAntwort").setText(quest.getDialoge()[dialogID].getAntworten()[(int) getSpinnerWithName("sAntwortenauswahl").getValue()]);
			getTextAreaWithName("txtAAlteAntwortenanzahl").setText("" + quest.getDialoge()[dialogID].getAntworten().length);
		}
		if (e.getSource() == getButtonWithName("btnAntwortFieldÜbernehmen")) {
			quest.getDialoge()[dialogID].editAntwort((int) getSpinnerWithName("sAntwortenauswahl").getValue(), getTextFieldWithName("txtFAntwortenInput").getText());
			getTextAreaWithName("txtAAlteAntwort").setText(quest.getDialoge()[dialogID].getAntworten()[(int) getSpinnerWithName("sAntwortenauswahl").getValue()]);
		}
		if (e.getSource() == getButtonWithName("btnAuswählen")) {
			fc.showOpenDialog(null);
			filepath = fc.getSelectedFile();
			filepathS = filepath.getAbsolutePath();
			System.out.println("Debug: " + filepathS);
			quest = new FileReader().ReadFiles(filepathS);
			aktualisiereQuest();
		}
		if(e.getSource() == getMenuItemWithName("speichernItem")) {
			printer.save(quest, filepath.getName());
		}
		
		/*
		if(e.getSource() == window.beschreibungÜbernehmen) {
			window.alteBeschreibung.setText(window.txtFBeschreibungInput.getText());
		}*/
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == getSpinnerWithName("sFragenauswahl")) {
			if ((int) getSpinnerWithName("sFragenauswahl").getValue() >= quest.getDialoge()[dialogID].getFragen().length) {
				getTextAreaWithName("txtAAlteFrageOutput").setText("Keine Frage vorhanden");
			} else {
				getTextAreaWithName("txtAAlteFrageOutput").setText(quest.getDialoge()[dialogID].getFragen()[(int) getSpinnerWithName("sFragenauswahl").getValue()]);
			}
		}
		if (e.getSource() == getSpinnerWithName("sAntwortenauswahl")) {
			if ((int) getSpinnerWithName("sAntwortenauswahl").getValue() >= quest.getDialoge()[dialogID].getAntworten().length) {
				getTextAreaWithName("txtAAlteAntwort").setText("Keine Frage vorhanden");
			} else {
				getTextAreaWithName("txtAAlteAntwort").setText(quest.getDialoge()[dialogID].getAntworten()[(int) getSpinnerWithName("sAntwortenauswahl").getValue()]);
			}
		}
		if (e.getSource() == getSpinnerWithName("sDialogauswahl")) {
			if ((int) getSpinnerWithName("sDialogauswahl").getValue() >= quest.getDialoge().length) {
				getSpinnerWithName("sDialogauswahl").setValue(quest.getDialoge().length-1);
				dialogID = (int) getSpinnerWithName("sDialogauswahl").getValue();
				aktualisiereDialog();
			} else {
				dialogID = (int) getSpinnerWithName("sDialogauswahl").getValue();
				aktualisiereDialog();
			}
		}
	}
	
	private void aktualisiereFragen() {
		getTextAreaWithName("txtAAlteFragenanzahl").setText("" + quest.getDialoge()[dialogID].getFragen().length);
		getSpinnerWithName("sFragenanzahl").setValue(quest.getDialoge()[dialogID].getFragen().length);
		int tmp = (int) getSpinnerWithName("sFragenauswahl").getValue();
		if (tmp < 0 || tmp >= quest.getDialoge()[dialogID].getFragen().length) {
			getTextAreaWithName("txtAAlteFrageOutput").setText(quest.getDialoge()[dialogID].getFragen()[0]);
		} else {
			getTextAreaWithName("txtAAlteFrageOutput").setText(quest.getDialoge()[dialogID].getFragen()[tmp]);
		}
	}
	
	private void aktualisiereAntworten() {
		getTextAreaWithName("txtAAlteAntwortenanzahl").setText("" + quest.getDialoge()[dialogID].getAntworten().length);
		getSpinnerWithName("sAntwortenanzahl").setValue(quest.getDialoge()[dialogID].getFragen().length);
		int tmp = (int) getSpinnerWithName("sAntwortenauswahl").getValue();
		if (tmp < 0 || tmp >= quest.getDialoge()[dialogID].getFragen().length) {
			getTextAreaWithName("txtAAlteAntwort").setText(quest.getDialoge()[dialogID].getAntworten()[0]);
		} else {
			getTextAreaWithName("txtAAlteAntwort").setText(quest.getDialoge()[dialogID].getAntworten()[tmp]);
		}
	}
	
	private void aktualisiereQuest() {
		if (filepath.getName().contains(".xml")) {
			getTextAreaWithName("txtAQuestPath").setText(filepath.getName());
		} else {
			getTextAreaWithName("txtAQuestPath").setText(filepath.getName() + ".xml");
		}
		aktualisiereDialog();
	}
	
	private void aktualisiereDialog() {
		getTextAreaWithName("txtAAlteBeschreibung").setText(quest.getBeschreibung());
		aktualisiereFragen();
		aktualisiereAntworten();
	}
	
 	private JButton getButtonWithName(String name) {
		for (int i = 0; i < btnArray.length; i++) {
			if (btnArray[i].getName().equals(name)) {
				return btnArray[i];
			}
		}
		return null;
	}
	
	private JTextField getTextFieldWithName(String name) {
		for (int i = 0; i < txtFArray.length; i++) {
			if (txtFArray[i].getName().equals(name)) {
				return txtFArray[i];
			}
		}
		return null;
	}
	
	private JTextArea getTextAreaWithName(String name) {
		for (int i = 0; i < txtAArray.length; i++) {
			 if (txtAArray[i].getName().equals(name)) {
				return txtAArray[i];
			}
		}
		return null;
	}

	private JSpinner getSpinnerWithName(String name) {
		for (int i = 0; i < sArray.length; i++) {
			if (sArray[i].getName().equals(name)) {
				return sArray[i];
			}
		}
		return null;
	}
	
	private JMenuItem getMenuItemWithName(String name) {
		for (int i = 0; i < mIArray.length; i++) {
			if (mIArray[i].getName().equals(name)) {
				return mIArray[i];
			}
		}
		return null;
	}

	
}
