package client.handlers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

public class MouseObserver {
    /* the resolution of the mouse motion */
    private static final int DELAY = 1;

    private Component component;
    private Timer timer;
    private final Set<MouseMotionListener> mouseMotionListeners;

    public MouseObserver(Component component) {
        if (component == null) {
            throw new IllegalArgumentException("Null component not allowed.");
        }

        this.component = component;

        /* poll mouse coordinates at the given rate */
        timer = new Timer(DELAY, new ActionListener() {
            private Point lastPoint = MouseInfo.getPointerInfo().getLocation();

            /* called every DELAY milliseconds to fetch the
             * current mouse coordinates */
            public synchronized void actionPerformed(ActionEvent e) {
                Point point = MouseInfo.getPointerInfo().getLocation();

                if (!point.equals(lastPoint)) {
                    fireMouseMotionEvent(point);
                }
                lastPoint = point;
            }
        });
        mouseMotionListeners = new HashSet<>();
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void addMouseMotionListener(MouseMotionListener listener) {
        synchronized (mouseMotionListeners) {
            mouseMotionListeners.add(listener);
        }
    }

    public void removeMouseMotionListener(MouseMotionListener listener) {
        synchronized (mouseMotionListeners) {
            mouseMotionListeners.remove(listener);
        }
    }

    private void fireMouseMotionEvent(Point point) {
        synchronized (mouseMotionListeners) {
            mouseMotionListeners.forEach((listener) -> {
                final MouseEvent event =
                        new MouseEvent(component, MouseEvent.MOUSE_MOVED, System.currentTimeMillis(),
                                0, point.x, point.y, 0, false);

                SwingUtilities.invokeLater(() -> listener.mouseMoved(event));
            });
        }
    }
}