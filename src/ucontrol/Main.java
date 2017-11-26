/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucontrol;

import java.awt.AWTException;
import java.awt.Color;

/**
 *
 * @author Forntoh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException {
        // TODO code application logic here
        MainGUI mainGui = new MainGUI();
        mainGui.setVisible(true);
        mainGui.setBackground(new Color(0, 0, 0, 0));
    }
    
}
