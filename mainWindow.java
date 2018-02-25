//TEST, UM ZU SCHAUEN, OB VINCENT PUSHEN KANN

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class mainWindow
{
    JFrame frame;
    JTabbedPane tabs;
    JPanel tab1;
    JPanel tab1N;
    JPanel tab1S;
    JPanel tab1W;
    JPanel tab1E;

    public GUI()
    {
        frame = new JFrame("Datenbank");
        tabs = new JTabbedPane();
        tab1 = new JPanel();
        tab1N = new JPanel();
        tab1S = new JPanel();
        tab1W = new JPanel();
        tab1E = new JPanel();

        frame.setSize(600, 800);
        frame.setVisible(true);

        tabs.addTab("Übersicht", tab1);
        frame.add(tabs);
        tab1.setLayout(new BorderLayout());
        tab1.add(tab1N, BorderLayout.NORTH);
        tab1.add(tab1S, BorderLayout.SOUTH);
        tab1.add(tab1W, BorderLayout.WEST);
        tab1.add(tab1E, BorderLayout.EAST);

        
    }
}
