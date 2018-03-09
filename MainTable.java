import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainTable {

	static String[] attribute = {"Klasse", "Name", "Vorname", "Geburtsdatum"};
	static DefaultTableModel model = new DefaultTableModel(attribute, 0 );
	
	public static DefaultTableModel getTable(){
		refreshTable();
		return model;
	}
	
	public static void refreshTable( ) {
		for(int i = 0; i < model.getRowCount(); i++){
			model.removeRow(i);
		}
		for(int i = 0; i < 50; i++){
			model.addRow(new String[]{"Q4", "Mustermann", "Max", "20.01.1999"});
			model.addRow(new String[]{"10A", "Beispiel","Bernd","01.01.2000"});
		}
		
	}
}