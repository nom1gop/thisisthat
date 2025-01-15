import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class Cossack extends JLabel {
    private boolean isChasingMouse;
    private boolean isWandering;
    private Direction direction;

    public Cossack(int x, int y) {
        this.setIcon(new ImageIcon("resources/cossack2.png"));
        this.setBounds(Config.STEP * x, Config.STEP * y, Config.STEP, Config.STEP);
        this.isChasingMouse = true;
        this.isWandering = false;
        this.direction = Direction.RIGHT;
    }

    public void wander() {
        switch (getDirection()) {
            case RIGHT: moveRight();
                        if (Field.getSpace()[(getX() / 40) + 1][getY() / 40] == 1) {
                            setDirection(Direction.DOWN);
                        }
                        break;
            case DOWN:  moveDown();
                        if (Field.getSpace()[getX() / 40][(getY() / 40) + 1] == 1) {
                            setDirection(Direction.LEFT);
                        }
                        break;
            case LEFT:  moveLeft();
                        if (Field.getSpace()[(getX() / 40) - 1][getY() / 40] == 1) {
                            setDirection(Direction.UP);
                        }
                        break;
            case UP:    moveUp();
                        if (Field.getSpace()[getX() / 40][(getY() / 40) - 1] == 1) {
                            setDirection(Direction.RIGHT);
                        }
                        break;
        }

        if (mouseInSight()) {
            setChaseMouse();
        }
    }

    public boolean mouseInSight() {
        if (getX() == Field.getMouse().getX() && getY() < Field.getMouse().getY()) {
            for (int i = getY()/40 + 1; i < (Field.getMouse().getY()/40); i++) {
                if (Field.getSpace()[getX() / 40][i] == 1) return false;
            }
            return true;
        } else if (getX() == Field.getMouse().getX() && getY() > Field.getMouse().getY()) {
            for (int i = getY()/40 - 1; i > (Field.getMouse().getY()/40); i--) {
                if (Field.getSpace()[getX() / 40][i] == 1) return false;
            }
            return true;
        } else if (getY() == Field.getMouse().getY() && getX() < Field.getMouse().getX()) {
            for (int i = getX()/40 + 1; i < (Field.getMouse().getX()/40); i++) {
                if (Field.getSpace()[i][getY() / 40] == 1) return false;
            }
            return true;
        } else if (getY() == Field.getMouse().getY() && getX() > Field.getMouse().getX()) {
            for (int i = getX()/40 - 1; i > (Field.getMouse().getX()/40); i--) {
                if (Field.getSpace()[i][getY() / 40] == 1) return false;
            }
            return true;
        }
        return false;
    }

    public void moveLeft() {
        if (Field.getSpace()[(getX() / 40) - 1][getY() / 40] != 1) {
            setLocation(getX() - Config.STEP, getY());
        }
    }
    public void moveUp() {
        if (Field.getSpace()[getX() / 40][(getY() / 40) - 1] != 1) {
            setLocation(getX(), getY() - Config.STEP);
        }
    }
    public void moveRight() {
        if (Field.getSpace()[(getX() / 40) + 1][getY() / 40] != 1) {
            setLocation(getX() + Config.STEP, getY());
        }
    }
    public void moveDown() {
        if (Field.getSpace()[getX() / 40][(getY() / 40) + 1] != 1) {
            setLocation(getX(), getY() + Config.STEP);
        }
    }

    public void chaseMouse() {

        int currentX = getX();
        int currentY = getY();

        for (Point point : findPossibleMoves()) {
            if ((Math.abs((int) point.getX() - getX()/40) == 1 && Math.abs((int) point.getY() - getY()/40) == 0) ||
                    (Math.abs((int) point.getY() - getY()/40) == 1 && Math.abs((int) point.getX() - getX()/40) == 0)) {
                setLocation((int) point.getX() * 40,(int) point.getY() * 40);
                break;
            }
        }

        if (getX() == currentX && getY() == currentY) {
            setWander();
        }
    }

    private ArrayList<Point> findPossibleMoves() {
        ArrayList<Point> possibleMoves = new ArrayList<>();

        int startX;
        int startY;
        int finishX;
        int finishY;

        if (Field.getMouse().getX() >= getX()) {
            startX = getX()/40;
            finishX = Field.getMouse().getX()/40;
        } else {
            startX = Field.getMouse().getX()/40;
            finishX = getX()/40;
        }
        if (Field.getMouse().getY() >= getY()) {
            startY = getY()/40;
            finishY = Field.getMouse().getY()/40;
        } else {
            startY = Field.getMouse().getY()/40;
            finishY = getY()/40;
        }

        for (int x = startX; x <= finishX; x++) {
            for (int y = startY; y <= finishY; y++) {
                if (Field.getSpace()[x][y] != 1) {
                    possibleMoves.add(new Point(x,y));
                }
            }
        }

        return possibleMoves;
    }

    public boolean isChasingMouse() {
        return isChasingMouse;
    }
    public void setChaseMouse() {
        this.isChasingMouse = true;
        this.isWandering = false;
    }
    public void setWander() {
        this.isWandering = true;
        this.isChasingMouse = false;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public Direction getDirection() {
        return direction;
    }
}
