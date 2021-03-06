package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Advertisments {

    public JButton microsoftAd() {
        BufferedImage ad = null;
        try {
            ad = ImageIO.read(new URL("https://src.acm.org/binaries/content/gallery/acm/ctas/microsoft.jpg/microsoft.jpg/"));
            ImageIcon advert = new ImageIcon(ad);
            Image adv = advert.getImage();
            Image adv2 = adv.getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH);
            advert = new ImageIcon(adv2);
            JButton bt = new JButton(advert);
            bt.setBorder(BorderFactory.createEmptyBorder());
            bt.setContentAreaFilled(false);
            return bt;
        } catch (IOException e) {
            return new JButton("Sponsored by Microsoft");
        }

    }

    public void goMicrosoft()
    {
        try
        {
            Desktop.getDesktop().browse(new URL("https://www.microsoft.com/en-ca").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public JButton dellAd() {
        BufferedImage ad = null;
        try {
            ad = ImageIO.read(new URL("https://www.dellemc.com/content/dam/uwaem/production-design-assets/en-apj/events/barometer/SponsoredbyDellEMC.png"));
            ImageIcon advert = new ImageIcon(ad);
            Image adv = advert.getImage();
            Image adv2 = adv.getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH);
            advert = new ImageIcon(adv2);
            JButton bt = new JButton(advert);
            bt.setBorder(BorderFactory.createEmptyBorder());
            bt.setContentAreaFilled(false);
            return bt;
        } catch (IOException e) {
            return new JButton("Sponsored by Dell");
        }

    }

    public void goDell()
    {
        try
        {
            Desktop.getDesktop().browse(new URL("https://www.dell.com/en-ca").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public JButton appleAd() {
        BufferedImage ad = null;
        try {
            ad = ImageIO.read(new URL("https://www.patentlyapple.com/.a/6a0120a5580826970c01b7c9056629970b-pi"));
            ImageIcon advert = new ImageIcon(ad);
            Image adv = advert.getImage();
            Image adv2 = adv.getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH);
            advert = new ImageIcon(adv2);
            JButton bt = new JButton(advert);
            bt.setBorder(BorderFactory.createEmptyBorder());
            bt.setContentAreaFilled(false);
            return bt;
        } catch (IOException e) {
            return new JButton("Sponsored by Apple");
        }

    }

    public void goApple()
    {
        try
        {
            Desktop.getDesktop().browse(new URL("https://www.apple.com/ca/").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }



}
