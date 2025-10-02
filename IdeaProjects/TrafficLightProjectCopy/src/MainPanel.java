import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel {


  private final CardLayout cardLayout;
  private final JPanel summerPanel;
  private final JPanel winterPanel;

  private final List<TrafficLightPanel> summerLights = new ArrayList<>();
  private final List<TrafficLightPanel> winterLights = new ArrayList<>();
  public MainPanel() {
    cardLayout = new CardLayout();
    setLayout(cardLayout);

    summerPanel = new JPanel();
    BoxLayout layout1 = new BoxLayout(summerPanel, BoxLayout.X_AXIS);

    winterPanel = new JPanel();
    BoxLayout layout2 = new BoxLayout(winterPanel, BoxLayout.X_AXIS);

    summerPanel.setLayout(layout1);
    winterPanel.setLayout(layout2);

    for (int i = 1; i <= 10; i++) {
      AlarmClock ac = new AlarmClock(i);
      TrafficLightPanel tlp = new TrafficLightPanel(i, ac);
      if (i <= 5) {
        summerLights.add(tlp);
        summerPanel.add(tlp.createPanel());
        summerPanel.add(Box.createHorizontalStrut(3));
      } else {
        winterLights.add(tlp);
        summerPanel.add(tlp.createPanel());
        winterPanel.add(Box.createHorizontalStrut(3));
      }
    }

    add(summerPanel, "SUMMER");
    add(winterPanel, "WINTER");
  }

//  public JPanel getPanel() {
//    return mainPanel;
//  }

  public void offWinter() {
    cardLayout.show(this, "SUMMER");
    for (TrafficLightPanel tlp : winterLights) {
      tlp.pressRed();
    }
//    winterPanel.setVisible(false);
//    for (TrafficLightPanel tlp : winterLights) {
//      tlp.pressRed();
//    }
//    mainPanel.remove(winterPanel);
//    mainPanel.revalidate();
//    mainPanel.repaint();
  }

  public void onWinter() {
    cardLayout.show(this, "WINTER");
    for (TrafficLightPanel tlp : winterLights) {
      tlp.pressYellow();
    }
//    winterPanel.setVisible(true);
//    mainPanel.add(winterPanel);
//    for (TrafficLightPanel tlp : winterLights) {
//      tlp.pressYellow();


//    mainPanel.revalidate();
//    mainPanel.repaint();
  }
}
