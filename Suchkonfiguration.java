import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Suchkonfiguration{
   
	//Initialisierung der Variablen
	static JPanel konfiguration;
	static JPanel tab1N;
    static JPanel tab1S;
    static JPanel tab1W;
    static JPanel tab1E;
    static JPanel tab1C;
	static ArrayList<String> suchkriterien = new ArrayList<String>();
	static ArrayList<JCheckBox> checkboxen = new ArrayList<JCheckBox>();
	static ArrayList<JPanel> panels = new ArrayList<JPanel>();
    static JTable table;
    
    public static JPanel getPanel(){
    	auswahl();
    	titelZeile();
    	applyButton();
    	presets();
    	
    	konfiguration = new JPanel();
    	
    	//Hinzufügen der Komponenten zum Hauptpanel bzw. zum Fenster
    	konfiguration.setLayout(new BorderLayout());
		konfiguration.setBackground(new Color(1, 68, 131));
    	konfiguration.add(tab1N, BorderLayout.NORTH);
    	konfiguration.add(tab1C, BorderLayout.CENTER);
    	konfiguration.add(tab1W, BorderLayout.WEST);
    	konfiguration.add(tab1E, BorderLayout.EAST);
    	//Rückgabe des erstellten Panels an MainWindow, wo dieses als Tab hinzugefügt wird
    	return(konfiguration);
    }

    static void presets(){
    	//Setup des linken Seit-Panels
    	tab1W = new JPanel();
    	tab1W.setLayout(new BoxLayout(tab1W, BoxLayout.Y_AXIS));
		tab1W.setBackground(new Color(1,68,131));
		//Setup der Auswahl von Presets (vordefinierten Ansichtseinstellungen)
		JLabel presetLabel = new JLabel("Preset: ");
        presetLabel.setForeground(Color.WHITE);
        String[] presets = {"Schüler*innen", "Erziehungsberechtigte", "Klassendaten"};
        JComboBox<String> presetAuswahl= new JComboBox<String>(presets);
        presetAuswahl.setMaximumSize(new Dimension(150,28));
        //Hinzufügen der Preset-Auswahl zum linken Seit-Panel
        tab1W.add(presetLabel);
		tab1W.add(presetAuswahl);
    }
    
	static void auswahl(){
		//Setup des mittleren Haupt-Panels
		tab1C = new JPanel();
		tab1C.setBackground(new Color(1,68,131));
		tab1C.setLayout(new BoxLayout(tab1C, BoxLayout.Y_AXIS));
		//Auslesen der verfügbaren Attribute aus der Startansichtstabelle
		//(dies sollte später aus der Datenbank ausgelesen werden)
		try {
			for(int i=0; i < Startansicht.getTable().getColumnCount(); i++) {
				//Jedes Attribut wird als String in einem Array gespeichert
				suchkriterien.add(Startansicht.getTable().getColumnName(i));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		//Für jeden String im Array suchkriterien wird diese Schleife einmal ausgeführt
    	for(int i=0; i<suchkriterien.size(); i++) {
    		//Setup eines neuen Panels
    		JPanel pa = new JPanel();
    		pa.setBackground(new Color(1,68,131));
    		//(Ist notwendig, um eine mittige Ausrichtung der Komponenten einzustellen)
    		pa.setLayout(new FlowLayout(FlowLayout.CENTER));
    		//Hinzfügen einer Checkbox für jedes Attribut
    		JCheckBox cb = new JCheckBox(suchkriterien.get(i));
    		cb.setBackground(new Color(1,68,131));
    		cb.setForeground(Color.WHITE);
    		cb.setSelected(true);
    		//Hinzufügen der Checkboxen zum Panel
    		pa.add(cb);
    		//Hinzufügen des jeweiligen Panels zum Mitte-Panel
    		tab1C.add(pa);
    		//Speichern der Checkboxen in einem Array (später zur Auslese benötigt)
    		checkboxen.add(cb);
    	}
	}
	
	static void titelZeile(){
		//Setup des obigen Titel/Überschriften-Panels
		tab1N = new JPanel();
        tab1N.setBackground(new Color(1,68,131));
        //Hinzufügen von Überschrift und Logo aus dem LogIn-Window (Code-Ersparnis)
        tab1N.add(LogInWindow.titelPanel);
	}
	static void applyButton(){
		//Setup des rechtsseitigen Panels
		tab1E = new JPanel();
        tab1E.setBackground(new Color(1,68,131));
        //Hinzufügen eines Knopfes zum übernehmen der Auswahl
        JButton filtern = new JButton("Filter übernehmen");
        //Setup & HInzufügen der Funktionalität dieses Knopfes
        filtern.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		applyAttributeSelection();
        	}
        });
        //Hinzufügen des Knopfes zum rechtsseitigen Panel 
    	tab1E.add(filtern);
	}    
	
	public static void applyAttributeSelection(){
		MainTable.refreshTable();
		Startansicht.getTable().setModel(MainTable.getTable());
		
		int columnIndex = 0;
		
		//Für jede Checkbox wird nachfolgender Code einmal ausgeführt
		for (int i=0; i < checkboxen.size(); i++) {
			//Ist eine Checkbox deaktiviert wird folgender Code ausgeführt
			if(!checkboxen.get(i).isSelected()) {
				//Das Attribut bzw. die Spalte an Stelle i wird
				// aus der Tabelle entfernt
				Startansicht.getTable().removeColumn(
						Startansicht.getTable().getColumnModel().getColumn(
								columnIndex));
			} else columnIndex++;
		}
	}
}
