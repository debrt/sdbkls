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
    	konfiguration.setLayout(new BorderLayout());
		konfiguration.setBackground(new Color(1, 68, 131));
    	konfiguration.add(tab1N, BorderLayout.NORTH);
    	konfiguration.add(tab1C, BorderLayout.CENTER);
    	konfiguration.add(tab1W, BorderLayout.WEST);
    	konfiguration.add(tab1E, BorderLayout.EAST);
    	return(konfiguration);
    }

    static void presets(){
    	tab1W = new JPanel();
    	tab1W.setLayout(new BoxLayout(tab1W, BoxLayout.Y_AXIS));
		tab1W.setBackground(new Color(1,68,131));
		JLabel presetLabel = new JLabel("Datensatz Preset: ");
        presetLabel.setForeground(Color.WHITE);
        String[] presets = {"Schüler*innen", "+Erziehungsberechtigte"};
        JComboBox<String> presetAuswahl= new JComboBox<String>(presets);
        presetAuswahl.setMaximumSize(new Dimension(150,28));
        tab1W.add(presetLabel);
		tab1W.add(presetAuswahl);
    }
    
	static void auswahl(){
		tab1C = new JPanel();
		tab1C.setBackground(new Color(1,68,131));
		tab1C.setLayout(new BoxLayout(tab1C, BoxLayout.Y_AXIS));
		try {
			for(int i=0; i < Startansicht.getTable().getColumnCount(); i++) {
				suchkriterien.add(Startansicht.getTable().getColumnName(i));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
    	for(int i=0; i<suchkriterien.size(); i++) {
    		JPanel pa = new JPanel();
    		pa.setBackground(new Color(1,68,131));
    		pa.setLayout(new FlowLayout(FlowLayout.CENTER));
    		JCheckBox cb = new JCheckBox(suchkriterien.get(i));
    		cb.setBackground(new Color(1,68,131));
    		cb.setForeground(Color.WHITE);
    		cb.setSelected(true);
    		pa.add(cb);
    		tab1C.add(pa);
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
        		
        		for (int i=0; i < checkboxen.size(); i++) {
        			if(!checkboxen.get(i).isSelected()) {
        				Startansicht.getTable().removeColumn(Startansicht.getTable().getColumnModel().getColumn(i));
        			}
        			else {
        				//Startansicht.getTable().addColumn(Startansicht.getTable().getColumnModel().getColumn(i));
        			}
        		}
        	}
        });
    	tab1E.add(filtern);
	}    
}
