public class GameController {
    public GameController() {
        Field field = new Field();
        new GoodLuckScreen();
        KeyboardListener keyboardListener = new KeyboardListener();
        field.addKeyListener(keyboardListener);
    }
}
