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
        frame = new JFrame("KLS Schuldatenbank");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tabs = new JTabbedPane();
        
        search = new JButton("Suchen");
        add = new JButton("Hinzufügen");
        
        
        settings = new JButton("Einstellungen");
        
        tab1 = Startansicht.getPanel(frame);
        tab1.setBackground(new Color(1,68,131));
        tabs.addTab("Startansicht", tab1);
        tab2 = Suchkonfiguration.getPanel();
        tab2.setBackground(new Color(1,68,131));
        tabs.addTab("Suchkonfiguration", tab2);
        
        frame.add(tabs);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
