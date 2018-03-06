import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Suchkonfiguration
{
	
	JPanel konfiguration;
   
    public Suchkonfiguration()
    {
    	
    }
    
    
    public static JPanel getPanel() {
    	
    	JPanel konfiguration = new JPanel();
    	konfiguration.setLayout(new FlowLayout());
    	
    	String[] CheckBoxen = new String[] {"Name", "Alter", "Test", "Test2"};
    	
    	//Spaltennamen aus sql einbinden und dann mit checkboxen verbinden 
    	
    	for(int i=0; i<CheckBoxen.length; i++) {
    		JCheckBox cb = new JCheckBox(CheckBoxen[i]);
    		konfiguration.add(cb);
    	}
    	
    	return(konfiguration);
    }

    
    
}
