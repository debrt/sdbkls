import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Suchkonfiguration{
   
	static JPanel konfiguration;
	static JLabel titelLabel;
	static JLabel klsLogoLabel;
	static JLabel benutzerBeschriftung;
	static JLabel pwBeschriftung;
	static JTextField benutzerField;
	static JTextField pwField;
	
    public Suchkonfiguration(){
    }
    
    public static JPanel getPanel(){
    	
    	konfiguration = new JPanel();
    	konfiguration.setLayout(new FlowLayout());
    	konfiguration.setLayout(new BoxLayout(konfiguration, BoxLayout.Y_AXIS));
		konfiguration.setBackground(new Color(1, 68, 131));
    	
    	addTitelLabel();
    	addImg();
    	addFieldBeschriftungen();
    	addBenutzerField();
    	addPwField();
    	
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
    		konfiguration.add(titelLabel);
    		konfiguration.add(klsLogoLabel);
    		konfiguration.add(benutzerBeschriftung);
    		konfiguration.add(benutzerField);
    		konfiguration.add(pwBeschriftung);
    		konfiguration.add(pwField);
    		konfiguration.add(cb);
    	}
    	
    	return(konfiguration);
    }
	
	private static void addTitelLabel(){
		titelLabel = new JLabel("<html><body>"
				+ "KöNIGIN-LUISE-STIFTUNG BERLIN <br> SCHULDATENBANK"
				+ "</html></body>");
		titelLabel.setForeground(Color.WHITE);
	}
	
	private static void addImg(){
		klsLogoLabel = new JLabel();
		try{
			BufferedImage klsLogo = ImageIO.read(new File("kls_logo.png"));
			klsLogoLabel = new JLabel(new ImageIcon(klsLogo));
		} catch(Exception e) {System.out.println("Fehler beim Laden des Bildes: " + e);}
		if (klsLogoLabel == null){
			klsLogoLabel = new JLabel("KLS-Logo");
		}
	}
	
	private static void addFieldBeschriftungen(){
		benutzerBeschriftung = new JLabel("<html><body><i>BENUTZER       </i></body></html>");
		benutzerBeschriftung.setForeground(Color.ORANGE);
		pwBeschriftung = new JLabel("<html><body><i>PASSWORT</i></body></html>");
		pwBeschriftung.setForeground(Color.ORANGE);
	}
	
	private static void addBenutzerField(){
		benutzerField = new JTextField(9);
		benutzerField.setToolTipText("NUTZER");
	}
	
	private static void addPwField(){
	pwField = new JPasswordField(9);
	pwField.setToolTipText("PASSWORT");
}
    
    
}
