public class LogIn(){
	
	JFrame loginFenster;
	JPanel loginPanel;
	
	public static void main(String[] args){
		LogIn login = new LogIn();
	}
	
	public LogIn(){
		
		JFrame loginFenster = new JFrame("Schuldatenbank :: LogIn");
		loginFenster.setSize(300,300);
		
		
		JPanel loginPanel = new JPanel();
		
		JTextField benutzerTF = new JTextField("Benutzername");
		JTextField pwTF = new JTextField("Passwort");
		
		JButton loginButton = new JButton("Einloggen");
		JButton closeButton = new JButton("Beenden");
		
		loginFenster.add(loginPanel);
		loginPanel.add(benutzerTF);
		loginPanel.add(pwTF);
		loginPanel.add(loginButton);
		loginPanel.add(closeButton);
		
	}
	
	
}