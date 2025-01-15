import javax.swing.*;
import java.util.Arrays;

public class Mouse extends JLabel {
    private int cheeseCollected = 0;

    public Mouse(int x, int y) {
        this.setIcon(new ImageIcon("resources/mouse.png"));
        this.setBounds(Config.STEP * x, Config.STEP * y, Config.STEP, Config.STEP);
    }

    public void moveLeft() {
        if (Field.getSpace()[(getX()/40) - 1][getY()/40] != 1) {
            setLocation(getX() - Config.STEP, getY());
        }
    }
    public void moveUp() {
        if (Field.getSpace()[getX()/40][(getY()/40) - 1] != 1) {
            setLocation(getX(), getY() - Config.STEP);
        }
    }
    public void moveRight() {
        if (Field.getSpace()[(getX()/40) + 1][getY()/40] != 1) {
            setLocation(getX() + Config.STEP, getY());
        }
    }
    public void moveDown() {
        if (Field.getSpace()[getX()/40][(getY()/40) + 1] != 1) {
            setLocation(getX(), getY() + Config.STEP);
        }
    }

    public void collectCheese() {
        for (Cheese cheese : Field.getCheeses()) {
            if (getX() == cheese.getX() && getY() == cheese.getY() && Field.getSpace()[cheese.getX()/40][cheese.getY()/40] == 4) {
                Field.container.remove(cheese);
                Field.getSpace()[cheese.getX()/40][cheese.getY()/40] = 0;
                cheeseCollected++;
                if (cheeseCollected >= 14) {
                    Field.getHole().setVisible(true);
                    Field.getHole().open();
                }
            }
        }
    }
    public void exitLevel() {
        if (Field.getSpace()[getX()/40][getY()/40] == 5 && Field.getHole().isOpen()) {
            Field.levelFinished();
        }
    }

    public int getCheeseCollected() {
        return cheeseCollected;
    }

}
