import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

void main() {
  JFrame trafficLightFrame = new JFrame("Traffic Light");
  trafficLightFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  trafficLightFrame.setSize(1500, 900);
  trafficLightFrame.setContentPane(MainPanel.getPanel());

  JMenuBar menuBar = MenuBar.getMenuBar();
  trafficLightFrame.setJMenuBar(menuBar);
  menuBar.getMenu(1).getItem(0).addActionListener((ActionEvent e) -> trafficLightFrame.setSize(1500, 500));
  menuBar.getMenu(1).getItem(1).addActionListener((ActionEvent e) -> trafficLightFrame.setSize(1500, 900));

  trafficLightFrame.setVisible(true);
}