import javax.swing.*;

public class Cheese extends JLabel {
    public Cheese(int x, int y) {
        this.setIcon(new ImageIcon("resources/cheese2.png"));
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        this.setBounds(Config.STEP * x, Config.STEP * y, Config.STEP, Config.STEP);
    }
}
