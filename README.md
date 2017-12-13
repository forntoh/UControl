# UControl
<p>Have you often found yourself trying to control two computers at once, and getting confused like which keyboard and which mouse goes with which? <b>WTF!</b></p>
<p>UniC is here to solve the problem, you no longer need two keyboards or mice, with UniC, you can share your mouse and keyboard with all your PCs without getting confused, it even saves you money from buying mice and keyboards.</p>
<p>Right now most of the features are not yet available, but they will be available soon.<p>

This version is based on **`Java Swing`**

## Getting Started
The project is organized as follows :
- `client`
  - `connect`
    - `MakeConnection.java` - Connect to server using a Socket with IP Address and Port.
  - `handlers` - Contains handlers for all events.
      - `KeyboardEventHandler.java` - Manages key events such as key press and key release.
      - `MouseEventHandler.java` - Manages mouse events such as mouse movements and mouse clicks.
      - `MouseObserver.java` - Observes the mouse movements and determines if screens should change.
      - `LocalMouseMotionListener.java` - Listens for mouse events on the local screen (client screen).
      - `RemoteMouseMotionListener.java` - Listens for mouse events on the remote screen (remote screen).
  - `interfaces`
    - `OnChangeScreenListener.java` - Called when screen is switched.
    - `OnMouseMoveListener` - Called when mouse is moved.
- `ipaddress`
  - `GetFreePort.java` - Get port from open ports (It first checks if chosen port is available chose a new port if false).
  - `GetMyIpAddress.java` - Get IP addresses of all interfaces of the PC running the server.
- `mousekeyboardcontrol`
  - `MouseKeyboardControl.java` - Robot that executes events on Mouse and Keyboard (It does mouse clicks and key presses).
- `Objects`
  - `Screen.java` - Signifies a monitor screen.
- `server`
  - `Server.java` - The Server.
- `ucontrol`
  - `Main.java` - Execution Class: Runs the main interface.
  - `MainGUI.java` - Main Graphical User Interface (GUI).
- `utilities`
  - `TextLengthChecker.java` - Contains a method that checks the length of text in a given jTextField
  - `TextPrompt.java` - Extends the functionality of a JLabel.
  - `ValidateIP.java` - Validate a given IP address and port.
  
  The project is "well" commented
  Knowing the use of each package and class in the project, you can easily implement your your own UControl app

### Prerequisites
For this project to work on your PC, you will need the following
```
Java Development Kit
NetBeans IDE
```
### Installing
1. Install **jdk** and configure **PATH** variable
2. Install NetBeans IDE
3. Clone or download this repository
4. Open the downloaded project with NetBeans
5. And you're done

## Testing
There are two possible ways to test the App: 
- Rename the file `UControl-setup` to `UControl-setup.exe` and install it on both the client and server machine.
- Build the mirrored repository using NetBeans IDE on both machines.

## Built with
- Java Swing

## Authors
- **Forntoh Thomas**

## License
You are free to use any code here for personal or commercial needs

## Acknowledgments
- [Synergy](https://symless.com/synergy) - Where I got my inspiration from
- **varun** - Author of class `GetMyIpAddress.java`