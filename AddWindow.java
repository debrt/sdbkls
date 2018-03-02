import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

public class AddWindow extends JFrame {
	private static final long serialVersionUID = 7094360393888216438L;

	public AddWindow() {
		super("Schüler hinzufügen");
		
		setLayout(new GridBagLayout());
		
		JLabel nameLabel = new JLabel("Nachname: ");
		JLabel vornameLabel = new JLabel("Vorname: ");
		JLabel klasseLabel = new JLabel("Klasse: ");
		JLabel gebDatumLabel = new JLabel("Geburtsdatum: ");
		JLabel strasseLabel = new JLabel("Straße: ");
		JLabel hausNrLabel = new JLabel("Hausnummer: ");
		JLabel plzLabel = new JLabel("PLZ: ");
		JLabel ortLabel = new JLabel("Ort: ");
		JLabel medBesLabel = new JLabel("Medizinische Besonderheiten: ");
		JLabel anmerkLabel = new JLabel("Anmerkungen: ");
		JLabel beitrittDatLabel = new JLabel("KLS-Beitrittsdatum: ");
		
		JTextField nameInput = new JTextField();
		JTextField vornameInput = new JTextField();
		JTextField klasseInput = new JTextField();
		JTextField gebDatumInput = new JTextField();
		JTextField strasseInput = new JTextField();
		JTextField hausNrInput = new JTextField();
		JTextField plzInput = new JTextField();
		JTextField ortInput = new JTextField();
		JTextArea medBesInput = new JTextArea();
		JTextArea anmerkInput = new JTextArea();
		JTextField beitrittDatInput = new JTextField();
		
		GridBagConstraints ctts = new GridBagConstraints(0, 0, 1, 1, 1, 1,
				0, 0, new Insets(0, 0, 0, 0), 0, 0);
		add(nameLabel, ctts);
		ctts.gridx = 1;
		add(nameInput);
		
		ctts.gridy++;
		ctts.gridx = 0;
		add(vornameLabel);
		ctts.gridx = 1;
		add(vornameInput);
		
		ctts.gridy++;
		ctts.gridx = 0;
		add(klasseLabel);
		ctts.gridx = 1;
		add(klasseInput);
		
		ctts.gridy++;
		ctts.gridx = 0;
		add(gebDatumLabel);
		ctts.gridx = 1;
		add(gebDatumInput);
		
		ctts.gridy++;
		ctts.gridx = 0;
		add(strasseLabel);
		ctts.gridx = 1;
		add(strasseInput);
		
		ctts.gridy++;
		ctts.gridx = 0;
		add(hausNrLabel);
		ctts.gridx = 1;
		add(hausNrInput);
		
		ctts.gridy++;
		ctts.gridx = 0;
		add(plzLabel);
		ctts.gridx = 1;
		add(plzInput);
		
		ctts.gridy++;
		ctts.gridx = 0;
		add(ortLabel);
		add(ortInput);
		add(medBesLabel);
		JScrollPane medBesPane = new JScrollPane(medBesInput);
		add(medBesPane);
		add(anmerkLabel);
		add(new JScrollPane(anmerkInput));
		add(beitrittDatLabel);
		add(beitrittDatInput);
		
		JButton addButton = new JButton("OK");
		JButton cancelButton = new JButton("Abbrechen");
		
		add(addButton);
		add(cancelButton);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AddWindow();
	}
}
