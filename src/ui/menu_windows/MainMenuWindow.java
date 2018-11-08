package ui.menu_windows;

import info.User;
import ui.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuWindow extends Window {

    public MainMenuWindow(User user)
    {
        super("Party Main Menu",new ImageIcon(),user);
    }
    @Override
    public void setPanel() {
        ArrayList<JPanel> jps = new ArrayList<>();

        jps.add(new JPanel());
        jps.get(0).add(new JLabel("<html><font size=30 color='purple'><i>Welcome to the Party</i></font></html>"));
        jps.get(0).setSize(30,10);

        for(int i=1; i<8; i++)
        {
            jps.add(new JPanel());
            jps.get(i).setSize(30,10);
        }



        JButton bt1 = new JButton("<html><h3>Create A Party</h3></html>");
        jps.get(1).add(bt1);
        JButton bt2 = new JButton("<html><h3>Change Up the Party</h3></html>");
        jps.get(2).add(bt2);
        JButton bt3 = new JButton("<html><h3>Work on a Party List</h3></html>");
        jps.get(3).add(bt3);
        JButton bt4 = new JButton("<html><h3>Join a Party Chat</h3></html>");
        jps.get(4).add(bt4);
        JButton bt5 = new JButton("<html><h3>Find a Party</h3></html>");
        jps.get(5).add(bt5);
        JButton bt6 = new JButton("<html><h3>Shut Down Your Party</h3></html>");
        jps.get(6).add(bt6);
        JButton bt7 = new JButton("<html><h3>Sign Out of <i>Party</i></h3></html>");
        jps.get(7).add(bt7);

        JPanel mainJP = new JPanel(new GridLayout(8,1));

        for(JPanel jp: jps)
        {
            mainJP.add(jp);
        }

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenuWindow.super.closeWindow();
                start.setVisible(false);
                new NewPartyWindow(current_session);
            }
        });
        panel.add(mainJP);
    }
}
