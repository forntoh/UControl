package client.handlers;

import Objects.Screen;
import client.interfaces.OnMouseMoveListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class RemoteMouseMotionListener implements MouseMotionListener {

    Screen remoteScreen;
    Screen localScreen;
    private OnMouseMoveListener onMouseMoveListener;

    public RemoteMouseMotionListener(Screen localScreen, Screen remoteScreen) {
        this.remoteScreen = remoteScreen;
        this.localScreen = localScreen;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int distX = calcPixelDistance(e.getX(), localScreen.screenWidth, remoteScreen.screenWidth);
        int distY = calcPixelDistance(e.getY(), localScreen.screenHeight, remoteScreen.screenHeight);
        onMouseMoveListener.onMove(distX, distY);
    }

    private int calcPixelDistance(double mouse, int local, int remote) {
        return (int) Math.round((mouse / local) * remote);
    }

    public void setOnMouseMoveListener(OnMouseMoveListener onMouseMoveListener) {
        this.onMouseMoveListener = onMouseMoveListener;
    }
}
