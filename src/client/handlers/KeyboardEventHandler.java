package client.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ucontrol.MainGUI;

/**
 * Created by Forntoh on 26-Jun-17.
 */
public class KeyboardEventHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        MainGUI.sendMessageToServer("KEY_PRESSED");
        MainGUI.sendMessageToServer(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        MainGUI.sendMessageToServer("KEY_RELEASED");
        MainGUI.sendMessageToServer(e.getKeyCode());
    }
}
