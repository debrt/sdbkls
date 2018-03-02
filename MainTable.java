import java.awt.Color;
import java.sql.ResultSet;

public class MainTable {
	
	public static void main(String[] args){
		MainTable testTable = new MainTable();
	}
	
	
	public MainTable(){
		
		try{
		ResultSet rset = DBHelper.st.executeQuery(
				"SELECT * FROM schueler;");
		
		while (rset.next()) {
			String klasse = rset.getString(1);
			String name = rset.getString(2);
			String vorname = rset.getString(3);
			System.out.println(klasse + "; " + name + "; " + vorname);
		}
		}catch (Exception xc) {
			xc.printStackTrace();
		}
	}
}