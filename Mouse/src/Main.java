import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.setVisible(true);
        System.out.println("jframe: " + field.getWidth() + "x" + field.getHeight() + "\n" + "container: " + field.getContentPane().getWidth() + "x" + Field.container.getHeight());
    }
}
