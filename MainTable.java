import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainTable {
	
	public static DefaultTableModel getTable(){
		String[] attribute = {"Klasse", "Name", "Vorname", "Geburtsdatum"};
		DefaultTableModel model = new DefaultTableModel(attribute, 0 );
		for(int i = 0; i < 50; i++){
			model.addRow(getRow());
			model.addRow(new String[]{"10A", "Bernd","Beispiel","01.01.2000"});
		}
		return model;
	}
	
	static String[] getRow(){
		String[] newRow = {"Q4", "Mustermann", "Max", "20.01.1999"};
		return newRow;
	}
}