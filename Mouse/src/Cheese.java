import javax.swing.*;

public class Cheese extends JLabel {
    ImageIcon picture = new ImageIcon("resources/cheese.png");

    public Cheese(int x, int y) {
        this.setIcon(picture);
        this.setBounds(Config.STEP * x, Config.STEP * y, Config.STEP, Config.STEP);
    }
}
