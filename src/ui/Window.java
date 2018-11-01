package ui;

import info.User;

import javax.swing.*;
import java.awt.*;



public abstract class Window extends JFrame {



    protected JFrame start;
    protected JPanel panel;
    protected User current_session;
    protected String perInfo;


    //Creates the application window. I initialized the window within the constructor since the app isn't advanced yet.
    public Window(String winTitle, ImageIcon windowIcon, User user)
    {

        //Fields in the Window are
        start = new JFrame("Party Application");
        start.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon startImage = new ImageIcon("src/ui/party.jpeg");
        //ImageIcon icon = new ImageIcon ("src/ui/partyicon.png");
        //String message = "";
        current_session = user;
        perInfo = user.getUser_Name();
        start.setSize(startImage.getIconWidth(),startImage.getIconHeight());
        JPanel startPane = new JPanel();
        LayoutManager overlay = new OverlayLayout(startPane);
        startPane.setLayout(overlay);
        JLabel bg = new JLabel(startImage);
        start.add(startPane,BorderLayout.CENTER);
        startPane.add(bg);
        start.pack();
        start.setVisible(true);
        panel = new JPanel();
        setPanel();
        JOptionPane.showOptionDialog(panel,panel,winTitle,JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,windowIcon,new Object[]{},null);
    }

    public abstract void setPanel();

    public void closeWindow()
    {
        JOptionPane.getRootFrame().dispose();
    }




}
