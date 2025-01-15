import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Cossack cossack : Field.getCossacks()) {
            if (cossack.isChasingMouse()) {
                cossack.chaseMouse();
            } else {
                cossack.wander();
            }
        }
    }
}
