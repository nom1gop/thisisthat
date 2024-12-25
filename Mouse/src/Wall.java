import javax.swing.*;
import java.awt.*;

public class Wall extends JLabel {
    public Wall(int x, int y, int width, int height) {
        setBounds(Config.STEP * x, Config.STEP * y,Config.STEP * width,Config.STEP * height);
        setBackground(Color.DARK_GRAY);
        setOpaque(true);
    }
}
