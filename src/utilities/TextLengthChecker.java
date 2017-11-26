/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javax.swing.JTextField;

/**
 *
 * @author Forntoh
 */
public class TextLengthChecker {
    private int length = 0;

    public TextLengthChecker(int length) {
        this.length = length;
    }
    
    public void checkLength(JTextField field){
        if (field.getText().length() > length - 1) {
            field.setText(field.getText().substring(0, length - 1));
        }
    }
}
