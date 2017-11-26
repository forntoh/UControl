package client.handlers;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucontrol.MainGUI;

public class MouseEventHandler implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
            MainGUI.sendMessageToServer("LEFT_MOUSE_PRESSED");
        } else if (SwingUtilities.isRightMouseButton(e)){
            MainGUI.sendMessageToServer("RIGHT_MOUSE_PRESSED");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
            MainGUI.sendMessageToServer("LEFT_MOUSE_RELEASED");
        } else if (SwingUtilities.isRightMouseButton(e)){
            MainGUI.sendMessageToServer("RIGHT_MOUSE_RELEASED");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
