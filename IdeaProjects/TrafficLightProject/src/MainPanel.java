import javax.swing.*;
import java.awt.*;

public class MainPanel {
  public static JPanel getPanel() {
    JPanel mainPanel = new JPanel();
    BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.X_AXIS);
    mainPanel.setLayout(layout);

    for (int i = 1; i < 6; i++) {
      mainPanel.add(TrafficLightPanel.createPanel(i));
      mainPanel.add(Box.createHorizontalStrut(3));
    }


    return mainPanel;

  }
}
