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

    public MainWindow(){
    	frame = new JFrame("SDBKLS");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        
        tabs = new JTabbedPane();
        
        tab1 = Startansicht.getPanel();
        tabs.addTab("Übersicht", tab1);
        
        tab2 = Suchkonfiguration.getPanel();
        tab2.setBackground(new Color(1,68,131));
        tabs.addTab("Suchkonfiguration", tab2);
        
        frame.add(tabs);
        frame.setVisible(true);
    }
}
