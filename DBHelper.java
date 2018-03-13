import java.sql.*; 
import java.util.ArrayList;
/**
 * Diese Klasse stellt die Möglichkeit bereit, Anfragen an die Datenbank zu stellen. 
 * @author Reher
 * Bearbeitet durch Vincent W. 
 * @version 2018-03-09
 */
public class DBHelper{
    String treiber = "com.mysql.jdbc.Driver";    
    String protokoll = "jdbc:mysql://win2k12r2-svr-1.informatik.kls-berlin.de/";
    String datenbank = "schuldatenbank";
    String user = "admin";
    String kennwort = "aschurov";
	Connection conn;
    Statement st;
    ResultSet rset;
    
    /**
     * Eine Beispielabfrage an die Datenbank, die einen Teil der Lehrer-Tabelle abfragt
     */
    public ArrayList<Object[]> getLehrer() {
        String query = "SELECT Kürzel, Name, Vorname FROM lehrer;";
        ArrayList<Object[]> rows = new ArrayList<>();
        
        openVerbindung();
        try {           
            rset = st.executeQuery(query);
            
            while (rset.next()){
                rows.add(new String[] {
                    rset.getString(1),
                    rset.getString(2),
                    rset.getString(3)
                });
            }
        } catch (Exception e) {
            ausgeben("Fehler: "+e+"\n trat bei diesem Query auf: \n"+query);
        }    
        closeVerbindung();
        
        return rows;
    }
    
    /**
     * Eine beispielhafte Eingabe des oben abgerufenen Teils der Lehrer-Tabelle
     */
    public void setLehrer(String kuerzel, String name, String vorname) {
        String query = "INSERT INTO lehrer (Kürzel, Name, Vorname) VALUES ('"+kuerzel+"', '"+name+"', '"+vorname+"');";
    
        openVerbindung();
        try { 
            st.execute(query);
        } catch (Exception e) {
            ausgeben("Fehler: "+e+"\n trat bei diesem Query auf: \n"+query);
        }    
        closeVerbindung(); 
    }
    
    //Eine unterstützende Methode, die die Verbindung zur oben angegebenen Datenbank herstellt    
    private  void openVerbindung() {
        try {
            // Passenden Treiber laden
            Class.forName(treiber);
            // Verbindung zur DB erstellen
            conn = DriverManager.getConnection (protokoll+datenbank, user, kennwort);
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
    private void ausgeben(String s) {
        System.out.println(s);
    }
    
}
