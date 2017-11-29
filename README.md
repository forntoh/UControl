# UControl
<p>Have you often found yourself trying to control two computers at once, and getting confused like which keyboard and which mouse goes with which? <b>WTF!</b></p>
<p>UniC is here to solve the problem, you no longer need two keyboards or mice, with UniC, you can share your mouse and keyboard with all your PCs without getting confused, it even saves you money from buying mice and keyboards.</p>
<p>Right now most of the features are not yet available, but they will be available soon.<p>

This version is based on **`Java Swing`**

## Getting Started
The project is organized as follows
- `client`
  - `connect`
    - `MakeConnection.java` - Connect to server
  - `handlers` - Contains handlers for all events
  - `interfaces`
    - `OnChangeScreenListener.java` - Called when screen is switched
    - `OnMouseMoveListener` - Called when mouse is moved
- `ipaddress`
  - `GetFreePort.java` - Get port from open ports
  - `GetMyIpAddress.java` - Get IP addresses of the PC
- `mousekeyboardcontrol`
  - `MouseKeyboardControl.java` - Robot that executes events on Mouse and Keyboard
- `Objects`
  - `Screen.java` - Signifies a monitor screen
- `server`
  - `Server.java` - The Server
- `ucontrol`
  - `Main.java` - Execution Class
  - `MainGUI.java` - Main Graphical User Interface
- `utilities`
  - `TextLengthChecker.java` - Check the length of text in a jTextField
  - `TextPrompt.java` - display prompt over text component when the text field is empty
  - `ValidateIP.java` - Validate IP address and port

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

## Built with
- Java Swing

## Authors
- **Forntoh Thomas**

## License
You are free to use any code here for personal or commercial needs

## Acknowledgments
- [Synergy](https://symless.com/synergy) - Where I got my inspiration from
- **varun** - Author of class `GetMyIpAddress.java`