import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Field extends JFrame {
    public static Container container;
    private static int[][] space = new int[30][20];
    private static Mouse mouse;
    private static Cossack cossack;
    private static Hole hole;
    private static ArrayList<Cossack> cossacks = new ArrayList<>();
    private static ArrayList<Cheese> cheeses = new ArrayList<>();
    private static TimerListener timerListener = new TimerListener();
    public static Timer timer = new Timer(250, timerListener);

    public Field() {
        setSize(Config.FIELDWIDTH, Config.FIELDHEIGHT);
        setUndecorated(true);
        setLocationRelativeTo(null);

        container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.GRAY);

        try {
            Scanner scanner = new Scanner(new File("resources/level1.txt"));
            for (int y = 0; y < 20; y++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int x = 0; x < 30; x++) {
                    space[x][y] = Integer.parseInt(String.valueOf(chars[x]));
                    if (space[x][y] == 1) {
                        Wall wall = new Wall(x, y,1,1);
                        container.add(wall);
                    }
                    if (space[x][y] == 2) {
                        mouse = new Mouse(x, y);
                        container.add(mouse);
                    }
                    if (space[x][y] == 3) {
                        cossack = new Cossack(x, y);
                        container.add(cossack);
                        cossacks.add(cossack);
                    }
                    if (space[x][y] == 4) {
                        Cheese cheese = new Cheese(x, y);
                        container.add(cheese);
                        cheeses.add(cheese);
                    }
                    if (space[x][y] == 5) {
                        hole = new Hole(14,9);
                        container.add(hole);
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static int[][] getSpace() {
        return space;
    }

    public static Mouse getMouse() {
        return mouse;
    }

    public static ArrayList<Cossack> getCossacks() {
        return cossacks;
    }

    public static ArrayList<Cheese> getCheeses() {
        return cheeses;
    }

    public static Hole getHole() {
        return hole;
    }

    public static Cossack getCossack() {
        return cossack;
    }

    public Timer getTimer() {
        return timer;
    }

    public static void levelFinished() {
        timer.stop();
        JOptionPane.showMessageDialog(null, "Уровень пройден.");

    }
}
