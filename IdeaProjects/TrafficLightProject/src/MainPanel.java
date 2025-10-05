import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainPanel {

  static JPanel mainPanel = new JPanel();
  static JPanel summerPanel = new JPanel();
  static JPanel winterPanel = new JPanel();
  static LogPanel logPanel;

  public static JPanel getPanel() {

    logPanel = new LogPanel();
    logPanel.setBorder(new EmptyBorder(0, 20, 0, 20));

    BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    BoxLayout layout1 = new BoxLayout(summerPanel, BoxLayout.X_AXIS);
    BoxLayout layout2 = new BoxLayout(winterPanel, BoxLayout.X_AXIS);
    mainPanel.setLayout(layout);
    summerPanel.setLayout(layout1);
    winterPanel.setLayout(layout2);

    for (int i = 1; i < 6; i++) {
      AlarmClock ac = new AlarmClock(i);
      summerPanel.add(TrafficLightPanel.createPanel(i, ac));
      summerPanel.add(Box.createHorizontalStrut(3));
    }

    for (int i = 6; i < 11; i++) {
      AlarmClock ac = new AlarmClock(i);
      winterPanel.add(TrafficLightPanel.createPanel(i, ac));
      winterPanel.add(Box.createHorizontalStrut(3));
    }

    mainPanel.add(summerPanel);
    mainPanel.add(winterPanel);
    mainPanel.add(logPanel);
    return mainPanel;
  }

  public static void offWinter() {
    winterPanel.setVisible(false);
  }

  public static void onWinter() {
    winterPanel.setVisible(true);
  }
}
