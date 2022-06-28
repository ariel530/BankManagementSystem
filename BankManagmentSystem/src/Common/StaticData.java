/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Db.DatabaseQueries;
import Modal.Account;
import Modal.AccountType;
import Modal.Login;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author SSC
 */
public class StaticData {

    public static Login loginUserInfo = null;
    public static Account currentClientAccountInfo=null;

    public static enum BackGroundImages {
        LOGINBACKGROUND, SIMPLEBACKGROUND, ADMINLOGO, HOMELOGO, LOGOUTLOGO, CLIENTLOGO
    };

    public static String baseAddress = "src//Images//";
    public static String[] backGroundImagesPath = new String[]{"LoginBackground.jpg",
        "Background.jpg", "Adminicon.png", "Homelogo.jpg", "Logoutlogo1.png", "Transaction.png"};

    public static double getAndValidatePrice(String val, String errorFieldName) {
        double price = -1;
        try {
            price = Double.parseDouble(val);
            if (price <= 0) {
                JOptionPane.showConfirmDialog(null, errorFieldName + " should be greater than 0", errorFieldName + " Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                price = -1;
            }
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "Enter valid " + errorFieldName, errorFieldName + " Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        return price;
    }

    public static void resizeLabelImage(String location, JLabel imageLabel) {
        Image imgScale = new ImageIcon(location).getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imageLabel.setIcon(scaledIcon);
    }

    public static void resizeButtonImage(String location, JButton imageButton, int widht, int height) {
        Image imgScale = new ImageIcon(location).getImage().getScaledInstance(widht, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imageButton.setIcon(scaledIcon);
    }

    public static String getImage(BackGroundImages bGroundImages) {
        switch (bGroundImages) {
            case LOGINBACKGROUND:
                return baseAddress + backGroundImagesPath[0];
            case SIMPLEBACKGROUND:
                return baseAddress + backGroundImagesPath[1];
            case ADMINLOGO:
                return baseAddress + backGroundImagesPath[2];
            case HOMELOGO:
                return baseAddress + backGroundImagesPath[3];
            case LOGOUTLOGO:
                return baseAddress + backGroundImagesPath[4];
            case CLIENTLOGO:
                return baseAddress + backGroundImagesPath[5];
            default:
                return baseAddress + backGroundImagesPath[1];
        }

    }
}
