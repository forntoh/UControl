package client.handlers;

import Objects.Screen;
import client.iInterfaces.OnChangeScreenListener;

import java.awt.event.MouseEvent;

public class LocalMouseMotionListener extends RemoteMouseMotionListener {

    private OnChangeScreenListener onChangeScreenListener;

    public LocalMouseMotionListener(Screen localScreen, Screen remoteScreen) {
        super(localScreen, remoteScreen);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (remoteScreen.getScreenPosition().equals("LEFT") && e.getX() < 0.2)
            onChangeScreenListener.changeScreens(e.getY());
        else if (remoteScreen.getScreenPosition().equals("RIGHT") && e.getX() > localScreen.screenWidth - 2)
            onChangeScreenListener.changeScreens(e.getY());
    }

    public void setOnChangeScreenListener(OnChangeScreenListener onChangeScreenListener) {
        this.onChangeScreenListener = onChangeScreenListener;
    }
}
