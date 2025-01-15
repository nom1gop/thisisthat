import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case 37:
                Field.getMouse().moveLeft();
                break;
            case 38:
                Field.getMouse().moveUp();
                break;
            case 39:
                Field.getMouse().moveRight();
                break;
            case 40:
                Field.getMouse().moveDown();
                break;
            case 27:
                System.exit(0);
                break;
        }

        Field.getMouse().collectCheese();
        Field.getMouse().exitLevel();

    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
