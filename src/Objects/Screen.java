package Objects;

import java.awt.*;

public class Screen {
    public int screenWidth, screenHeight;
    private String screenPosition = "LEFT";
    private boolean isActivated;

    public Screen() {
        this(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    }

    public Screen(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public void setScreenPosition(String pos) {
        this.screenPosition = pos;
    }

    public String getScreenPosition() {
        return screenPosition;
    }

    public boolean isSelected() {
        return isActivated;
    }

    public void setSelected(boolean activated) {
        isActivated = activated;
    }

}
