import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        long start = System.currentTimeMillis();

        if (key == 37 && !Field.getMouse().isBlocked(Direction.LEFT)) {
            Field.getMouse().setLocation(Field.getMouse().getX() - Config.STEP, Field.getMouse().getY());
        }
        if (key == 38 && !Field.getMouse().isBlocked(Direction.UP)) {
            Field.getMouse().setLocation(Field.getMouse().getX(), Field.getMouse().getY() - Config.STEP);
        }
        if (key == 39 && !Field.getMouse().isBlocked(Direction.RIGHT)) {
            Field.getMouse().setLocation(Field.getMouse().getX() + Config.STEP, Field.getMouse().getY());
        }
        if (key == 40 && !Field.getMouse().isBlocked(Direction.DOWN)) {
            Field.getMouse().setLocation(Field.getMouse().getX(), Field.getMouse().getY() + Config.STEP);
        }
        if (key == 27) {
            System.exit(0);
        }

        Field.getMouse().collectCheese();

        System.out.println("x = " + Field.getMouse().getX() + ", y = " + Field.getMouse().getY() + ", время хода: " + (System.currentTimeMillis() - start));
    }
}
