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
		JTable table = Startansicht.getTable();
		for(int i = 0; i < model.getColumnCount(); i++){
			//table.getColumnModel().removeColumn(table.getColumnModel().getColumn(i));
		}
		TableColumn c = new TableColumn();
		c.setHeaderValue("Klasse");
		//table.getColumnModel().addColumn(c);
		
		//model = new DefaultTableModel(attribute, 0 );
		//test2
		
		for(int i = 0; i < 50; i++){
			model.addRow(new String[]{"Q4", "Mustermann", "Max", "20.01.1999"});
			model.addRow(new String[]{"10A", "Beispiel","Bernd","01.01.2000"});
		}
	}
}