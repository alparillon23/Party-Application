package ui.menu_windows;

import info.EventMaker;
import info.User;
import info.Event;
import ui.Window;
import ui.message_windows.AddSuccessWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPartyWindow extends Window {

    public NewPartyWindow(User user)
    {
        super("Add Party",new ImageIcon(),user);
    }

    @Override
    public void setPanel() {

        GridLayout grid = new GridLayout(0,2);
        panel.setLayout(grid);
        JLabel namelabel = new JLabel("Name of Party"); JTextField name = new JTextField(25);
        JLabel locationlabel = new JLabel("Location"); JTextField location = new JTextField();
        JLabel datelabel = new JLabel("Date"); JTextField date = new JTextField();
        JLabel timelabel = new JLabel("Time"); JTextField time = new JTextField();
        JButton addEvent = new JButton("Add Party"); JButton cancelAddEvent = new JButton("Cancel");
        panel.add(namelabel); panel.add(name);
        panel.add(locationlabel); panel.add(location);
        panel.add(datelabel); panel.add(date);
        panel.add(timelabel); panel.add(time);
        panel.add(addEvent); panel.add(cancelAddEvent);

        addEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventMaker em = new EventMaker();
                Event event = new Event(0,current_session,name.getText(),location.getText(),date.getText(),time.getText());
                em.addEvent(current_session,event);
                NewPartyWindow.super.closeWindow();
                start.setVisible(false);
                new AddSuccessWindow(current_session);
            }
        });

        cancelAddEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewPartyWindow.super.closeWindow();
                start.setVisible(false);
                new MainMenuWindow(current_session);
            }
        });



    }
}
