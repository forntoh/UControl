package server.sever;

import mousekeyboardcontrol.MouseKeyboardControl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JLabel;
import javax.swing.Timer;
import ucontrol.MainGUI;

public class Server {
    private String message;
    private Timer timerLB;
    
    public void connect(JLabel resetButton, JLabel connectionStatusLabel) {
        MouseKeyboardControl mouseControl = new MouseKeyboardControl();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        timerLB = new Timer(1000, new Server.LbBlink(connectionStatusLabel));

        try {
            connectionStatusLabel.setText("Waiting for connection...");
            MainGUI.clientSocket = MainGUI.serverSocket.accept();
            MainGUI.clientSocket.setSendBufferSize(32 * 1024);
            MainGUI.clientSocket.setReceiveBufferSize(32 * 1024);

            resetButton.setEnabled(true);
            resetButton.setIcon(MainGUI.btnStopIcon);
            
            connectionStatusLabel.setText((MainGUI.clientSocket.getRemoteSocketAddress()).toString().replace("/", "") + " Connected");
            timerLB.start();
            
            MainGUI.inputStream = MainGUI.clientSocket.getInputStream();
            MainGUI.outputStream = MainGUI.clientSocket.getOutputStream();
            MainGUI.objectOutputStream = new ObjectOutputStream(MainGUI.outputStream);
            MainGUI.objectInputStream = new ObjectInputStream(MainGUI.inputStream);

            MainGUI.sendMessageToClient("SCREEN_DIMENSIONS");
            MainGUI.sendMessageToClient((int) screenSize.getWidth());
            MainGUI.sendMessageToClient((int) screenSize.getHeight());

            while (true) {
                try {
                    message = (String) MainGUI.objectInputStream.readObject();
                    if (message != null) {
                        switch (message) {
                            case "MOUSE_MOVE":
                                int x = (int) MainGUI.objectInputStream.readObject();
                                int y = (int) MainGUI.objectInputStream.readObject();
                                System.out.println("Moved mouse to: " + x + "px, " + y + "px");
                                mouseControl.mouseMove(x, y);
                                break;
                            case "LEFT_MOUSE_PRESSED":
                                mouseControl.mousePress(InputEvent.BUTTON1_MASK);
                                break;
                            case "LEFT_MOUSE_RELEASED":
                                mouseControl.mouseRelease(InputEvent.BUTTON1_MASK);
                                break;
                            case "RIGHT_MOUSE_PRESSED":
                                mouseControl.mousePress(InputEvent.BUTTON3_MASK);
                                break;
                            case "RIGHT_MOUSE_RELEASED":
                                mouseControl.mouseRelease(InputEvent.BUTTON3_MASK);
                                break;
                            case "KEY_PRESSED":
                                int keyCode = (int) MainGUI.objectInputStream.readObject();
                                mouseControl.keyPress(keyCode);
                                break;
                            case "KEY_RELEASED":
                                int keyCodE = (int) MainGUI.objectInputStream.readObject();
                                mouseControl.keyRelease(keyCodE);
                                break;
                        }
                    } else {
                        //remote connection closed
                        connectionClosed();
                        timerLB.stop();
                        System.out.println("Disconnected");
                        break;
                    }
                } catch (IOException | ClassNotFoundException e) {
                    connectionClosed();
                    System.out.println("Disconnected");
                    connectionStatusLabel.setText("Disconnected");
                    timerLB.stop();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connectionClosed() {
        try {
            MainGUI.objectInputStream.close();
            MainGUI.clientSocket.close();
            MainGUI.serverSocket.close();
            MainGUI.inputStream.close();
            MainGUI.outputStream.close();
            MainGUI.objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    class LbBlink implements ActionListener {  
        private javax.swing.JLabel label;
        private java.awt.Color cor1 = java.awt.Color.red;
        private java.awt.Color cor2 = java.awt.Color.white;
        private int count;

        public LbBlink(javax.swing.JLabel label){
            this.label = label;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(count % 2 == 0)
                label.setForeground(cor1);
            else
                label.setForeground(cor2);
            count++;
        }  
    }
}
