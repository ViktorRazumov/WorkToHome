import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmClock  {

  int number;

  public AlarmClock(int number) {
    this.number = number;
  }

  public boolean isRunning;
  Timer t;

  public void setAlarm(LocalDateTime time) {
    if (t != null) {
      t.cancel();
    }

    t = new Timer();

    t.schedule(new TimerTask(){
      @Override
      public void run() {
        isRunning = true;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime alarmTime = time.plusMinutes(2);
        if (now.getHour() == alarmTime.getHour() && now.getMinute() == alarmTime.getMinute()) {
          javax.swing.SwingUtilities.invokeLater(() ->{
            playBeep();
          JOptionPane.showMessageDialog(null, "TIMETADAIME" + number, "TIME", JOptionPane.INFORMATION_MESSAGE);
          });
          t.cancel();
          isRunning = false;
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

  public void stop() {
    if (isRunning) {
      t.cancel();
    }
  }
}
