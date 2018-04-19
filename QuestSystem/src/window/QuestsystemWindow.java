package window;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class QuestsystemWindow {

	private JFrame frame;
	private JTextArea[] txtAArray;
	private JTextField[] txtFArray;
	private JButton[] btnArray;	
	private JMenuItem[] mIArray;
	private JSpinner[] sArray;
	
	private int mICounter = 0;
	private int btnCounter = 0;
	private int txtACounter = 0;
	private int txtFCounter = 0;
	private int sCounter = 0;
	private int cBCounter = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestsystemWindow window = new QuestsystemWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public QuestsystemWindow() {
		initialize();
	}
	
	private void createAllArrays() {
		txtAArray = new JTextArea[6];
		txtFArray = new JTextField[3];
		btnArray = new JButton[15];
		mIArray = new JMenuItem[14];
		sArray = new JSpinner[5];
	}

	private void setAllActionHandler() {
		ActionHandler handler = new ActionHandler(txtAArray, txtFArray, btnArray, sArray, mIArray);
		for (int i = 0; i < btnArray.length; i++) {
			btnArray[i].addActionListener(handler);
		}
		for (int i = 0; i < mIArray.length; i++) {
			mIArray[i].addActionListener(handler);
		}
		for (int i = 0; i < sArray.length; i++) {
			sArray[i].addChangeListener(handler);
		}
	}
	
	
	private void initialize() {
		
		// Sets the intitial Settings
		frame = new JFrame();
		frame.setResizable(false);
		createAllArrays();
		
		// Sets the Layout
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(1);
		borderLayout.setHgap(1);
		frame.setBounds(100, 100, 860, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Questsystem");
		
		// Creates the MenuBarPanel
		JPanel MenuBarPanel = new JPanel();
		frame.getContentPane().add(MenuBarPanel, BorderLayout.NORTH);
		MenuBarPanel.setLayout(new BorderLayout(0, 1));
		
		// Creates the MenuBar
		JMenuBar menuBar = new JMenuBar();
		MenuBarPanel.add(menuBar, BorderLayout.NORTH);
		
		// Creates the MenuItems
		JMenu dateiItem = new JMenu("Datei");
		dateiItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateiItem.setToolTipText("Datei");
		dateiItem.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		menuBar.add(dateiItem);
		
		JMenuItem neuItem = new JMenuItem("Neu");
		dateiItem.add(neuItem);
		neuItem.setName("neuItem");
		mIArray[mICounter++] = neuItem;
		
		JMenuItem ladenItem = new JMenuItem("Laden");
		dateiItem.add(ladenItem);
		ladenItem.setName("ladenItem");
		mIArray[mICounter++] = ladenItem;
		
		JMenuItem speichernItem = new JMenuItem("Speichern");
		dateiItem.add(speichernItem);
		speichernItem.setName("speichernItem");
		mIArray[mICounter++] = speichernItem;
		
		
		// some Testings need to be done. Here is the first global Item out of the Menubar for further ActionHandling and adressability
		JMenuItem dropDownBeenden = new JMenuItem("Beenden");
		dateiItem.add(dropDownBeenden);
		dropDownBeenden.setName("dropDownBeenden");
		mIArray[mICounter++] = dropDownBeenden;
		
		JMenu bearbeitenItem = new JMenu("Bearbeiten");
		bearbeitenItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bearbeitenItem.setToolTipText("Bearbeiten");
		menuBar.add(bearbeitenItem);
		bearbeitenItem.setName("bearbeitenItem");
		mIArray[mICounter++] = bearbeitenItem;
		
		JMenuItem neueQuestreiheItem = new JMenuItem("Neue Questreihe");
		bearbeitenItem.add(neueQuestreiheItem);
		neueQuestreiheItem.setName("neueQuestreiheItem");
		mIArray[mICounter++] = neueQuestreiheItem;
		
		JMenuItem dropDownNeuerDialog = new JMenuItem("Neue Dialogreihe");
		bearbeitenItem.add(dropDownNeuerDialog);
		dropDownNeuerDialog.setName("dropDownNeuerDialog");
		mIArray[mICounter++] = dropDownNeuerDialog;
		
		JMenuItem dropDownNeuerWegpunkt = new JMenuItem("Neue Wegpunkte");
		bearbeitenItem.add(dropDownNeuerWegpunkt);
		dropDownNeuerWegpunkt.setName("dropDownNeuerWegpunkt");
		mIArray[mICounter++] = dropDownNeuerWegpunkt;
		
		JMenuItem dropDownQuestBearbeiten = new JMenuItem("Questreihe bearbeiten");
		bearbeitenItem.add(dropDownQuestBearbeiten);
		dropDownQuestBearbeiten.setName("dropDownQuestBearbeiten");
		mIArray[mICounter++] = dropDownQuestBearbeiten;
		
		JMenuItem dropDownDialogBearbeiten = new JMenuItem("Dialogreihe bearbeiten");
		bearbeitenItem.add(dropDownDialogBearbeiten);
		dropDownDialogBearbeiten.setName("dropDownDialogBearbeiten");
		mIArray[mICounter++] = dropDownDialogBearbeiten;
		
		JMenuItem dropDownQuestLöschen = new JMenuItem("Questreihe löschen");
		bearbeitenItem.add(dropDownQuestLöschen);
		dropDownQuestLöschen.setName("dropDownQuestLöschen");
		mIArray[mICounter++] = dropDownQuestLöschen;
		
		JMenuItem dropDownDialogLöschen = new JMenuItem("Dialogreihe löschen");
		bearbeitenItem.add(dropDownDialogLöschen);
		dropDownDialogLöschen.setName("dropDownDialogLöschen");
		mIArray[mICounter++] = dropDownDialogLöschen;
		
		JMenu mnEinstellungen = new JMenu("Einstellungen");
		mnEinstellungen.setToolTipText("Einstellungen");
		mnEinstellungen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnEinstellungen);
		
		JMenuItem dropDownSprache = new JMenuItem("Sprache");
		mnEinstellungen.add(dropDownSprache);
		dropDownSprache.setName("dropDownSprache");
		mIArray[mICounter++] = dropDownSprache;
		
		JMenuItem dropDownEinstellungen = new JMenuItem("Einstellungen");
		mnEinstellungen.add(dropDownEinstellungen);
		dropDownEinstellungen.setName("dropDownEinstellungen");
		mIArray[mICounter++] = dropDownEinstellungen;
		
		// Structure
		Component horizontalStrut_2 = Box.createHorizontalStrut(560);
		menuBar.add(horizontalStrut_2);
		
		// Creates the Close Button
		JMenuItem beendenMenuBar = new JMenuItem("Beenden");
		beendenMenuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		beendenMenuBar.setToolTipText("Beendet das Programm");
		menuBar.add(beendenMenuBar);
		
		// Structure
		Component horizontalStrut_3 = Box.createHorizontalStrut(10);
		menuBar.add(horizontalStrut_3);
		
		
		// The ContentPanel
		JPanel ContentPanel = new JPanel();
		ContentPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().add(ContentPanel, BorderLayout.CENTER);
		ContentPanel.setLayout(new CardLayout(0, 0));
		
		// The actual Panel which holds all the InputOutput Information
		JPanel Version01Panel = new JPanel();
		FlowLayout fl_Version01Panel = (FlowLayout) Version01Panel.getLayout();
		fl_Version01Panel.setAlignment(FlowLayout.LEFT);
		fl_Version01Panel.setVgap(10);
		fl_Version01Panel.setHgap(10);
		ContentPanel.add(Version01Panel, "Version01Panel");
		
		// Wrapps around all Items to quickly disable enable all
		Box AllWrapper = Box.createVerticalBox();
		Version01Panel.add(AllWrapper);
		
		Box QuestAuswahlWrapper = Box.createVerticalBox();
		AllWrapper.add(QuestAuswahlWrapper);
		
		Box OutputBoxQuestAuswahl = Box.createHorizontalBox();
		QuestAuswahlWrapper.add(OutputBoxQuestAuswahl);
		
		JLabel lblWelcheQuestSoll = new JLabel("Welche Quest soll bearbeitet werden?");
		lblWelcheQuestSoll.setToolTipText("Wähle die zu bearbeitende Quest aus.");
		OutputBoxQuestAuswahl.add(lblWelcheQuestSoll);
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		QuestAuswahlWrapper.add(verticalStrut_1);
		
		Box InputBoxQuestAuswahl = Box.createHorizontalBox();
		QuestAuswahlWrapper.add(InputBoxQuestAuswahl);
		
		JLabel label = new JLabel();
		label.setText("Quest:");
		label.setToolTipText("Hier die Nummer der Frage wählen");
		label.setName("sFragenauswahl");
		InputBoxQuestAuswahl.add(label);
		
		Component horizontalStrut_26 = Box.createHorizontalStrut(10);
		InputBoxQuestAuswahl.add(horizontalStrut_26);
		
		JTextArea txtAQuestPath = new JTextArea();
		txtAQuestPath.setText("Keine Datei ausgewählt");
		txtAQuestPath.setName("txtAQuestPath");
		txtAQuestPath.setEditable(false);
		txtAQuestPath.setBackground(SystemColor.menu);
		InputBoxQuestAuswahl.add(txtAQuestPath);
		txtAArray[txtACounter++] = txtAQuestPath;
		
		Component horizontalStrut_24 = Box.createHorizontalStrut(5);
		InputBoxQuestAuswahl.add(horizontalStrut_24);
		
		JButton btnAuswählen = new JButton("Auswählen");
		btnAuswählen.setName("btnAuswählen");
		InputBoxQuestAuswahl.add(btnAuswählen);
		btnArray[btnCounter++] = btnAuswählen;
		
		Component horizontalStrut_27 = Box.createHorizontalStrut(5);
		InputBoxQuestAuswahl.add(horizontalStrut_27);
		
		JButton btnQuestLöschen = new JButton("Löschen");
		btnQuestLöschen.setToolTipText("Löscht die Frage aus den Fragen.");
		btnQuestLöschen.setName("btnQuestLöschen");
		InputBoxQuestAuswahl.add(btnQuestLöschen);
		btnArray[btnCounter++] = btnQuestLöschen;
		
		Component BoxStrut0 = Box.createVerticalStrut(10);
		AllWrapper.add(BoxStrut0);
		
		Box DialogAuswahlWrapper = Box.createVerticalBox();
		AllWrapper.add(DialogAuswahlWrapper);
		
		Box OutputBoxDialogAuswahl = Box.createHorizontalBox();
		DialogAuswahlWrapper.add(OutputBoxDialogAuswahl);
		
		JLabel lblWelcherDialogSoll = new JLabel("Welcher Dialog soll bearbeitet werden?");
		lblWelcherDialogSoll.setToolTipText("Wähle den Dialog aus, der bearbeitet werden soll.");
		OutputBoxDialogAuswahl.add(lblWelcherDialogSoll);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		DialogAuswahlWrapper.add(verticalStrut);
		
		Box InputBoxDialogAuswahl = Box.createHorizontalBox();
		DialogAuswahlWrapper.add(InputBoxDialogAuswahl);
		
		JLabel lblDialog = new JLabel("Dialog:");
		InputBoxDialogAuswahl.add(lblDialog);
		
		Component horizontalStrut_23 = Box.createHorizontalStrut(71);
		InputBoxDialogAuswahl.add(horizontalStrut_23);
		
		JSpinner sDialogauswahl = new JSpinner();
		sDialogauswahl.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		sDialogauswahl.setToolTipText("Hier die Nummer der Frage wählen");
		sDialogauswahl.setPreferredSize(new Dimension(40, 20));
		sDialogauswahl.setName("sDialogauswahl");
		InputBoxDialogAuswahl.add(sDialogauswahl);
		sArray[sCounter++] = sDialogauswahl;
		
		Component horizontalStrut_22 = Box.createHorizontalStrut(5);
		horizontalStrut_22.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		InputBoxDialogAuswahl.add(horizontalStrut_22);
		
		JButton btnDialogLöschen = new JButton("Löschen");
		btnDialogLöschen.setToolTipText("Löscht die Frage aus den Fragen.");
		InputBoxDialogAuswahl.add(btnDialogLöschen);
		btnDialogLöschen.setName("btnDialogLöschen");
		btnArray[btnCounter++] = btnDialogLöschen;
		
		Component BoxStrut1 = Box.createVerticalStrut(10);
		AllWrapper.add(BoxStrut1);
		
		Box BeschreibungsWrapper = Box.createVerticalBox();
		AllWrapper.add(BeschreibungsWrapper);
		
		Box OutputBoxBeschreibung = Box.createHorizontalBox();
		BeschreibungsWrapper.add(OutputBoxBeschreibung);
		
		JLabel lblAlteBeschreibung = new JLabel("Alte Beschreibung:");
		OutputBoxBeschreibung.add(lblAlteBeschreibung);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(10);
		OutputBoxBeschreibung.add(horizontalStrut_8);
		
		
		// OutputField für die alte Beschreibung
		JTextArea txtAAlteBeschreibung = new JTextArea();
		txtAAlteBeschreibung.setEditable(false);
		txtAAlteBeschreibung.setDisabledTextColor(UIManager.getColor("Button.focus"));
		txtAAlteBeschreibung.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtAAlteBeschreibung.setForeground(Color.BLACK);
		txtAAlteBeschreibung.setText("Die alte Beschreibung");
		txtAAlteBeschreibung.setBackground(UIManager.getColor("Button.background"));
		OutputBoxBeschreibung.add(txtAAlteBeschreibung);
		txtAAlteBeschreibung.setName("txtAAlteBeschreibung");
		txtAArray[txtACounter++] = txtAAlteBeschreibung;
		
		Component BeschreibungsStrut = Box.createVerticalStrut(10);
		BeschreibungsWrapper.add(BeschreibungsStrut);
		
		Box InputBoxBeschreibung = Box.createHorizontalBox();
		BeschreibungsWrapper.add(InputBoxBeschreibung);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		InputBoxBeschreibung.add(lblBeschreibung);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(29);
		horizontalStrut_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		InputBoxBeschreibung.add(horizontalStrut_1);
		
		JTextField txtFNeueBeschreibung = new JTextField();
		txtFNeueBeschreibung.setToolTipText("Beschreibung hier einfügen.");
		InputBoxBeschreibung.add(txtFNeueBeschreibung);
		txtFNeueBeschreibung.setColumns(47);
		txtFNeueBeschreibung.setName("txtFNeueBeschreibung");
		txtFArray[txtFCounter++] = txtFNeueBeschreibung;
		
		Component horizontalStrut = Box.createHorizontalStrut(5);
		InputBoxBeschreibung.add(horizontalStrut);
		
		JButton btnBeschreibungÜbernehmen = new JButton("Übernehmen");
		btnBeschreibungÜbernehmen.setAlignmentX(Component.RIGHT_ALIGNMENT);
		InputBoxBeschreibung.add(btnBeschreibungÜbernehmen);
		btnBeschreibungÜbernehmen.setName("btnBeschreibungÜbernehmen");
		btnArray[btnCounter++] = btnBeschreibungÜbernehmen;
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(5);
		InputBoxBeschreibung.add(horizontalStrut_4);
		
		JButton btnBeschreibungLöschen = new JButton("Löschen");
		InputBoxBeschreibung.add(btnBeschreibungLöschen);
		btnBeschreibungLöschen.setName("btnBeschreibungLöschen");
		btnArray[btnCounter++] = btnBeschreibungLöschen;
		
		Component BoxStrut2 = Box.createVerticalStrut(10);
		AllWrapper.add(BoxStrut2);
		
		Box FragenWrapper = Box.createVerticalBox();
		AllWrapper.add(FragenWrapper);
		
		Box OutputBoxFragen = Box.createHorizontalBox();
		FragenWrapper.add(OutputBoxFragen);
		
		JLabel lblAlteFragenanzahl = new JLabel("Alte Fragenanzahl:");
		OutputBoxFragen.add(lblAlteFragenanzahl);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(10);
		OutputBoxFragen.add(horizontalStrut_9);
		
		JTextArea txtAAlteFragenanzahl = new JTextArea();
		txtAAlteFragenanzahl.setEditable(false);
		txtAAlteFragenanzahl.setToolTipText("Hier wird die Fragenanzahl angezeigt, bevor sie geändert wurde.");
		txtAAlteFragenanzahl.setText("Die alte Fragenanzahl");
		txtAAlteFragenanzahl.setDisabledTextColor(UIManager.getColor("Button.focus"));
		txtAAlteFragenanzahl.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtAAlteFragenanzahl.setBackground(UIManager.getColor("Button.background"));
		OutputBoxFragen.add(txtAAlteFragenanzahl);
		txtAAlteFragenanzahl.setName("txtAAlteFragenanzahl");
		txtAArray[txtACounter++] = txtAAlteFragenanzahl;
		
		Component FragenStrut = Box.createVerticalStrut(10);
		FragenWrapper.add(FragenStrut);
		
		Box InputBoxFragen = Box.createHorizontalBox();
		FragenWrapper.add(InputBoxFragen);
		
		JLabel lblFragenanzahl = new JLabel("Fragenanzahl:");
		lblFragenanzahl.setToolTipText("Wähle hier die Fragenanzahl");
		InputBoxFragen.add(lblFragenanzahl);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(30);
		horizontalStrut_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		InputBoxFragen.add(horizontalStrut_5);
		
		JSpinner sFragenanzahl = new JSpinner();
		sFragenanzahl.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		sFragenanzahl.setToolTipText("Anzahl an Fragen auswählen");
		InputBoxFragen.add(sFragenanzahl);
		sFragenanzahl.setName("sFragenanzahl");
		sArray[sCounter++] = sFragenanzahl;
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(5);
		InputBoxFragen.add(horizontalStrut_6);
		
		JButton btnFragenanzahlÜbernehmen = new JButton("Übernehmen");
		btnFragenanzahlÜbernehmen.setAlignmentX(1.0f);
		InputBoxFragen.add(btnFragenanzahlÜbernehmen);
		btnFragenanzahlÜbernehmen.setName("btnFragenanzahlÜbernehmen");
		btnArray[btnCounter++] = btnFragenanzahlÜbernehmen;
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(5);
		InputBoxFragen.add(horizontalStrut_7);
		
		JButton btnFragenanzahlLöschen = new JButton("Löschen");
		InputBoxFragen.add(btnFragenanzahlLöschen);
		btnFragenanzahlLöschen.setName("btnFragenanzahlLöschen");
		btnArray[btnCounter++] = btnFragenanzahlLöschen;
		
		Component BoxStrut3 = Box.createVerticalStrut(10);
		AllWrapper.add(BoxStrut3);
		
		Box AntwortenWrapper = Box.createVerticalBox();
		AllWrapper.add(AntwortenWrapper);
		
		Box OutputBoxAntworten = Box.createHorizontalBox();
		AntwortenWrapper.add(OutputBoxAntworten);
		
		JLabel lblAlteAntwortenanzahl = new JLabel("Alte Antwortenanzahl:");
		OutputBoxAntworten.add(lblAlteAntwortenanzahl);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(10);
		OutputBoxAntworten.add(horizontalStrut_10);
		
		JTextArea txtAAlteAntwortenanzahl = new JTextArea();
		txtAAlteAntwortenanzahl.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtAAlteAntwortenanzahl.setToolTipText("Hier wird die Fragenanzahl angezeigt, bevor sie geändert wurde.");
		txtAAlteAntwortenanzahl.setText("Die alte Antwortenanzahl");
		txtAAlteAntwortenanzahl.setEditable(false);
		txtAAlteAntwortenanzahl.setDisabledTextColor(Color.BLACK);
		txtAAlteAntwortenanzahl.setBackground(SystemColor.menu);
		OutputBoxAntworten.add(txtAAlteAntwortenanzahl);
		txtAAlteAntwortenanzahl.setName("txtAAlteAntwortenanzahl");
		txtAArray[txtACounter++] = txtAAlteAntwortenanzahl;
		
		Component AntwortenStrut = Box.createVerticalStrut(10);
		AntwortenWrapper.add(AntwortenStrut);
		
		Box InputBoxAntworten = Box.createHorizontalBox();
		AntwortenWrapper.add(InputBoxAntworten);
		
		JLabel lblAntwortenanzahl = new JLabel("Antwortenanzahl:");
		lblAntwortenanzahl.setToolTipText("Wähle hier die Antwortenanzahl.");
		InputBoxAntworten.add(lblAntwortenanzahl);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(10);
		horizontalStrut_11.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		InputBoxAntworten.add(horizontalStrut_11);
		
		JSpinner sAntwortenanzahl = new JSpinner();
		sAntwortenanzahl.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		sAntwortenanzahl.setToolTipText("Anzahl an Antworten auswählen");
		InputBoxAntworten.add(sAntwortenanzahl);
		sAntwortenanzahl.setName("sAntwortenanzahl");
		sArray[sCounter++] = sAntwortenanzahl;
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(5);
		InputBoxAntworten.add(horizontalStrut_12);
		
		JButton btnAntwortenanzahlÜbernehmen= new JButton("Übernehmen");
		btnAntwortenanzahlÜbernehmen.setAlignmentX(1.0f);
		InputBoxAntworten.add(btnAntwortenanzahlÜbernehmen);
		btnAntwortenanzahlÜbernehmen.setName("btnAntwortenanzahlÜbernehmen");
		btnArray[btnCounter++] = btnAntwortenanzahlÜbernehmen;
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(5);
		InputBoxAntworten.add(horizontalStrut_13);
		
		JButton btnAntwortenanzahlLöschen = new JButton("Löschen");
		InputBoxAntworten.add(btnAntwortenanzahlLöschen);
		btnAntwortenanzahlLöschen.setName("btnAntwortenanzahlLöschen");
		btnArray[btnCounter++] = btnAntwortenanzahlLöschen;
		
		Component BoxStrut4 = Box.createVerticalStrut(10);
		AllWrapper.add(BoxStrut4);
		
		Box FragenAuswahlWrapper = Box.createVerticalBox();
		AllWrapper.add(FragenAuswahlWrapper);
		
		Box OutputBoxFragenAuswahl = Box.createHorizontalBox();
		FragenAuswahlWrapper.add(OutputBoxFragenAuswahl);
		
		JLabel lblWelcheFrageSoll = new JLabel("Welche Frage soll bearbeitet werden?");
		OutputBoxFragenAuswahl.add(lblWelcheFrageSoll);
		
		Component FragenAuswahlStrut = Box.createVerticalStrut(10);
		FragenAuswahlWrapper.add(FragenAuswahlStrut);
		
		Box InputBoxFragenAuswahl = Box.createHorizontalBox();
		FragenAuswahlWrapper.add(InputBoxFragenAuswahl);
		
		JSpinner sFragenauswahl = new JSpinner();
		sFragenauswahl.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		sFragenauswahl.setToolTipText("Hier die Nummer der Frage wählen");
		sFragenauswahl.setPreferredSize(new Dimension(40, 20));
		InputBoxFragenAuswahl.add(sFragenauswahl);
		sFragenauswahl.setName("sFragenauswahl");
		sArray[sCounter++] = sFragenauswahl;
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(10);
		horizontalStrut_15.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		InputBoxFragenAuswahl.add(horizontalStrut_15);
		
		JTextArea txtAAlteFrageOutput = new JTextArea();
		txtAAlteFrageOutput.setBackground(UIManager.getColor("Button.background"));
		txtAAlteFrageOutput.setEditable(false);
		txtAAlteFrageOutput.setText("Frage...");
		InputBoxFragenAuswahl.add(txtAAlteFrageOutput);
		txtAAlteFrageOutput.setName("txtAAlteFrageOutput");
		txtAArray[txtACounter++] = txtAAlteFrageOutput;
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(5);
		InputBoxFragenAuswahl.add(horizontalStrut_14);
		
		JButton btnFrageLöschen = new JButton("Löschen");
		btnFrageLöschen.setToolTipText("Löscht die Frage aus den Fragen.");
		InputBoxFragenAuswahl.add(btnFrageLöschen);
		btnFrageLöschen.setName("btnFrageLöschen");
		btnArray[btnCounter++] = btnFrageLöschen;
		
		Component BoxStrut5 = Box.createVerticalStrut(10);
		AllWrapper.add(BoxStrut5);
		
		Box FragenBearbeitenWrapper = Box.createVerticalBox();
		AllWrapper.add(FragenBearbeitenWrapper);
		
		Box InputBoxFragenBearbeiten = Box.createHorizontalBox();
		FragenBearbeitenWrapper.add(InputBoxFragenBearbeiten);
		
		JTextField txtFFrageInput = new JTextField();
		txtFFrageInput.setToolTipText("Neue Frage hier einfügen");
		txtFFrageInput.setColumns(57);
		InputBoxFragenBearbeiten.add(txtFFrageInput);
		txtFFrageInput.setName("txtFFrageInput");
		txtFArray[txtFCounter++] = txtFFrageInput;
		
		Component horizontalStrut_17 = Box.createHorizontalStrut(5);
		InputBoxFragenBearbeiten.add(horizontalStrut_17);
		
		JButton btnFrageFieldÜbernehmen = new JButton("Übernehmen");
		btnFrageFieldÜbernehmen.setAlignmentX(1.0f);
		InputBoxFragenBearbeiten.add(btnFrageFieldÜbernehmen);
		btnFrageFieldÜbernehmen.setName("btnFrageFieldÜbernehmen");
		btnArray[btnCounter++] = btnFrageFieldÜbernehmen;
		
		Component horizontalStrut_18 = Box.createHorizontalStrut(5);
		InputBoxFragenBearbeiten.add(horizontalStrut_18);
		
		JButton btnFrageFieldLöschen = new JButton("Löschen");
		InputBoxFragenBearbeiten.add(btnFrageFieldLöschen);
		btnFrageFieldLöschen.setName("btnFrageFieldLöschen");
		btnArray[btnCounter++] = btnFrageFieldLöschen;
		
		Component BoxStrut6 = Box.createVerticalStrut(10);
		AllWrapper.add(BoxStrut6);
		
		Box AntwortenAuswahlWrapper = Box.createVerticalBox();
		AllWrapper.add(AntwortenAuswahlWrapper);
		
		Box OutputBoxAntwortenAuswahl = Box.createHorizontalBox();
		AntwortenAuswahlWrapper.add(OutputBoxAntwortenAuswahl);
		
		JLabel lblWelcheAntwortSoll = new JLabel("Welche Antwort soll bearbeitet werden?");
		OutputBoxAntwortenAuswahl.add(lblWelcheAntwortSoll);
		
		Component AntwortenAuswahlStrut = Box.createVerticalStrut(10);
		AntwortenAuswahlWrapper.add(AntwortenAuswahlStrut);
		
		Box InputBoxAntwortenAuswahl = Box.createHorizontalBox();
		AntwortenAuswahlWrapper.add(InputBoxAntwortenAuswahl);
		
		JSpinner sAntwortenauswahl = new JSpinner();
		sAntwortenauswahl.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		sAntwortenauswahl.setToolTipText("Hier die Nummer der Antwort wählen");
		sAntwortenauswahl.setPreferredSize(new Dimension(40, 20));
		InputBoxAntwortenAuswahl.add(sAntwortenauswahl);
		sAntwortenauswahl.setName("sAntwortenauswahl");
		sArray[sCounter++] = sAntwortenauswahl;
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(10);
		horizontalStrut_16.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		InputBoxAntwortenAuswahl.add(horizontalStrut_16);
		
		JTextArea txtAAlteAntwort = new JTextArea();
		txtAAlteAntwort.setText("Antwort...");
		txtAAlteAntwort.setEditable(false);
		txtAAlteAntwort.setBackground(SystemColor.menu);
		InputBoxAntwortenAuswahl.add(txtAAlteAntwort);
		txtAAlteAntwort.setName("txtAAlteAntwort");
		txtAArray[txtACounter++] = txtAAlteAntwort;
		
		Component horizontalStrut_19 = Box.createHorizontalStrut(5);
		InputBoxAntwortenAuswahl.add(horizontalStrut_19);
		
		JButton btnAntwortLöschen = new JButton("Löschen");
		btnAntwortLöschen.setToolTipText("Löscht die Antwort aus den Antworten");
		InputBoxAntwortenAuswahl.add(btnAntwortLöschen);
		btnAntwortLöschen.setName("btnAntwortLöschen");
		btnArray[btnCounter++] = btnAntwortLöschen;
		
		Component BoxStrut7 = Box.createVerticalStrut(10);
		AllWrapper.add(BoxStrut7);
		
		Box AntwortenBearbeitenWrapper = Box.createVerticalBox();
		AllWrapper.add(AntwortenBearbeitenWrapper);
		
		Box InputBoxAntwortenBearbeiten = Box.createHorizontalBox();
		AntwortenBearbeitenWrapper.add(InputBoxAntwortenBearbeiten);
		
		JTextField txtFAntwortenInput = new JTextField();
		txtFAntwortenInput.setToolTipText("Neue Antwort hier einfügen");
		txtFAntwortenInput.setColumns(42);
		InputBoxAntwortenBearbeiten.add(txtFAntwortenInput);
		txtFAntwortenInput.setName("txtFAntwortenInput");
		txtFArray[txtFCounter++] = txtFAntwortenInput;
		
		Component horizontalStrut_20 = Box.createHorizontalStrut(5);
		InputBoxAntwortenBearbeiten.add(horizontalStrut_20);
		
		JButton btnAntwortFieldÜbernehmen = new JButton("Übernehmen");
		btnAntwortFieldÜbernehmen.setToolTipText("Überschreibt die ausgewählte Frage mit der eingegebenen.");
		btnAntwortFieldÜbernehmen.setAlignmentX(1.0f);
		InputBoxAntwortenBearbeiten.add(btnAntwortFieldÜbernehmen);
		btnAntwortFieldÜbernehmen.setName("btnAntwortFieldÜbernehmen");
		btnArray[btnCounter++] = btnAntwortFieldÜbernehmen;
		
		Component horizontalStrut_21 = Box.createHorizontalStrut(5);
		InputBoxAntwortenBearbeiten.add(horizontalStrut_21);
		
		JButton btnAntwortFieldLöschen = new JButton("Löschen");
		InputBoxAntwortenBearbeiten.add(btnAntwortFieldLöschen);
		btnAntwortFieldLöschen.setName("btnAntwortFieldLöschen");
		btnArray[btnCounter++] = btnAntwortFieldLöschen;
		
		setAllActionHandler();
		
	}
}
