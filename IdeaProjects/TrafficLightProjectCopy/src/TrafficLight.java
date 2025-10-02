import javax.swing.*;
import java.awt.*;


void main() {
  SwingUtilities.invokeLater(() -> {
    JFrame trafficLightFrame = new JFrame("Traffic Light");
    trafficLightFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    trafficLightFrame.setSize(1800, 900);
    MainPanel mainPanel = new MainPanel();
    trafficLightFrame.setContentPane(mainPanel);
    MenuBar menuBar = new MenuBar(mainPanel);
    trafficLightFrame.setJMenuBar(menuBar.getMenuBar());
    trafficLightFrame.setVisible(true);
  });

}