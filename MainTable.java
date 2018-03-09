import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MainTable {

	static String[] attribute = {"Klasse", "Name", "Vorname", "Geburtsdatum","Hallo1","Hallo2","Hallo3","Hallo4","Hallo5"};
	static DefaultTableModel model = new DefaultTableModel(attribute, 0 );
	
	public static DefaultTableModel getTable(){
		refreshTable();
		return model;
	}
	
	public static void refreshTable( ) {
		for(int i = 0; i < model.getRowCount(); i++){
			model.removeRow(i);
		}
		
		model = new DefaultTableModel(attribute, 0);
		
		for(int i = 0; i < 12; i++){
			model.addRow(new String[]{"Q4", "Mustermann", "Max", "20.01.1999"});
			model.addRow(new String[]{"10A", "Beispiel","Bernd","01.01.2000"});
		}
	}
}