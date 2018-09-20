package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    //Creates the application window. I initialized the window within the constructor since the app isn't advanced yet.
    public Window()
    {
        JFrame start = new JFrame("Party Application");
        start.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon startImage = new ImageIcon("src/ui/party.jpeg");

        start.setSize(startImage.getIconWidth(),startImage.getIconHeight());


        /*if (!(new File("").exists()))
        {
            System.out.println("issa dud");
        }
        */
        JPanel startPane = new JPanel();

        LayoutManager overlay = new OverlayLayout(startPane);
        startPane.setLayout(overlay);

        JPanel textPane = new JPanel();
        LayoutManager box = new BoxLayout(textPane,BoxLayout.Y_AXIS);
        textPane.setLayout(box);


        JLabel greeting = new JLabel("<html> <font color='purple' size = 50>WELCOME TO <i>PARTY</i></font><br>" +
                "<font color='purple' size = 5>Name:</font></html>");
        JTextField name = new JTextField(20);
        name.setMaximumSize(new Dimension((startImage.getIconWidth()),(startImage.getIconHeight()/20)));
        JTextField salut = new JTextField(40);
        salut.setMaximumSize(new Dimension((startImage.getIconWidth()),(startImage.getIconHeight()/10)));
        JButton bt = new JButton("SUBMIT");

        //Effect: Reads data from the field name and provides it in a message
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nam = name.getText();
                salut.setText("Message From Owner: Hi "+ nam +", thanks for downloading the app. More cool stuff coming soon!");
            }
        });

        textPane.add(greeting);
        textPane.add(name);
        textPane.add(bt);
        textPane.add(salut);
        JLabel bg = new JLabel(startImage);


        start.add(startPane,BorderLayout.CENTER);

        //add works in a particular order for JFrame Panels
        startPane.add(textPane);
        startPane.add(bg);
        start.pack();
        start.setVisible(true);



    }

    private void setImages()
    {

    }

    private void setSounds()
    {

    }

    private void setMenus()
    {

    }


}
