package window;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Fenster extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ActionListener listener = new Handler();
	private JButton neueQuest;
	private JButton bearbeiteQuest;
	private JButton neuerDialog;
	private JButton bearbeiteDialog;
	private JButton temporary;
	private JButton beenden;
	private JLabel lblBeschreibung;
	private JTextArea textArea;
	
	
	public Fenster() {
		setBorder(UIManager.getBorder("MenuBar.border"));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 117, 93, 122, 115, 85, 0};
		gridBagLayout.rowHeights = new int[]{23, 30, 30, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		beenden = new JButton("Beenden");
		beenden.addActionListener(listener);
		
		neueQuest = new JButton("Neue Quest");
		neueQuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		neueQuest.setToolTipText("Erstelle eine neue Quest");
		GridBagConstraints gbc_neueQuest = new GridBagConstraints();
		gbc_neueQuest.fill = GridBagConstraints.BOTH;
		gbc_neueQuest.insets = new Insets(0, 0, 5, 5);
		gbc_neueQuest.gridx = 0;
		gbc_neueQuest.gridy = 0;
		add(neueQuest, gbc_neueQuest);
		
		bearbeiteQuest = new JButton("Quest bearbeiten");
		bearbeiteQuest.setToolTipText("Bearbeite eine vorhandene Quest");
		GridBagConstraints gbc_bearbeiteQuest = new GridBagConstraints();
		gbc_bearbeiteQuest.fill = GridBagConstraints.BOTH;
		gbc_bearbeiteQuest.insets = new Insets(0, 0, 5, 5);
		gbc_bearbeiteQuest.gridx = 1;
		gbc_bearbeiteQuest.gridy = 0;
		add(bearbeiteQuest, gbc_bearbeiteQuest);
		
		neuerDialog = new JButton("Neuer Dialog");
		neuerDialog.setToolTipText("Erstelle einen neuen Dialog");
		GridBagConstraints gbc_neuerDialog = new GridBagConstraints();
		gbc_neuerDialog.fill = GridBagConstraints.BOTH;
		gbc_neuerDialog.insets = new Insets(0, 0, 5, 5);
		gbc_neuerDialog.gridx = 2;
		gbc_neuerDialog.gridy = 0;
		add(neuerDialog, gbc_neuerDialog);
		
		bearbeiteDialog = new JButton("Dialog bearbeiten");
		bearbeiteDialog.setToolTipText("Bearbeite einen vorhandenen Dialog");
		GridBagConstraints gbc_bearbeiteDialog = new GridBagConstraints();
		gbc_bearbeiteDialog.fill = GridBagConstraints.BOTH;
		gbc_bearbeiteDialog.anchor = GridBagConstraints.NORTHEAST;
		gbc_bearbeiteDialog.insets = new Insets(0, 0, 5, 5);
		gbc_bearbeiteDialog.gridx = 3;
		gbc_bearbeiteDialog.gridy = 0;
		add(bearbeiteDialog, gbc_bearbeiteDialog);
		
		temporary = new JButton("(Temporär; Weg)");
		temporary.setToolTipText("Zur Zeit nicht belegt. Hier wird später das Wege Menü eingebaut.");
		GridBagConstraints gbc_temporary = new GridBagConstraints();
		gbc_temporary.fill = GridBagConstraints.BOTH;
		gbc_temporary.anchor = GridBagConstraints.NORTHWEST;
		gbc_temporary.insets = new Insets(0, 0, 5, 5);
		gbc_temporary.gridx = 4;
		gbc_temporary.gridy = 0;
		add(temporary, gbc_temporary);
		beenden.setToolTipText("Beendet das Program");
		GridBagConstraints gbc_beenden = new GridBagConstraints();
		gbc_beenden.fill = GridBagConstraints.BOTH;
		gbc_beenden.anchor = GridBagConstraints.NORTHWEST;
		gbc_beenden.insets = new Insets(0, 0, 5, 0);
		gbc_beenden.gridx = 5;
		gbc_beenden.gridy = 0;
		add(beenden, gbc_beenden);
		
		lblBeschreibung = new JLabel("Beschreibung:");
		lblBeschreibung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblBeschreibung = new GridBagConstraints();
		gbc_lblBeschreibung.anchor = GridBagConstraints.NORTH;
		gbc_lblBeschreibung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeschreibung.gridx = 2;
		gbc_lblBeschreibung.gridy = 2;
		add(lblBeschreibung, gbc_lblBeschreibung);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.anchor = GridBagConstraints.NORTHEAST;
		gbc_textArea.gridheight = 3;
		gbc_textArea.gridwidth = 3;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 2;
		add(textArea, gbc_textArea);

	}

	private class Handler extends AbstractAction {
		
		private static final long serialVersionUID = 1L;
		
		public Handler() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
			
			
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			String string = "";
			
			if (event.getSource() == beenden) {
				string = String.format("Du beendest das Program", event.getActionCommand());
			} else {
				string = String.format("Du hast nicht auf das Beenden Feld gedrückt", event.getActionCommand());
			}
			
			JOptionPane.showMessageDialog(null, string);
		}
	}
}
