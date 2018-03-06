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
    
    JButton search;
    JButton settings;
    JButton add;
    
    JLabel lb;
    
    JTextField suche;
    
	public static void main(String[] args){
	}
	

    public MainWindow()
    {
    	DefaultTableModel model = new DefaultTableModel(new String[] {"Test1", "Test2"}, 0 );
    	table = new JTable(model);
        frame = new JFrame("SDBKLS");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tabs = new JTabbedPane();
        tab1 = new JPanel();
        tab1.setBackground(new Color(1,68,131));
        tab2 = Suchkonfiguration.getPanel();
        tab2.setBackground(new Color(1,68,131));
        tab1N = new JPanel();
        tab1N.setBackground(new Color(1,68,131));
        tab1N.setLayout(new BorderLayout());
        tab1S = new JPanel();
        tab1S.setBackground(new Color(1,68,131));
        tab1W = new JPanel();
        tab1W.setBackground(new Color(1,68,131));
        tab1E = new JPanel();
        tab1E.setBackground(new Color(1,68,131));
        tab1C = new JPanel();
        tab1C.setBackground(new Color(1,68,131));
        
        search = new JButton("Suchen");
        add = new JButton("Hinzufügen");
        settings = new JButton("Einstellungen");
        
        search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		search();
        	}
        	
        });
        
        lb = new JLabel("results...");
        
        tab1W.setLayout(new BoxLayout(tab1W, BoxLayout.Y_AXIS));
        
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); frame.pack(); frame.setVisible( true );
        
        suche = new JTextField("Suchbegriff...");
        suche.setColumns(10);

        frame.setSize(600, 800);
        
        tab1W.add(add);
        tab1W.add(settings);
        tab1W.add(lb);

        tabs.addTab("Übersicht", tab1);
        tabs.addTab("Suchkonfiguration", tab2);
        frame.add(tabs);
        tab1.setLayout(new BorderLayout());
        tab1.add(tab1N, BorderLayout.NORTH);
        tab1.add(tab1S, BorderLayout.SOUTH);
        tab1.add(tab1W, BorderLayout.WEST);
        tab1.add(tab1E, BorderLayout.EAST);
        tab1.add(tab1C, BorderLayout.CENTER);
        
        
        JPanel tab1NL = new JPanel();
        tab1NL.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JPanel tab1NR = new JPanel();
        tab1NR.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        tab1N.add(tab1NL, BorderLayout.CENTER);
        tab1N.add(tab1NR);
        
        tab1NL.add(LogInWindow.klsLogoLabel);
        tab1NL.add(LogInWindow.titelLabel);
        tab1NR.add(suche);
        tab1NR.add(search);
        
        
        tab1C.setLayout(new BorderLayout());
        tab1C.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
        
        

        
    }
    
    public void search() {
    	String searchText = suche.getText();
    	ArrayList<String> results = new ArrayList<String>();
    	ArrayList<Integer> resultColumns = new ArrayList<Integer>();
    	ArrayList<Integer> resultRows = new ArrayList<Integer>();
    	
    	for(int i=0; i < table.getRowCount(); i++) 
    	{
    		for (int j=0; j < table.getColumnCount(); j++)
    		{
    			String cell = (String) table.getModel().getValueAt(i,j);
    			if (cell.contains(searchText)) {
    				results.add(cell);
    				resultColumns.add(j);
    				resultRows.add(i);
    			}
    		}
    	}
    	//test
    	
    	lb.setText(results.toString());
    	
    	
    	for (int i = 0; i < results.size(); i++) {
    		table.getModel().setValueAt("*" + results.get(i) + "*", resultRows.get(i), resultColumns.get(i));
    	}
    }
    
    
}
