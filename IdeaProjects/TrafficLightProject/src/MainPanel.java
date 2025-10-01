import javax.swing.*;
import java.awt.*;

public class MainPanel {

  static JPanel mainPanel = new JPanel();
  static JPanel summerPanel = new JPanel();
  static JPanel winterPanel = new JPanel();

  public static JPanel getPanel() {

    BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    BoxLayout layout1 = new BoxLayout(summerPanel, BoxLayout.X_AXIS);
    BoxLayout layout2 = new BoxLayout(winterPanel, BoxLayout.X_AXIS);
    mainPanel.setLayout(layout);
    summerPanel.setLayout(layout1);
    winterPanel.setLayout(layout2);

    for (int i = 1; i < 6; i++) {
      summerPanel.add(TrafficLightPanel.createPanel(i));
      summerPanel.add(Box.createHorizontalStrut(3));
    }

    for (int i = 6; i < 11; i++) {
      winterPanel.add(TrafficLightPanel.createPanel(i));
      winterPanel.add(Box.createHorizontalStrut(3));
    }

    mainPanel.add(summerPanel);
    mainPanel.add(winterPanel);

    return mainPanel;
  }

  public static void offWinter() {
    winterPanel.setVisible(false);
  }

  public static void onWinter() {
    winterPanel.setVisible(true);
  }


}
