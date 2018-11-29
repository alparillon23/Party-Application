package ui.message_windows;

import info.User;
import ui.Window;
import ui.menu_windows.EditPartyWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveSuccessWindow extends Window {

    public RemoveSuccessWindow(User user)
    {
        super("Edit Event Successful",new ImageIcon(new ImageIcon("src/ui/success.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)),user);
    }
    @Override
    public void setPanel() {

        panel.setLayout(new FlowLayout());
        ArrayList<JPanel> messageArea = new ArrayList<>();
        JPanel centre = new JPanel(new GridLayout(2,1));
        //messageArea.setLayout(new GridLayout(2,1));

        JLabel message = new JLabel("You Have Successfully Removed Your Event");
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

                RemoveSuccessWindow.super.closeWindow();
                start.setVisible(false);
                User m_current_session = current_session;
                new EditPartyWindow(m_current_session);
            }
        });

        for(JPanel p: messageArea)
        {
            centre.add(p);
        }
        panel.add(centre);
    }
}
