package ui.menu_windows;

import exceptions.*;
import info.SignIn;
import info.SignUp;
import info.User;
import ui.Window;
import ui.message_windows.LoginSuccessWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInWindow extends Window {


    public SignInWindow()
    {

        super("Party Sign-In",new ImageIcon ("src/ui/partyicon.png"),new User(0,"",""));
    }

    public void setPanel()
    {
        //super("Party Sign-In",textPane,icon);


        LayoutManager box = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(box);
        JPanel nameAndPass = new JPanel();

        nameAndPass.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();



        JLabel greeting = new JLabel("<html> <font color='purple' size = 50>WELCOME TO <i>PARTY</i></font><br>" +
                "<font color='purple' size = 5><i>Meet Up. Chill. And Enjoy.</i></font></html>");


        JLabel labelName = new JLabel("Name");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        nameAndPass.add(labelName,c);


        JTextField name = new JTextField(20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 0;
        name.setMaximumSize(new Dimension(200,10));
        nameAndPass.add(name,c);


        JLabel labelPass = new JLabel("Password");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        nameAndPass.add(labelPass,c);

        JTextField pass = new  JPasswordField(20);
        pass.setMaximumSize(new Dimension(200,10));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 1;
        name.setMaximumSize(new Dimension(200,10));
        nameAndPass.add(pass,c);

        JButton bt = new JButton("Sign In");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 4;
        c.gridwidth = 4;
        nameAndPass.add(bt,c);

        JButton bt2 = new JButton("Sign Up");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 2;
        c.gridwidth = 7;
        nameAndPass.add(bt2,c);



        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn s = new SignIn();
                try {
                    s.signIn(name.getText(), pass.getText());
                } catch (PasswordDoesNotMatchException e1) {
                    JOptionPane.showMessageDialog(new JPanel(),"Password is incorrect for "+name.getText(),"Login Not Successful", JOptionPane.ERROR_MESSAGE);
                } catch (UserDoesNotExistException e1) {
                    JOptionPane.showMessageDialog(new JPanel(), name.getText()+" does not exist", "User does not exist",JOptionPane.WARNING_MESSAGE);
                } catch (SignInSuccessfulException e1) {
                    SignInWindow.super.closeWindow();
                    start.setVisible(false);
                    new LoginSuccessWindow(s.getCurrent_user());
                }
                finally {
                    name.setText("");
                    pass.setText("");
                }

            }
        });
        //Effect: Reads data from the field name and provides it in a message
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp s = new SignUp();
                try
                {
                s.signUp(name.getText(),pass.getText());
                } catch (SignUpSuccessfulException e1) {
                    JOptionPane.showMessageDialog(new JPanel(),"Welcome to the Party "+name.getText(), "Sign Up Successful",JOptionPane.INFORMATION_MESSAGE);
                } catch (UserAlreadyExistsException e1) {
                    JOptionPane.showMessageDialog(new JPanel(),name.getText()+" already exists. Sign In!","Sign Up Not Successful", JOptionPane.ERROR_MESSAGE);
                } catch (GenericException e1) {
                    JOptionPane.showMessageDialog(new JPanel(), "Whoops! An error occurred, try again\nERROR: "+e1.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
                finally
                {
                    name.setText("");
                    pass.setText("");
                }

            }
        });

        panel.add(greeting);
        panel.add(nameAndPass);
        start.setVisible(true);

    }


}
