package client.connect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import ucontrol.MainGUI;

public class MakeConnection {

    String ipAddress, port;
    Socket clientSocket;

	public MakeConnection(String ipAddress, String port) {
	    this.ipAddress = ipAddress;
	    this.port = port;
	}

	public Socket doInBackground() {
		try {
			clientSocket = new Socket();
			int portNumber = Integer.parseInt(port);
			SocketAddress socketAddress = new InetSocketAddress(ipAddress, portNumber);
			//3s timeout
			clientSocket.connect(socketAddress, 3000);
			MainGUI.objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
			MainGUI.objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
		} catch(Exception e) {
			e.printStackTrace();
			clientSocket = null;
		}
		return clientSocket;
	}
}
