import javax.swing.*;
import java.io.File;

public class Mouse extends JLabel {
    private ImageIcon picture = new ImageIcon("resources/mouse.png");
    private int cheeseCollected = 0;

    public Mouse(int x, int y) {
        this.setIcon(picture);
        this.setBounds(Config.STEP * x, Config.STEP * y, Config.STEP, Config.STEP);
    }

//    public boolean isBlocked(Direction direction) {
//        if (direction == Direction.LEFT && this.getX() <= 0) {
//            return true;
//        } else if (direction == Direction.RIGHT && this.getX() >= Config.FIELDWIDTH - Config.MOUSESIZE) {
//            return true;
//        } else if (direction == Direction.UP && this.getY() <= 0) {
//            return true;
//        } else if (direction == Direction.DOWN && this.getY() >= Config.FIELDHEIGHT - Config.MOUSESIZE) {
//            return true;
//        }
//        return false;
//    }

    public boolean isBlocked (Direction direction) {
        for (Wall wall : Field.getWalls()) {
            if ((direction == Direction.LEFT) && (getX() <= 0
                                               || (getX() == wall.getX() + wall.getWidth() && getY() >= wall.getY() && getY() + getHeight() <= wall.getY() + wall.getHeight())
            )) {
                return true;
            } else if ((direction == Direction.RIGHT) && (getX() >= Config.FIELDWIDTH - getWidth()
                                                       || (getX() + getWidth() == wall.getX() && getY() >= wall.getY() && getY() + getHeight() <= wall.getY() + wall.getHeight())
            )) {
                return true;
            } else if ((direction == Direction.UP) && (getY() <= 0
                                                    || (getY() == wall.getY() + wall.getHeight() && getX() >= wall.getX() && getX() + getWidth() <= wall.getX() + wall.getWidth())
            )) {
                return true;
            } else if ((direction == Direction.DOWN) && (getY() >= Config.FIELDHEIGHT - getHeight()
                                                      || (getY() + getHeight() == wall.getY() && getX() >= wall.getX() && getX() + getWidth() <= wall.getX() + wall.getWidth())
            )) {
                return true;
            }
        }
        return false;
    }

    public void collectCheese() {
        for (Cheese cheese : Field.getCheeses()) {
            if (getX() == cheese.getX() && getY() == cheese.getY()) {
                Field.container.remove(cheese);
                cheeseCollected++;
                Field.getNumber().setText(String.valueOf(cheeseCollected));
            }
        }
    }

    public int getCheeseCollected() {
        return cheeseCollected;
    }
}
