import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


 
public class MainWindow {
    JFrame frame;
    JTabbedPane tabs;
    JPanel tab1;
    JPanel tab2;
    JPanel tab1N;
    JPanel tab1S;
    JPanel tab1W;
    JPanel tab1E;
    JPanel tab1C;
    JTable table;
    
    JButton search;
    JButton settings;
    JButton add;
    
    JLabel lb;
    
    JTextField suche;
    
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
	}
	

    public MainWindow() {
    	DefaultTableModel model = new DefaultTableModel(new String[] {"Test1", "Test2"}, 0 );
    	table = new JTable(model);
        frame = new JFrame("SchülerDatenbank");
        tabs = new JTabbedPane();
        
        search = new JButton("Suchen");
        add = new JButton("Hinzufügen");
        add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWindowListener listener = new AddWindowListener() {
					public void onOkButtonClicked(String vorname, String name,
							String klasse, String gebDatum, String strasse,
							String hausNummer, String plz, String ort,
							String beitrittsDatum, String medBesonderheiten,
							String anmerkungen) {
						frame.setEnabled(true);
						// TODO: Daten in Datenbank eintragen
					}
					public void onCancelled() {
						frame.setEnabled(true);
					}
				};
				
				AddWindow wnd = new AddWindow(listener);
				frame.setEnabled(false);
				wnd.setVisible(true);
			}
		});
        
        
        settings = new JButton("Einstellungen");
        
        tab1 = Startansicht.getPanel();
        tab1.setBackground(new Color(1,68,131));
<<<<<<< HEAD
        tabs.addTab("Startansicht", tab1);
=======
        tabs.addTab("Übersicht", tab1);
        
>>>>>>> branch 'master' of https://github.com/debrt/sdbkls
        tab2 = Suchkonfiguration.getPanel();
        tab2.setBackground(new Color(1,68,131));
        tabs.addTab("Suchkonfiguration", tab2);
        
        frame.add(tabs);
        frame.setVisible(true);
        frame.setSize(400, 400);
    }
}
