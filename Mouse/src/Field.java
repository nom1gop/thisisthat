import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Field extends JFrame {
    static Mouse mouse = new Mouse(5,5);
    static Container container = new Container();
    static JPanel menu = new JPanel();
    static ArrayList<Wall> walls = new ArrayList<>();
    static ArrayList<Cheese> cheeses = new ArrayList<>();
    static JLabel number = new JLabel("0");

    public Field() {
        super("Mouse");
        setSize(1200, 900);
        setLocationRelativeTo(null);
        addKeyListener(new KeyboardListener());
        setUndecorated(true);

        container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.GRAY);
        container.add(mouse);

        menu.setBounds(0,800, 1200, 100);
        menu.setLayout(new FlowLayout(FlowLayout.LEFT));
        menu.setBackground(Color.LIGHT_GRAY);
        menu.setOpaque(true);
        container.add(menu);

        JLabel collected = new JLabel(" собрано сыра:    ");
            collected.setFont(new Font("Courier", Font.PLAIN, 40));
        //JLabel number = new JLabel("0");
            number.setFont(new Font("Courier", Font.PLAIN, 40));
        JLabel remain = new JLabel("    времени осталось:    ");
            remain.setFont(new Font("Courier", Font.PLAIN, 40));
        JLabel time = new JLabel("60");
            time.setFont(new Font("Courier", Font.PLAIN, 40));
        menu.add(collected);
        menu.add(number);
        menu.add(remain);
        menu.add(time);

//********************************************* добавляем стены **********************************************
        for (int i = 0; i < 5; i++) {
            //Wall wall = new Wall();
            switch (i) {
                case 0:
                    Wall wall0 = new Wall(8,3,1,5);
                    container.add(wall0);
                    walls.add(wall0);
                    break;
                case 1:
                    Wall wall1 = new Wall(11,3,1,5);
                    container.add(wall1);
                    walls.add(wall1);
                    break;
                case 2:
                    Wall wall2 = new Wall(14,3,1,5);
                    container.add(wall2);
                    walls.add(wall2);
                    break;
                case 3:
                    Wall wall3 = new Wall(17,3,1,5);
                    container.add(wall3);
                    walls.add(wall3);
                    break;
                case 4:
                    Wall wall4 = new Wall(8,3,4,1);
                    container.add(wall4);
                    walls.add(wall4);
                    break;
            }
        }

//********************************************* добавляем сыр *************************************
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    Cheese cheese0 = new Cheese(1,1);
                    container.add(cheese0);
                    cheeses.add(cheese0);
                    break;
                case 1:
                    Cheese cheese1 = new Cheese(1,13);
                    container.add(cheese1);
                    cheeses.add(cheese1);
                    break;
                case 2:
                    Cheese cheese2 = new Cheese(18,1);
                    container.add(cheese2);
                    cheeses.add(cheese2);
                    break;
                case 3:
                    Cheese cheese3 = new Cheese(18,13);
                    container.add(cheese3);
                    cheeses.add(cheese3);
                    break;
                case 4:
                    Cheese cheese4 = new Cheese(10,12);
                    container.add(cheese4);
                    cheeses.add(cheese4);
                    break;
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(0, 800, 1200, 800);
        g2.draw(lin);
    }

    public static Mouse getMouse() {
        return mouse;
    }

    public static ArrayList<Wall> getWalls() {
        return walls;
    }

    public static ArrayList<Cheese> getCheeses() {
        return cheeses;
    }

    public static JLabel getNumber() {
        return number;
    }
}
