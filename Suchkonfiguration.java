import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class Suchkonfiguration{
   
	static JPanel konfiguration;
	static JPanel tab1N;
    static JPanel tab1S;
    static JPanel tab1W;
    static JPanel tab1E;
    static JPanel tab1C;
	static ArrayList<String> suchkriterien = new ArrayList<String>();
	static ArrayList<JCheckBox> checkboxen = new ArrayList<JCheckBox>();
    static JTable table;
    
    public static JPanel getPanel(){
    	auswahl();
    	titelZeile();
    	applyButton();
    	konfiguration = new JPanel();
    	konfiguration.setLayout(new GridLayout(5, 2));
		konfiguration.setBackground(new Color(1, 68, 131));
    	konfiguration.add(tab1N);
    	konfiguration.add(tab1C);
    	konfiguration.add(tab1E);
    	return(konfiguration);
    }

	static void auswahl(){
		tab1C = new JPanel();
		tab1C.setBackground(new Color(1,68,131));
		tab1C.setLayout(new BoxLayout(tab1C, BoxLayout.Y_AXIS));
    	
		JPanel tabAnsichten = new JPanel();
		tabAnsichten.setBackground(new Color(1,68,131));
		JRadioButton ansichtSchülerdaten = new JRadioButton("Allgemeine Schülerdaten");
		setup(ansichtSchülerdaten);
		tabAnsichten.add(ansichtSchülerdaten);
		JRadioButton ansichtErziehungsberechtigte = new JRadioButton("Daten zu Erziehungsberechtigten");
		setup(ansichtErziehungsberechtigte);
		tabAnsichten.add(ansichtErziehungsberechtigte);
		tab1C.add(tabAnsichten);
		
		try {
			for(int i=0; i < Startansicht.getTable().getColumnCount(); i++) {
				suchkriterien.add(Startansicht.getTable().getColumnName(i));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
    	for(int i=0; i<suchkriterien.size(); i++) {
    		JCheckBox cb = new JCheckBox(suchkriterien.get(i));
    		cb.setBackground(new Color(1,68,131));
    		cb.setForeground(Color.WHITE);
    		cb.setSelected(true);
    		tab1C.add(cb);
    		checkboxen.add(cb);
    	}
	}
	
	static void titelZeile(){
		tab1N = new JPanel();
        tab1N.setBackground(new Color(1,68,131));
        tab1N.add(LogInWindow.titelPanel);
	}
	static void applyButton(){
		tab1E = new JPanel();
        tab1E.setBackground(new Color(1,68,131));
        JButton filtern = new JButton("Filter übernehmen");
        
        filtern.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		MainTable.refreshTable();
    			Startansicht.getTable().
    				setModel(MainTable.getTable());
        		
        		for (int i=0; i < checkboxen.size(); i++) {
        			if(!checkboxen.get(i).isSelected()) {
        				Startansicht.getTable().removeColumn(
        						Startansicht.getTable().getColumnModel().
        						getColumn(i));
        			}
        		}
        	}
        	
        });
        
    	tab1E.add(filtern);
	}
	static void setup(JRadioButton but){
		but.setBackground(new Color(1,68,131));
		but.setForeground(Color.WHITE);
	}
    
}
