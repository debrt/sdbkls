import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
	
    public Suchkonfiguration(){
    }
    
    public static JPanel getPanel(){
    	center();
    	north();
    	east();
    	south();
    	west();
    	konfiguration = new JPanel();
    	konfiguration.setLayout(new BorderLayout());
		konfiguration.setBackground(new Color(1, 68, 131));
    	konfiguration.add(tab1N, BorderLayout.NORTH);
    	konfiguration.add(tab1C, BorderLayout.CENTER);
    	konfiguration.add(tab1W, BorderLayout.WEST);
    	konfiguration.add(tab1E, BorderLayout.EAST);
    	return(konfiguration);
    	//test
    }
    

	
	static void center(){
		tab1C = new JPanel();
		tab1C.setBackground(new Color(1,68,131));
		tab1C.setLayout(new BoxLayout(tab1C, BoxLayout.Y_AXIS));
    	/*try{
    		ResultSet rset = DBHelper.st.executeQuery(
    				"SELECT * FROM schueler where Klasse = 'Klasse';");
    		while (rset.next()) {
    			String klasse = rset.getString(1);
    			String name = rset.getString(2);
    			String dings = rset.getString(3);
    			System.out.println(klasse + "; " + name + "; " + dings);
    			suchkriterien = new String[] {klasse, name, dings};
    		}
    		}catch (Exception xc) {
    			xc.printStackTrace();
    		}*/
		//temporär:-----------------------
		try {
			for(int i=0; i < Startansicht.getTable().getColumnCount(); i++) {
				suchkriterien.add(Startansicht.getTable().getColumnName(i));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		//---------------------------------
    	//Spaltennamen aus sql einbinden und dann mit checkboxen verbinden 
    	for(int i=0; i<suchkriterien.size(); i++) {
    		JCheckBox cb = new JCheckBox(suchkriterien.get(i));
    		cb.setBackground(new Color(1,68,131));
    		cb.setForeground(Color.WHITE);
    		cb.setSelected(true);
    		tab1C.add(cb);
    		checkboxen.add(cb);
    	}
	}
	static void north(){
		tab1N = new JPanel();
        tab1N.setBackground(new Color(1,68,131));
        tab1N.add(LogInWindow.titelPanel);
	}
	static void east(){
		tab1E = new JPanel();
        tab1E.setBackground(new Color(1,68,131));
        JButton filtern = new JButton("Filter ï¿½bernehmen");
        
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
	static void south(){
		tab1S = new JPanel();
        tab1S.setBackground(new Color(1,68,131));
	}
	static void west(){
        tab1W = new JPanel();
        tab1W.setBackground(new Color(1,68,131));
    	tab1W.setLayout(new BoxLayout(tab1W, BoxLayout.Y_AXIS));
	}

    
}
