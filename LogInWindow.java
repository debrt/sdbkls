import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInWindow {
	
	//Initialisierung der Variablen
	static JFrame loginFenster;
	static JPanel mainPanel;
	static JPanel titelPanel;
	static JPanel benutzerPanel;
	static JPanel pwPanel;
	static JLabel titelLabel;
	static JLabel klsLogoLabel;
	static JButton loginButton;
	static JButton helpButton;
	static JLabel benutzerBeschriftung;
	static JTextField benutzerField;
	static JLabel pwBeschriftung;
	static JPasswordField pwField;
	static KeyListener enterKL;
	static ActionListener loginAL;
	static ActionListener helpAL;
	static char[] dennisNutzername = {'d','e','n','n','i','s'};
	static char[] theesfeldNutzername = {'t','h','e','e','s','f','e','l','d'};
	static char[] defNutzername = {};
	static String aktuellerBenutzer;
	static JLabel akutellerBenutzerLabel = new JLabel("Kein Benutzer");
	static boolean pwStimmt = false;
	
	public static void main(String[] args){
		new LogInWindow();
	}
	
	public LogInWindow(){        	
		addFenster();
		addMainPanel();
		addTitelPanel();
		addBenutzerPanel();
		addPwPanel();
		addTitelLabel();
		addImg();
		addFieldBeschriftungen();
		addBenutzerField();
		addPwField();
		addLoginButton();
		addHelpButton();
			
		//Hinzufügen der Komponenten zum jeweiligen Panel bzw. zum Fenster
		
		loginFenster.add(mainPanel);
		
		mainPanel.add(titelPanel);
		titelPanel.add(titelLabel);
		titelPanel.add(klsLogoLabel);
		
		mainPanel.add(benutzerPanel);
		benutzerPanel.add(benutzerBeschriftung);
		benutzerPanel.add(benutzerField);
		benutzerPanel.add(loginButton);
		
		mainPanel.add(pwPanel);
		pwPanel.add(pwBeschriftung);
		pwPanel.add(pwField);
		pwPanel.add(helpButton);
		
		loginFenster.setVisible(true);
	}
	
	private static void addFenster(){
		//Setup des Fensters
		loginFenster = new JFrame("SDBKLS | LogIn");
		loginFenster.setSize(300,180);
		loginFenster.setLocationRelativeTo(null);
		loginFenster.setDefaultCloseOperation(loginFenster.EXIT_ON_CLOSE);
	}
	
	private static void addMainPanel(){
		//setup des Haupt-Panels
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(new Color(1, 68, 131));
		
		loginFenster.setFocusTraversalPolicy(new FocusTraversalPolicy() {
			public Component getLastComponent(Container aContainer) {
				return pwField;
			}
			
			public Component getFirstComponent(Container aContainer) {
				return benutzerField;
			}
			
			public Component getDefaultComponent(Container aContainer) {
				return benutzerField;
			}
			
			public Component getComponentBefore(Container aContainer, Component aComponent) {
				return aComponent == benutzerField ? pwField : benutzerField;
			}
			
			public Component getComponentAfter(Container aContainer, Component aComponent) {
				return aComponent == benutzerField ? pwField : benutzerField;
			}
		});
	}
	
	private static void addTitelPanel(){
		//Setup des Panels, in dem Überschrift und Logo liegt
		titelPanel = new JPanel();
		titelPanel.setBackground(new Color(1, 68, 131));
	}
	
	private static void addBenutzerPanel(){
		//Setup des Panels, in dem Benutzereingabefeld und Einloggen-Button liegt
		benutzerPanel = new JPanel();
		benutzerPanel.setBackground(new Color(1,68,131));
	}
	
	private static void addPwPanel(){
		//Setup des Panels, in dem PassworteingabeFeld und Support-Button liegt
		pwPanel = new JPanel();
		pwPanel.setBackground(new Color(1,68,131));
	}
	
	private static void addTitelLabel(){
		//Setup der Überschriftenzeile(n)
		titelLabel = new JLabel("<html><body>"
				+ "KÖNIGIN-LUISE-STIFTUNG BERLIN <br> SCHULDATENBANK"
				+ "</html></body>");
		titelLabel.setForeground(Color.WHITE);
	}
	
	private void addImg(){
		//Setup des KLS-Logo-Bildes
		klsLogoLabel = new JLabel();
		try{
			//Laden der Bild-Datei 
			BufferedImage klsLogo = ImageIO.read(new File("kls_logo.png"));
			//Hinzufügen des Bildes zu einem Panel
			klsLogoLabel = new JLabel(new ImageIcon(klsLogo));
		} catch(Exception e) {System.out.println("Fehler beim Laden des Bildes: " + e);}
	}
	
	private static void addFieldBeschriftungen(){
		//Setup der Beschriftungen der Eingabefelder
		benutzerBeschriftung = new JLabel("<html><body><i>BENUTZER       </i></body></html>");
		benutzerBeschriftung.setForeground(Color.ORANGE);
		pwBeschriftung = new JLabel("<html><body><i>PASSWORT</i></body></html>");
		pwBeschriftung.setForeground(Color.ORANGE);
	}
	
	private static void addBenutzerField(){
		//Setup des Benutzereingabefelds
		benutzerField = new JTextField(9);
		benutzerField.setToolTipText("NUTZER");
		
		benutzerField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) { }
			public void keyReleased(KeyEvent e) { }
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginButton.doClick();
				}
			}
		});
	}
	
	private static void addPwField(){
		//Setup des Passworteingabefelds
		pwField = new JPasswordField(9);
		pwField.setToolTipText("PASSWORT");
		
		pwField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) { }
			public void keyReleased(KeyEvent e) { }
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginButton.doClick();
				}
			}
		});
	}
	
	private static void addLoginButton(){
		//Setup des Einloggen-Buttons
		loginButton = new JButton("Einloggen");
		//Setup der Funktionalität des Einloggen-Buttons
		loginAL = new ActionListener(){
			public void actionPerformed(ActionEvent loginButtonClicked){
				//Auslesen des Passworts
			    char[] pwInput = pwField.getPassword();
			    //Auslesen des Nutzers
			    char[] benutzerInput = benutzerField.getText().toCharArray();
			    //Durchführen der Prüfung, ob Passwort zum Nutzernamen passt 
			    if (loginCheck(pwInput, benutzerInput)){
			    	//Öffnen des Hauptfensters
			        new MainWindow();
			        //Verstecken des Login-Dialogs
			        loginFenster.setVisible(false);
			        //Laden der für den jeweiligen Benutzer voreingestellten Attribute
			        loadPersonalPreset(benutzerInput);
			    } else {
			        //Falls Passwort fehlerhaft: Mitteilungs-Box mit Benachrichtigung über fehlerhafte Eingabe
			    	JOptionPane.showMessageDialog(loginFenster,
			            "<html><body>Passwort oder Benutzername fehlerhaft.<br>"
			            + "Versuchen Sie es erneut.</body></html>", "Meldung", JOptionPane.ERROR_MESSAGE);
			        //Löschung des eingegebenen Passworts, um einen erneuten Versuch zu erleichtern
			    	pwField.setText("");
			    }
			    //Nullsetzen der Variable, in der das Passwort gespeichert wurde (Aus Sicherheitsgründen)
			    Arrays.fill(pwInput, '0');
			    }
		};
		//Hinzufügen der Funktionalität zum Einloggen-Button
		loginButton.addActionListener(loginAL);
	}
	
	private static void addHelpButton(){
		//Setup des Sopprt-Buttons
		helpButton = new JButton("  Support  ");
		//Setup der Funktionalität des Support-Buttons
		helpAL = new ActionListener(){
			public void actionPerformed(ActionEvent helpButtonClicked){
				//Beim Klick wird eine Mitteilung aufgerufen,
				//die Kontaktinformationen für Support-Fälle mitteilt
				JOptionPane.showMessageDialog(loginFenster, "<html><body>"
						+ "The cake is a lie.<br>IT-Administration: Durchwahl 132</body></html>",
						"Support", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		//Hinzufügen der Funktionalität zum Support-Button
		helpButton.addActionListener(helpAL);
	}
	
	private static boolean loginCheck(char[] pwInput, char[] benutzerInput) {
		//Testen, ob der Benutzername gefunden wird.
		//Falls ja: Durchführen der Passwort-Überprüfung mit dem dem Nutzer zugehörigen Passwort
		if (Arrays.equals(benutzerInput, dennisNutzername)){
			char[] pwEcht = {'g','e','l','b'};
			pwStimmt = hilfsCheck(pwInput, pwEcht, benutzerInput);
		}
		if (Arrays.equals(benutzerInput, defNutzername)){
			char[] pwEcht = {};
			pwStimmt = hilfsCheck(pwInput, pwEcht, benutzerInput);
		}
		if (Arrays.equals(benutzerInput, theesfeldNutzername)){
			char[] pwEcht = {'p','a','s','s','w','o','r','t'};
			pwStimmt = hilfsCheck(pwInput, pwEcht, benutzerInput);
		} 
		//Boolean-Rückgabe (ja/nein), ob die Anmeldeinformationen korrekt sind 
	    return pwStimmt;
	}
	
	private static boolean hilfsCheck(char[] pwInput, char[] pwEcht, char[] benutzerInput){
		//Überprüfung der Übereinstimmung der Charaktersets beider Passwärter (Eingabe u. Gespeichertes)
		pwStimmt = Arrays.equals (pwInput, pwEcht);
		//Nullsetzen der Variable, in der das Passwort gespeichert wurde (Aus Sicherheitsgründen)
	    Arrays.fill(pwEcht,'0');
	    //Ausgabe des Aktuellen Benutzers im Terminal (zu Test-Zwecken)
		System.out.println(new String(benutzerInput));
	    return pwStimmt;
	}
	
	public static void loadPersonalPreset(char[] benutzerInput){
		if (Arrays.equals(benutzerInput, dennisNutzername)){
			applyPreset(3);
			applyPreset(4);
			applyPreset(5);
		} 
	}
	
	public static void applyPreset(int i){
		Suchkonfiguration.checkboxen.get(i).setSelected(false);
		Startansicht.getTable().removeColumn(Startansicht.getTable().getColumnModel().getColumn(i));
	}
}