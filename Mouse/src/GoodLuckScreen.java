import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoodLuckScreen extends JFrame {
    public GoodLuckScreen() {
        initFrame();
    }

    public void initFrame() {
        setSize(400,300);
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        getContentPane().setLayout(null);

        JLabel mrs = new JLabel(new ImageIcon("resources/mrsmouse.png"));
        mrs.setBounds(265,25,110,120);
        getContentPane().add(mrs);

        JLabel mr = new JLabel(new ImageIcon("resources/mrmouse.png"));
        mr.setBounds(10,160,105,125);
        getContentPane().add(mr);

        JLabel text = new JLabel("<html>Маус! Мечтай! Действуй! Твори! Верь в себя и никогда не сдавайся!</html>");
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.TOP);
        text.setFont(new Font("Courier",Font.ITALIC,20));
        text.setBounds(135,20,130,200);
        getContentPane().add(text);

        JButton button = new JButton("Хорошо, миссис Мышь.");
        button.setBounds(240,250,150,40);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(3,3,3,3));
//        button.setFont(new Font("Courier",Font.ITALIC,20));
        button.addActionListener(new ActionListener() {
            int timesPressed = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                timesPressed++;
                switch (timesPressed) {
                    case 1:
                        text.setVerticalAlignment(SwingConstants.CENTER);
                        text.setText("<html>А вообще...</html>");
                        button.setText("...?");
                        break;
                    case 2:
                        mrs.setIcon(new ImageIcon("resources/mrsmouse2.png"));
                        text.setHorizontalAlignment(SwingConstants.CENTER);
                        text.setText("<html>Делай, что хочешь, Мыш!</html>");
                        button.setText("!@#$%&^%$&!!");
                        break;
                    case 3:
                        Field.timer.start();
                        dispose();
                        break;
                }
            }
        });
        getContentPane().add(button);

        setVisible(true);
    }
}
