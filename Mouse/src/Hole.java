import javax.swing.*;

public class Hole extends JLabel {
    private boolean isOpen;
    public Hole(int x, int y) {
        this.setIcon(new ImageIcon("resources/hole.png"));
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        this.setBounds(Config.STEP * x, Config.STEP * y, Config.STEP, Config.STEP);
        this.setVisible(false);
        this.isOpen = false;
    }

    public void open() {
        isOpen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
