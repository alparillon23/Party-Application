package ui.message_windows;

import ui.Window;
import ui.menu_windows.MainMenuWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginSuccessWindow extends Window {



    public LoginSuccessWindow(String name)
    {
        super("Login Successful",new ImageIcon(new ImageIcon("src/ui/success.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)),name);

    }
    @Override
    public void setPanel() {

        panel.setLayout(new FlowLayout());
        ArrayList<JPanel> messageArea = new ArrayList<>();
        JPanel centre = new JPanel(new GridLayout(2,1));
        //messageArea.setLayout(new GridLayout(2,1));

        JLabel message = new JLabel("Welcome to PARTY, "+perInfo+"! Enjoy the party and connect with new and old friends!");
        JButton bt = new JButton("Continue");

        for(int i=0; i<2; i++)
        {
            messageArea.add(new JPanel());
            messageArea.get(i).setSize(20,10);
        }

        messageArea.get(0).add(message);
        messageArea.get(1).add(bt);



        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginSuccessWindow.super.closeWindow();
                start.setVisible(false);
                new MainMenuWindow(perInfo);
            }
        });

        for(JPanel p: messageArea)
        {
            centre.add(p);
        }
        panel.add(centre);
    }
}
