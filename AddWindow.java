import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class AddWindow extends JFrame {
	private static final long serialVersionUID = 7094360393888216438L;

	public AddWindow(AddWindowListener listener) {
		super("SchÃ¼ler hinzufÃ¼gen");
		
		setLayout(new GridBagLayout());
		//TO DO: die Felder über einen for-loop hinzufügen, der die überschriften der tabelle ausliest (siehe Suchkonfiguration buttons)
		JLabel nameLabel = new JLabel("Nachname: ");
		JLabel vornameLabel = new JLabel("Vorname: ");
		JLabel klasseLabel = new JLabel("Klasse: ");
		JLabel gebDatumLabel = new JLabel("Geburtsdatum: ");
		JLabel strasseLabel = new JLabel("StraÃŸe: ");
		JLabel hausNrLabel = new JLabel("Hausnummer: ");
		JLabel plzLabel = new JLabel("PLZ: ");
		JLabel ortLabel = new JLabel("Ort: ");
		JLabel beitrittDatLabel = new JLabel("KLS-Beitrittsdatum: ");
		JLabel medBesLabel = new JLabel("Medizinische Besonderheiten: ");
		JLabel anmerkLabel = new JLabel("Anmerkungen: ");
		
		JTextField nameInput = new JTextField();
		JTextField vornameInput = new JTextField();
		JTextField klasseInput = new JTextField();
		JTextField gebDatumInput = new JTextField();
		JTextField strasseInput = new JTextField();
		JTextField hausNrInput = new JTextField();
		JTextField plzInput = new JTextField();
		JTextField ortInput = new JTextField();
		JTextField beitrittDatInput = new JTextField();
		JTextArea medBesInput = new JTextArea();
		JTextArea anmerkInput = new JTextArea();
		
		GridBagConstraints ctts = new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.WEST, 0, new Insets(0, 0, 0, 0), 0, 0);
		add(nameLabel, ctts);
		ctts.gridy++;
		add(vornameLabel, ctts);
		ctts.gridy++;
		add(klasseLabel, ctts);
		ctts.gridy++;
		add(gebDatumLabel, ctts);
		ctts.gridy++;
		add(strasseLabel, ctts);
		ctts.gridy++;
		add(hausNrLabel, ctts);
		ctts.gridy++;
		add(plzLabel, ctts);
		ctts.gridy++;
		add(ortLabel, ctts);
		ctts.gridy++;
		add(beitrittDatLabel, ctts);
		ctts.gridy++;
		add(medBesLabel, ctts);
		ctts.gridy++;
		add(anmerkLabel, ctts);
		
		ctts.gridx = 1;
		ctts.gridy = 0;
		ctts.weightx = 1;
		ctts.fill = GridBagConstraints.HORIZONTAL;
		add(nameInput, ctts);
		ctts.gridy++;
		add(vornameInput, ctts);
		ctts.gridy++;
		add(klasseInput, ctts);
		ctts.gridy++;
		add(gebDatumInput, ctts);
		ctts.gridy++;
		add(strasseInput, ctts);
		ctts.gridy++;
		add(hausNrInput, ctts);
		ctts.gridy++;
		add(plzInput, ctts);
		ctts.gridy++;
		add(ortInput, ctts);
		ctts.gridy++;
		add(beitrittDatInput, ctts);
		ctts.weighty = 1;
		ctts.fill = GridBagConstraints.BOTH;
		ctts.anchor = GridBagConstraints.SOUTHEAST;
		ctts.gridy++;
		medBesInput.setBorder(nameInput.getBorder());
		add(medBesInput, ctts);
		ctts.gridy++;
		anmerkInput.setBorder(nameInput.getBorder());
		add(anmerkInput, ctts);
		
		JButton addButton = new JButton("OK");
		JButton cancelButton = new JButton("Abbrechen");
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				listener.onOkButtonClicked(vornameInput.getText().trim(),
						nameInput.getText().trim(),
						klasseInput.getText().trim(),
						gebDatumInput.getText().trim(),
						strasseInput.getText().trim(),
						hausNrInput.getText().trim(),
						plzInput.getText().trim(),
						ortInput.getText().trim(),
						beitrittDatInput.getText().trim(),
						medBesInput.getText().trim(),
						anmerkInput.getText().trim());
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				listener.onCancelled();
			}
		});
		
		addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) { }
			public void windowIconified(WindowEvent e) { }
			public void windowDeiconified(WindowEvent e) { }
			public void windowDeactivated(WindowEvent e) { }
			public void windowClosing(WindowEvent e) {
				listener.onCancelled();
			}
			public void windowClosed(WindowEvent e) { }
			public void windowActivated(WindowEvent e) { }
		});
		
		JPanel buttonsPanel = new JPanel();
		ctts.gridy++;
		ctts.weighty = 0;
		add(buttonsPanel, ctts);
		
		ctts = new GridBagConstraints(0, 0, 1, 1, 1, 0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0);
		buttonsPanel.add(addButton, ctts);
		ctts.gridx++;
		buttonsPanel.add(cancelButton, ctts);
		
		pack();
		setSize(600, getHeight());
		setVisible(true);
	}
}
