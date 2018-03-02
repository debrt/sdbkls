//TEST, UM ZU SCHAUEN, OB VINCENT PUSHEN KANN

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


 
public class MainWindow
{
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
    
    JTextField suche;
    
	public static void main(String[] args){
		MainWindow mainWindow = new MainWindow();
	}
	

    public MainWindow()
    {
    	DefaultTableModel model = new DefaultTableModel(new String[] {"Test1", "Test2"}, 0 );
    	table = new JTable(model);
        frame = new JFrame("SchülerDatenbank");
        tabs = new JTabbedPane();
        tab1 = new JPanel();
        tab2 = new JPanel();
        tab1N = new JPanel();
        tab1S = new JPanel();
        tab1W = new JPanel();
        tab1E = new JPanel();
        tab1C = new JPanel();
        
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); frame.pack(); frame.setVisible( true );
        
        suche = new JTextField("Suchbegriff...");
        suche.setSize(600,300);

        frame.setSize(600, 800);
        frame.setVisible(true);

        tabs.addTab("�bersicht", tab1);
        tabs.addTab("Suchkonfiguration", tab2);
        frame.add(tabs);
        tab1.setLayout(new BorderLayout());
        tab1.add(tab1N, BorderLayout.NORTH);
        tab1.add(tab1S, BorderLayout.SOUTH);
        tab1.add(tab1W, BorderLayout.WEST);
        tab1.add(tab1E, BorderLayout.EAST);
        tab1.add(tab1C, BorderLayout.CENTER);
        
        tab1N.add(suche);
        //tab1C.add(new JTextField("test"));
        tab1C.setLayout(new BorderLayout());
        tab1C.add(new JScrollPane(table), BorderLayout.CENTER);
        
        

        
    }
}
