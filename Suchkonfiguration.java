import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Suchkonfiguration{
   
    public Suchkonfiguration(){
    }
    
    public static JPanel getPanel(){
    	
    	JPanel konfiguration = new JPanel();
    	konfiguration.setLayout(new FlowLayout());
    	String[] suchkriterien = {};
    	try{
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
    		}
    	
    	//Spaltennamen aus sql einbinden und dann mit checkboxen verbinden 
    	
    	for(int i=0; i<suchkriterien.length; i++) {
    		JCheckBox cb = new JCheckBox(suchkriterien[i]);
    		konfiguration.add(cb);
    	}
    	
    	return(konfiguration);
    }

    
    
}
