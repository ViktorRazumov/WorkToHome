import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmClock  {

  private final int number;
  private Timer timer;

  public AlarmClock(int number) {
    this.number = number;
  }

  public void setAlarm(LocalDateTime time) {
    if (timer!=null) {
      timer.cancel();
    }
    timer = new Timer();

    timer.schedule(new TimerTask(){
      @Override
      public void run() {
        LocalDateTime now = LocalDateTime.now();
        if (now.getHour() == time.getHour() && now.getMinute() == time.getMinute()) {
          javax.swing.SwingUtilities.invokeLater(() ->{
            playBeep();
          JOptionPane.showMessageDialog(null, "TIMETADAIME" + number, "TIME", JOptionPane.INFORMATION_MESSAGE);
          });
          timer.cancel();
        }
      }
    }, 0, 1_000);

  }

  private void playBeep() {
    try {
      java.awt.Toolkit.getDefaultToolkit().beep();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
