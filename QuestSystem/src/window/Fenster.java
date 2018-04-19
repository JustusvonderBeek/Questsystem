package window;

import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Fenster extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Handler listener = new Handler();
	private JButton neueQuest;
	private JButton bearbeiteQuest;
	private JButton neuerDialog;
	private JButton bearbeiteDialog;
	private JButton temporary;
	private JButton beenden;
	private JLabel lblBeschreibung;
	private Box DialogBox;
	private JLabel lblDialog;
	private JTextArea textArea_1;
	private Box WindowWrapper;
	private Box InputWrapperQuest;
	private Box BottomBar;
	private Panel panel;
	private JButton btnBeenden;
	
	
	public Fenster() {
		setBorder(UIManager.getBorder("MenuBar.border"));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		WindowWrapper = Box.createVerticalBox();
		WindowWrapper.setBorder(new EmptyBorder(2, 2, 2, 2));
		add(WindowWrapper);
		
		Box Menübar = Box.createHorizontalBox();
		Menübar.setLocation(new Point(3, 0));
		Menübar.setAlignmentY(Component.CENTER_ALIGNMENT);
		Menübar.setBorder(new EmptyBorder(1, 0, 1, 0));
		WindowWrapper.add(Menübar);
		
		neueQuest = new JButton("Neue Quest");
		Menübar.add(neueQuest);
		neueQuest.setAlignmentX(Component.CENTER_ALIGNMENT);
		neueQuest.addActionListener(listener);
		neueQuest.setToolTipText("Erstelle eine neue Quest");
		
		bearbeiteQuest = new JButton("Quest bearbeiten");
		Menübar.add(bearbeiteQuest);
		bearbeiteQuest.setAlignmentX(Component.CENTER_ALIGNMENT);
		bearbeiteQuest.setToolTipText("Bearbeite eine vorhandene Quest");
		
		neuerDialog = new JButton("Neuer Dialog");
		Menübar.add(neuerDialog);
		neuerDialog.setAlignmentX(Component.CENTER_ALIGNMENT);
		neuerDialog.setToolTipText("Erstelle einen neuen Dialog");
		
		bearbeiteDialog = new JButton("Dialog bearbeiten");
		Menübar.add(bearbeiteDialog);
		bearbeiteDialog.setAlignmentX(Component.CENTER_ALIGNMENT);
		bearbeiteDialog.setToolTipText("Zur Zeit nicht implementiert");
		
		temporary = new JButton("Wegpunkte");
		Menübar.add(temporary);
		temporary.setAlignmentX(Component.CENTER_ALIGNMENT);
		temporary.setToolTipText("Zur Zeit nicht implementiert");
		
		beenden = new JButton("Beenden");
		Menübar.add(beenden);
		beenden.setAlignmentX(Component.CENTER_ALIGNMENT);
		beenden.addActionListener(listener);
		
		beenden.setToolTipText("Beendet das Program");
		
		InputWrapperQuest = Box.createVerticalBox();
		InputWrapperQuest.setBorder(new EmptyBorder(1, 0, 1, 0));
		WindowWrapper.add(InputWrapperQuest);
		
		Box BeschreibungBox = Box.createHorizontalBox();
		BeschreibungBox.setBorder(new EmptyBorder(2, 0, 2, 0));
		InputWrapperQuest.add(BeschreibungBox);
		BeschreibungBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		lblBeschreibung = new JLabel("Beschreibung:");
		lblBeschreibung.setBorder(new EmptyBorder(0, 10, 0, 10));
		BeschreibungBox.add(lblBeschreibung);
		lblBeschreibung.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeschreibung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("Hier die Beschreibung einfügen.");
		textArea.setBounds(new Rectangle(10, 10, 50, 50));
		BeschreibungBox.add(textArea);
		
		DialogBox = Box.createHorizontalBox();
		InputWrapperQuest.add(DialogBox);
		
		lblDialog = new JLabel("Dialog:");
		lblDialog.setBorder(new EmptyBorder(0, 10, 0, 10));
		lblDialog.setHorizontalAlignment(SwingConstants.CENTER);
		lblDialog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DialogBox.add(lblDialog);
		
		textArea_1 = new JTextArea();
		DialogBox.add(textArea_1);
		
		BottomBar = Box.createHorizontalBox();
		BottomBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		WindowWrapper.add(BottomBar);
		
		panel = new Panel();
		BottomBar.add(panel);
		
		JButton Speichern = new JButton("Speichern");
		BottomBar.add(Speichern);
		Speichern.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		btnBeenden = new JButton("Beenden");
		btnBeenden.setToolTipText("Beendet das Programm");
		btnBeenden.setAlignmentX(1.0f);
		BottomBar.add(btnBeenden);
		
	}

	public class Handler extends AbstractAction implements ActionListener {
		
		private static final long serialVersionUID = 1L;
		
		public Handler() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
			putValue(DEFAULT, "Das ist ein Test");
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String string = "";
			
			if (e.getSource() == beenden) {
				string = String.format("Du beendest das Program", e.getActionCommand());
				System.exit(0);
			} else {
				string = String.format("Du hast nicht auf das Beenden Feld gedrückt", e.getActionCommand());
			}
			
			JOptionPane.showMessageDialog(null, string);
		}
	}
}
