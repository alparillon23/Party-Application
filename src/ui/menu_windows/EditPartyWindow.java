package ui.menu_windows;

import info.User;
import info.Event;
import ui.Window;
import ui.message_windows.EditSuccessWindow;
import ui.message_windows.RemoveSuccessWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditPartyWindow extends Window {

    private int value;
    public EditPartyWindow(User user)
    {
        super("Change Up The Party",new ImageIcon(),user);
    }

    @Override
    public void setPanel() {

        LayoutManager box = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(box);
        JPanel grid = new JPanel();

        grid.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        JButton prev = new JButton("<<"); JButton next = new JButton(">>");
        JLabel namelabel = new JLabel("Name of Party"); JTextField name = new JTextField(20); name.setMaximumSize(new Dimension(200,10));
        JLabel locationlabel = new JLabel("Location");  JTextField location = new JTextField(20); location.setMaximumSize(new Dimension(200,10));
        JLabel datelabel = new JLabel("Date"); JTextField date = new JTextField(20); date.setMaximumSize(new Dimension(200,10));
        JLabel timelabel = new JLabel("Time"); JTextField time = new JTextField(20); time.setMaximumSize(new Dimension(200,10));
        JButton editEvent = new JButton("Edit Party"); JButton removeEvent = new JButton("Delete Party"); JButton cancelEditEvent = new JButton("Cancel");

        ArrayList<Event> events = current_session.getOwnersList();

        if(events.size()!=0) {
            value = 0;
            //Show information
            name.setText(events.get(value).getName());
            location.setText(events.get(value).getLocation());
            date.setText(events.get(value).getDate());
            time.setText(events.get(value).getTime());
            //Show information
        }
        else
        {
            name.setText("No events available");
            location.setText("No events available");
            date.setText("No events available");
            time.setText("No events available");
        }

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.ipadx = 1;
        grid.add(prev,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 5;
        gbc.gridy = 1;
        //gbc.gridwidth = 3;
        grid.add(next,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        grid.add(namelabel,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        grid.add(name,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        grid.add(locationlabel,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 5;
        grid.add(location,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        grid.add(datelabel,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        grid.add(date,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        grid.add(timelabel,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        grid.add(time,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        grid.add(editEvent,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        grid.add(removeEvent,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 5;
        gbc.gridy = 6;
        //gbc.gridwidth = 3;
        grid.add(cancelEditEvent,gbc);

        panel.add(grid);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(events.size()!=0){
                if(value != (events.size() - 1))
                {
                    value++;
                    //Show information
                    name.setText(events.get(value).getName());
                    location.setText(events.get(value).getLocation());
                    date.setText(events.get(value).getDate());
                    time.setText(events.get(value).getTime());
                }
                else
                {
                    value = 0;
                    //Show information
                    name.setText(events.get(value).getName());
                    location.setText(events.get(value).getLocation());
                    date.setText(events.get(value).getDate());
                    time.setText(events.get(value).getTime());
                }}

            }
        });

        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(events.size()!=0){
                if(value == 0)
                {
                    value = events.size() -1;
                    //Show information
                    name.setText(events.get(value).getName());
                    location.setText(events.get(value).getLocation());
                    date.setText(events.get(value).getDate());
                    time.setText(events.get(value).getTime());
                }
                else
                {
                    value--;
                    //Show information
                    name.setText(events.get(value).getName());
                    location.setText(events.get(value).getLocation());
                    date.setText(events.get(value).getDate());
                    time.setText(events.get(value).getTime());
                }}

            }
        });

        editEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(events.size()!=0)
                {
                    Event newEvent = new Event(events.get(value).getId(),current_session.getUser_Id(),name.getText(),location.getText(),date.getText(),time.getText());
                    current_session.editEvent(newEvent);
                    events.set(value,newEvent);
                    EditPartyWindow.super.closeWindow();
                    start.setVisible(false);
                    new EditSuccessWindow(current_session);
                }

            }
        });

        removeEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(events.size()!=0) {
                    current_session.removeEvent(events.get(value));
                    //events.remove(value);
                    EditPartyWindow.super.closeWindow();
                    start.setVisible(false);
                    new RemoveSuccessWindow(current_session);
                }
            }
        });

        cancelEditEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditPartyWindow.super.closeWindow();
                start.setVisible(false);
                new MainMenuWindow(current_session);
            }
        });

        start.setVisible(true);
    }
}
