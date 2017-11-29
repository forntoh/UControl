/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucontrol;

import Objects.Screen;
import client.connect.MakeConnection;
import client.handlers.*;
import client.interfaces.OnChangeScreenListener;
import client.interfaces.OnMouseMoveListener;

import java.awt.AWTException;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import static java.lang.Thread.sleep;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import ipaddress.GetFreePort;
import ipaddress.GetMyIpAddress;

import static utilities.ValidateIP.validateIP;
import static utilities.ValidateIP.validatePort;

import server.Server;
import utilities.TextLengthChecker;
import utilities.TextPrompt;

/**
 * @author Forntoh
 */
public class MainGUI extends javax.swing.JFrame {

    private static JFrame frame;

    //variable declaration
    private int port;
    public static ServerSocket serverSocket = null;
    public static Socket clientSocket = null;
    public static InputStream inputStream = null;
    public static OutputStream outputStream = null;
    public static ObjectOutputStream objectOutputStream = null;
    public static ObjectInputStream objectInputStream = null;

    /**
     * Creates new form MainGUI
     */
    public MainGUI() throws AWTException {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        char[] possibleCharacters = (new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789")).toCharArray();
        passwordLabel.setText("tom");

        robot = new Robot();
        localScreen = new Screen();
        localScreen.setScreenPosition("LEFT");

        mouseObserver = new MouseObserver(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        screenSizeLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        ipCheckIndicator = new javax.swing.JLabel();
        btn_connect = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        ipAddressField = new javax.swing.JTextField();
        btn_min = new javax.swing.JLabel();
        btn_max = new javax.swing.JLabel();
        btn_close = new javax.swing.JLabel();
        connectionStatusLabel = new javax.swing.JLabel();
        portNumberLabel = new javax.swing.JLabel();
        ipAddressLabel = new javax.swing.JLabel();
        btn_reset = new javax.swing.JLabel();
        btn_start = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(919, 594));
        setMinimumSize(new java.awt.Dimension(919, 594));
        setUndecorated(true);

        jPanel1.setBackground(new Color(0, 0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(919, 594));
        jPanel1.setMinimumSize(new java.awt.Dimension(919, 594));
        jPanel1.setPreferredSize(new java.awt.Dimension(919, 594));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        screenSizeLabel.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
        screenSizeLabel.setForeground(new java.awt.Color(255, 255, 255));
        screenSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        screenSizeLabel.setText("N/A");
        jPanel1.add(screenSizeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 140, 30));

        passwordLabel.setFont(new java.awt.Font("Montserrat Light", 0, 36)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("jLabel1");
        jPanel1.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 460, 384, 60));

        ipCheckIndicator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jPanel1.add(ipCheckIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, -1, -1));
        ipCheckIndicator.setVisible(false);

        btn_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_connect.png"))); // NOI18N
        btn_connect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_connectMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_connectMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_connectMouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_connectMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_connectMouseReleased(evt);
            }
        });
        jPanel1.add(btn_connect, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 235, -1, -1));

        portField.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
        portField.setForeground(new java.awt.Color(255, 255, 255));
        portField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        portField.setBorder(null);
        portField.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        portField.setOpaque(false);
        TextPrompt tp1 = new TextPrompt("Port", portField, new java.awt.Font("Arial", 0, 14));
        tp1.changeAlpha(0.2f);
        tp1.setForeground(new Color(140, 140, 140));
        portField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                portFieldKeyTyped(evt);
            }
        });
        jPanel1.add(portField, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 198, 115, 28));

        ipAddressField.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
        ipAddressField.setForeground(new java.awt.Color(255, 255, 255));
        ipAddressField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ipAddressField.setBorder(null);
        ipAddressField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ipAddressField.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        ipAddressField.setOpaque(false);
        TextPrompt tp = new TextPrompt("Remote PC IP Address", ipAddressField, new java.awt.Font("Arial", 0, 14));
        tp.changeAlpha(0.2f);
        tp.setForeground(new Color(140, 140, 140));
        ipAddressField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ipAddressFieldKeyPressed(evt);
            }
        });
        jPanel1.add(ipAddressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 198, 222, 28));

        btn_min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_min.png"))); // NOI18N
        btn_min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_minMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_minMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_minMouseExited(evt);
            }
        });
        jPanel1.add(btn_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 40, -1, -1));

        btn_max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_max.png"))); // NOI18N
        btn_max.setEnabled(false);
        jPanel1.add(btn_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 32, -1, -1));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_close.png"))); // NOI18N
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_closeMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_closeMouseExited(evt);
            }
        });
        jPanel1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        connectionStatusLabel.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
        connectionStatusLabel.setForeground(new java.awt.Color(255, 255, 255));
        connectionStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        connectionStatusLabel.setText("Not connected");
        jPanel1.add(connectionStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 543, 890, 40));

        portNumberLabel.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
        portNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        portNumberLabel.setText("N/A");
        jPanel1.add(portNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 227, -1, -1));

        ipAddressLabel.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
        ipAddressLabel.setForeground(new java.awt.Color(255, 255, 255));
        ipAddressLabel.setText("N/A");
        jPanel1.add(ipAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 195, -1, -1));

        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_reset.png"))); // NOI18N
        btn_reset.setIcon(btnResetIcon);
        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_resetMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_resetMouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_resetMousePressed(evt);
            }
        });
        jPanel1.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 256, -1, -1));

        btn_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_start.png"))); // NOI18N
        btn_start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_startMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_startMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_startMouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_startMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_startMouseReleased(evt);
            }
        });
        jPanel1.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 256, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main.png"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 919, 594));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseEntered
        if (btn_reset.getIcon().equals(btnResetIcon))
            btn_reset.setIcon(btnResetIconH);
        else
            btn_reset.setIcon(btnStopIconH);
    }//GEN-LAST:event_btn_resetMouseEntered

    private void btn_resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseExited
        if (btn_reset.getIcon().equals(btnResetIconH) || btn_reset.getIcon().equals(btnResetIconC))
            btn_reset.setIcon(btnResetIcon);
        else if (btn_reset.getIcon().equals(btnStopIconH))
            btn_reset.setIcon(btnStopIcon);
    }//GEN-LAST:event_btn_resetMouseExited

    private void btn_startMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_startMouseEntered
        if (btn_start.isEnabled())
            btn_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_start_hovered.png")));
    }//GEN-LAST:event_btn_startMouseEntered

    private void btn_startMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_startMouseExited
        if (btn_start.isEnabled())
            btn_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_start.png")));
    }//GEN-LAST:event_btn_startMouseExited

    private void btn_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseClicked
        if (btn_reset.getIcon().equals(btnStopIconH) || btn_reset.getIcon().equals(btnStopIconC)) {
            connectionStatusLabel.setText("Stoped");
            btn_start.setEnabled(true);
        } else {
            connectionStatusLabel.setText("Disconnected");
            portNumberLabel.setText("N/A");
            ipAddressLabel.setText("N/A");
            btn_start.setEnabled(true);
        }
        btn_reset.setIcon(btnResetIcon);
        resetButtonActionPerformed(evt);
    }//GEN-LAST:event_btn_resetMouseClicked

    private void btn_startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_startMouseClicked
        if (btn_start.isEnabled())
            setConnectionDetails();
        btn_start.setEnabled(false);
        btn_reset.setEnabled(true);
    }//GEN-LAST:event_btn_startMouseClicked

    private void btn_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseEntered
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_close_hovered.png")));
    }//GEN-LAST:event_btn_closeMouseEntered

    private void btn_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseExited
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_close.png")));
    }//GEN-LAST:event_btn_closeMouseExited

    private void btn_minMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minMouseEntered
        btn_min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_min_hovered.png")));
    }//GEN-LAST:event_btn_minMouseEntered

    private void btn_minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minMouseExited
        btn_min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_min.png")));
    }//GEN-LAST:event_btn_minMouseExited

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_closeMouseClicked

    private void btn_minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btn_minMouseClicked

    private void btn_startMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_startMousePressed
        if (btn_start.isEnabled())
            btn_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_start_clicked.png")));
    }//GEN-LAST:event_btn_startMousePressed

    private void btn_startMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_startMouseReleased
        if (btn_start.isEnabled())
            btn_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_start.png")));
    }//GEN-LAST:event_btn_startMouseReleased

    private void btn_resetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMousePressed
        if (btn_reset.isEnabled())
            if (btn_reset.getIcon().equals(btnStopIconH))
                btn_reset.setIcon(btnStopIconC);
            else
                btn_reset.setIcon(btnResetIconC);

    }//GEN-LAST:event_btn_resetMousePressed

    private void resetButtonActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        try {
            if (serverSocket != null) serverSocket.close();
            if (clientSocket != null) clientSocket.close();
            if (inputStream != null) inputStream.close();
            if (outputStream != null) outputStream.close();
            if (objectOutputStream != null) objectOutputStream.close();
            if (objectInputStream != null) objectInputStream.close();
        } catch (Exception ignored) {}
    }//GEN-LAST:event_resetButtonActionPerformed

    private void btn_connectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_connectMouseEntered
        btn_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_connect_hovered.png")));
    }//GEN-LAST:event_btn_connectMouseEntered

    private void btn_connectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_connectMouseExited
        btn_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_connect.png")));
    }//GEN-LAST:event_btn_connectMouseExited

    private void btn_connectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_connectMousePressed
        btn_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_connect_clicked.png")));
    }//GEN-LAST:event_btn_connectMousePressed

    private void btn_connectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_connectMouseReleased
        btn_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_connect.png")));
    }//GEN-LAST:event_btn_connectMouseReleased

    private void portFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_portFieldKeyTyped
        portLengthChecker.checkLength(portField);
    }//GEN-LAST:event_portFieldKeyTyped

    private void ipAddressFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ipAddressFieldKeyPressed
        ipLengthChecker.checkLength(ipAddressField);
    }//GEN-LAST:event_ipAddressFieldKeyPressed

    private void btn_connectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_connectMouseClicked
        String preStatus = connectionStatusLabel.getText();
        if (!validateIP(ipAddressField.getText()) || !validatePort(portField.getText()))
            delayChangeStatus("Invalid IP Address or port!!!", preStatus);
        else {
            MakeConnection makeConnection = new MakeConnection(ipAddressField.getText(), portField.getText());
            clientSocket = makeConnection.doInBackground();
            delayChangeStatus("Server is not listening", preStatus);
            // }
            connectionStatusLabel.setText("Connected");
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("Communicating");
                        Object object = objectInputStream.readObject();
                        System.out.println(object.toString());
                        String message = (String) object;
                        if (message != null) {
                            switch (message) {
                                case "SCREEN_DIMENSIONS":
                                    int width = (int) objectInputStream.readObject();
                                    int height = (int) objectInputStream.readObject();
                                    remoteScreen = new Screen(width, height);
                                    remoteScreen.setScreenPosition("RIGHT");
                                    screenSizeLabel.setText(width + " x " + height + "px");
                                    break;
                            }
                        } else {
                            screenSizeLabel.setText("N/A");
                            System.out.println("Disconnected");
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Disconnected!");
                        break;
                    }
                }
            }).start();

            initializeOverlayFrame();
            Timer timer1 = new Timer(0, e -> {
                remoteMotionListener = new RemoteMouseMotionListener(localScreen, remoteScreen);
                remoteMotionListener.setOnMouseMoveListener(onMouseMoveListener);
                localMotionListener = new LocalMouseMotionListener(localScreen, remoteScreen);
                localMotionListener.setOnChangeScreenListener(changeScreenListener);
                mouseObserver.addMouseMotionListener(localMotionListener);
                mouseObserver.start();
            });
            timer1.setInitialDelay(1000);
            timer1.setRepeats(false);
            timer1.start();
        }
    }//GEN-LAST:event_btn_connectMouseClicked

    private void delayChangeStatus(String message, String original) {
        connectionStatusLabel.setText(message);
        connectionStatusLabel.setForeground(Color.RED);
        Timer timer = new Timer(0, e -> {
            connectionStatusLabel.setText(original);
            connectionStatusLabel.setForeground(Color.WHITE);
        });
        timer.setInitialDelay(3000);
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainGUI().setVisible(true);
            } catch (AWTException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void showDialogMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void setConnectionDetails() {
        String ipAddresses[] = new GetMyIpAddress().ipAddress();
        String connectionStatus = "Not Connected";
        port = new GetFreePort().getFreePort();
        String ipAddress = ipAddresses[0];
        if (ipAddresses[1] != null) {
            ipAddress = ipAddress + " | " + ipAddresses[1];
        }
        ipAddressLabel.setText(ipAddress);
        portNumberLabel.setText(Integer.toString(port));
        connectionStatusLabel.setText(connectionStatus);
        if (ipAddresses[0].equals("127.0.0.1")) {
            showDialogMessage("Connect your PC to Android phone hotspot or connect both devices to a local network.");
        } else {
            try {
                serverSocket = new ServerSocket(port);
                startServer();
            } catch (Exception e) {
                showDialogMessage("Error in initializing server");
                e.printStackTrace();
            }
        }
    }

    private void startServer() {
        new Thread(() -> new Server().connect(btn_reset, connectionStatusLabel)).start();
    }

    //this method is called from fragments to send message to client (Local)
    public static void sendMessageToClient(Object message) {
        if (clientSocket != null) {
            try {
                objectOutputStream.writeObject(message);
                objectOutputStream.flush();
            } catch (IOException e) {
                socketException();
                e.printStackTrace();
            }
        }
    }

    //this method is called to send message to server (Desktop)
    public static void sendMessageToServer(Object message) {
        if (clientSocket != null) {
            try {
                objectOutputStream.writeObject(message);
                objectOutputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
                socketException();
            }
        }
    }

    //Used to close socket connections
    private static void socketException() {
        System.out.println("Connection Closed");
        try {
            clientSocket.close();
            objectOutputStream.close();
            clientSocket = null;
        } catch (Exception ignored) {
        }
    }

    //Called after RemoteScreen is selected and mouse is moved on RemoteScreen
    private final OnMouseMoveListener onMouseMoveListener = new OnMouseMoveListener() {
        @Override
        public void onMove(int x, int y) {
            sendMessageToServer("MOUSE_MOVE");
            sendMessageToServer(x);
            sendMessageToServer(y);

            if (localScreen.getScreenPosition().equals("LEFT") && x < 2) {
                startLocalMouseTracker(true);
                robot.mouseMove(localScreen.screenWidth - SHIFT_DIST, y);
            } else if (localScreen.getScreenPosition().equals("RIGHT") && x > remoteScreen.screenWidth - 2) {
                startLocalMouseTracker(true);
                robot.mouseMove(SHIFT_DIST, y);
            }
        }
    };

    //Called when RemoteScreen is about to be selected
    private OnChangeScreenListener changeScreenListener = new OnChangeScreenListener() {
        @Override
        public void changeScreens(int y) {
            if (remoteScreen.getScreenPosition().equals("RIGHT"))
                robot.mouseMove(SHIFT_DIST, y);
            else
                robot.mouseMove(remoteScreen.screenWidth - SHIFT_DIST, y);
            startLocalMouseTracker(false);
        }
    };

    // Remove RemoteMotionListener and add LocalMotionListener or vice versa
    private void startLocalMouseTracker(boolean toStart) {
        startOverlayFrame(toStart);
        remoteScreen.setSelected(!toStart);
        if (toStart) {
            frame.removeMouseMotionListener(remoteMotionListener);
            mouseObserver.addMouseMotionListener(localMotionListener);
            mouseObserver.start();
            System.out.println("LocalScreen selected");
        } else {
            frame.addMouseMotionListener(remoteMotionListener);
            mouseObserver.removeMouseMotionListener(localMotionListener);
            mouseObserver.stop();
            System.out.println("RemoteScreen selected");
        }
    }

    //Display Overlay frame to prevent clicks on local PC
    private void startOverlayFrame(boolean toStart) {
        frame.setVisible(!toStart);
        if (toStart) {
            frame.removeMouseListener(mouseEventHandler);
            frame.removeKeyListener(keyboardEventHandler);
        } else {
            frame.addMouseListener(mouseEventHandler);
            frame.addKeyListener(keyboardEventHandler);
        }
    }

    //Initialize local PC Overlay frame
    private void initializeOverlayFrame() {
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        // Transparent 16 x 16 pixel cursor image.
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(2, 2), "blank cursor");

        // Set the blank cursor to the JFrame.
        frame.getContentPane().setCursor(blankCursor);
        frame.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.4f));

        JLabel jLabel1 = new JLabel("Controlling: " + ipAddressField.getText(), SwingConstants.CENTER);
        jLabel1.setFont(new java.awt.Font("Montserrat Light", 0, 62));
        jLabel1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.3f));
        jLabel1.setForeground(new Color(1f, 1f, 1f, 1f));
        frame.setResizable(false);
        frame.add(jLabel1);
    }

    private static final int SHIFT_DIST = 5;
    private static Screen remoteScreen;
    private static Screen localScreen;
    private static Robot robot;
    private MouseObserver mouseObserver;

    private MouseEventHandler mouseEventHandler = new MouseEventHandler();
    private KeyboardEventHandler keyboardEventHandler = new KeyboardEventHandler();
    private RemoteMouseMotionListener remoteMotionListener;
    private LocalMouseMotionListener localMotionListener;
    private TextLengthChecker portLengthChecker = new TextLengthChecker(4);
    private TextLengthChecker ipLengthChecker = new TextLengthChecker(15);
    private ImageIcon btnResetIconC = new javax.swing.ImageIcon(getClass().getResource("/btn_reset_clicked.png"));
    private ImageIcon btnStopIconC = new javax.swing.ImageIcon(getClass().getResource("/btn_stop_clicked.png"));
    private ImageIcon btnResetIcon = new ImageIcon(this.getClass().getResource("/btn_reset.png"));
    private ImageIcon btnResetIconH = new ImageIcon(this.getClass().getResource("/btn_reset_hovered.png"));
    private ImageIcon btnStopIconH = new ImageIcon(this.getClass().getResource("/btn_stop_hovered.png"));
    public static ImageIcon btnStopIcon = new ImageIcon(MainGUI.class.getResource("/btn_stop.png"));

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel btn_close;
    private javax.swing.JLabel btn_connect;
    private javax.swing.JLabel btn_max;
    private javax.swing.JLabel btn_min;
    private javax.swing.JLabel btn_reset;
    private javax.swing.JLabel btn_start;
    private javax.swing.JLabel connectionStatusLabel;
    private javax.swing.JTextField ipAddressField;
    private javax.swing.JLabel ipAddressLabel;
    private javax.swing.JLabel ipCheckIndicator;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portNumberLabel;
    private javax.swing.JLabel screenSizeLabel;
    // End of variables declaration//GEN-END:variables
}
