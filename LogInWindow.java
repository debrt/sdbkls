import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	static JFrame loginFenster;
	static JPanel mainPanel;
	static JPanel titelPanel;
	static JPanel benutzerPanel;
	static JPanel pwPanel;
	static JLabel titelLabel;
	JLabel klsLogoLabel;
	static JButton loginButton;
	static JButton helpButton;
	static JLabel benutzerBeschriftung;
	static JTextField benutzerField;
	static JLabel pwBeschriftung;
	static JPasswordField pwField;
	static KeyListener enterKL;
	static ActionListener loginAL;
	static ActionListener helpAL;
	static char[] vincentNutzername = {'v','i','n','c','e','n','t'};
	static char[] dennisNutzername = {'d','e','n','n','i','s'};
	static char[] jonathanNutzername = {'j','o','n','a','t','h','a','n'};
	static char[] julianNutzername = {'j','u','l','i','a','n'};
	static char[] benediktNutzername = {'b','e','n','e','d','i','k','t'};
	static char[] sidneyNutzername = {'s','i','d','n','e','y'};
	static String aktuellerBenutzer;
	static JLabel akutellerBenutzerLabel = new JLabel("Kein Benutzer");
	static boolean pwStimmt = false;
	
	public static void main(String[] args){
		new LogInWindow();
	}
	
	public LogInWindow(){        
			
		//MainTable testDataOutput = new MainTable();
		
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
		loginFenster = new JFrame("SDBKLS | LogIn");
		//loginFenster.setExtendedState(JFrame.MAXIMIZED_BOTH);
		loginFenster.setSize(300,180);
		loginFenster.setLocationRelativeTo(null);
		loginFenster.setDefaultCloseOperation(loginFenster.EXIT_ON_CLOSE);
	}
	
	private static void addMainPanel(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(new Color(1, 68, 131));
	}
	
	private static void addTitelPanel(){
		titelPanel = new JPanel();
		titelPanel.setBackground(new Color(1, 68, 131));
	}
	
	private static void addBenutzerPanel(){
		benutzerPanel = new JPanel();
		benutzerPanel.setBackground(new Color(1,68,131));
	}
	
	private static void addPwPanel(){
		pwPanel = new JPanel();
		pwPanel.setBackground(new Color(1,68,131));
	}
	
	private static void addTitelLabel(){
		titelLabel = new JLabel("<html><body>"
				+ "KÖNIGIN-LUISE-STIFTUNG BERLIN <br> SCHULDATENBANK"
				+ "</html></body>");
		titelLabel.setForeground(Color.WHITE);
	}
	
	private void addImg(){
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
	
	private static void addLoginButton(){
		loginButton = new JButton("Einloggen");
		//loginButton.setPreferredSize(new Dimension(90,28));
		loginAL = new ActionListener(){
			public void actionPerformed(ActionEvent loginButtonClicked){
			        char[] pwInput = pwField.getPassword();
			        char[] benutzerInput = benutzerField.getText().toCharArray();
			        if (loginCheck(pwInput, benutzerInput)){
			            new MainWindow();
			            loginFenster.setVisible(false);
			        } else {
			            JOptionPane.showMessageDialog(loginFenster,
			                "<html><body>Passwort oder Benutzername fehlerhaft.<br>"
			                + "Versuchen Sie es erneut.</body></html>", "Meldung", JOptionPane.ERROR_MESSAGE);
			            pwField.setText("");
			        }
			        Arrays.fill(pwInput, '0');
			    }
		};
		loginButton.addActionListener(loginAL);
	}
	
	private static void addHelpButton(){
		helpButton = new JButton("  Support  ");
		//helpButton.setPreferredSize(new Dimension(90,28));
		helpAL = new ActionListener(){
			public void actionPerformed(ActionEvent helpButtonClicked){
				JOptionPane.showMessageDialog(loginFenster, "<html><body>"
						+ "The cake is a lie.<br>IT-Administration: Durchwahl 132</body></html>",
						"Support", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		helpButton.addActionListener(helpAL);
	}
	
	private static boolean loginCheck(char[] pwInput, char[] benutzerInput) {
		if (Arrays.equals(benutzerInput, vincentNutzername)){
			char[] pwEcht = {'p','i','n','k'};
			pwStimmt = hilfsCheck(pwInput, pwEcht, benutzerInput);
		}
		if (Arrays.equals(benutzerInput, dennisNutzername)){
			char[] pwEcht = {'g','e','l','b'};
			pwStimmt = hilfsCheck(pwInput, pwEcht, benutzerInput);
		}
		if (Arrays.equals(benutzerInput, julianNutzername)){
			char[] pwEcht = {'p','i','n','k'};
			pwStimmt = hilfsCheck(pwInput, pwEcht, benutzerInput);
		}
		if (Arrays.equals(benutzerInput, jonathanNutzername)){
			char[] pwEcht = {'f','l','i','e','d','e','r'};
			pwStimmt = hilfsCheck(pwInput, pwEcht, benutzerInput);
		} 
		if (Arrays.equals(benutzerInput, benediktNutzername)){
			char[] pwEcht = {'r','o','s','a'};
			pwStimmt = hilfsCheck(pwInput, pwEcht, benutzerInput);
		}
		if (Arrays.equals(benutzerInput, sidneyNutzername)){
			char[] pwEcht = {'m','a','g','e','n','t','a'};
			pwStimmt = hilfsCheck(pwInput, pwEcht, benutzerInput);
		} 
	    return pwStimmt;
	}
	
	private static boolean hilfsCheck(char[] pwInput, char[] pwEcht, char[] benutzerInput){
		pwStimmt = Arrays.equals (pwInput, pwEcht);
	    Arrays.fill(pwEcht,'0');
		System.out.println(new String(benutzerInput));
	    return pwStimmt;
	}
}