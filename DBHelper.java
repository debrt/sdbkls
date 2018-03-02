import java.sql.*; 
import java.util.ArrayList;
/**
 * Diese Klasse stellt die Möglichkeit bereit, Anfragen an die Datenbank zu stellen. 
 * @author Reher
 * Bearbeitet durch Vincent W. 
 * @version Vorlage 1.0
 */
public class DBHelper{
    static String treiber = "org.sqlite.JDBC";    
    static String protokoll = "jdbc:sqlite:";
    static String datenbank = "sdbklsPrototyp.db";
	static Connection conn;
    static Statement st;
    ResultSet rset;
    
    //Eine unterstützende Methode, die die Verbindung zur oben angegebenen Datenbank herstellt    
    private static void openVerbindung() {
        try {
            // Passenden Treiber laden
            Class.forName(treiber);
            // Verbindung zur DB erstellen
            conn = DriverManager.getConnection (protokoll+datenbank);
            ausgeben("Verbindung zur Datenbank steht.");
            // Erzeugen eines Statements durch das Verbindungs-Objekt
            st = conn.createStatement(); 
        } catch (Exception e) {
            ausgeben("Fehler beim Erstellen der Verbindung: "+e);
        }
    }
        
    //Eine unterstützende Methode, die die Verbindung nach der Benutzung wieder schließt
    private void closeVerbindung() {
        try {
            // Ergebnismenge schliessen
            rset.close();
            // Statement schliessen
            st.close();
            // Verbindung schliessen     
            conn.close();
            ausgeben("Abgemeldet.\n");
        } catch (Exception e) {
            ausgeben("Fehler beim Schließen der Verbindung: "+e);
        }
    }
    
    
    //@param s Der auszugebende String.
    private static void ausgeben(String s) {
        System.out.println(s);
    }
    
    static{openVerbindung();}
}
