import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

void main() {
  JFrame trafficLightFrame = new JFrame("Traffic Light");
  trafficLightFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  trafficLightFrame.setSize(1500, 500);
  trafficLightFrame.setContentPane(MainPanel.getPanel());

  JMenuBar menuBar = new JMenuBar();
  JMenu menu = new JMenu("Menu");
  JMenuItem item1 = new JMenuItem("item1");
  JMenuItem item2 = new JMenuItem("item2");
  JMenuItem item3 = new JMenuItem("item3");
  menu.add(item1);
  menu.add(item2);
  menu.add(item3);

  menuBar.add(menu);
  trafficLightFrame.setJMenuBar(menuBar);

//  JPanel trafficLightPanel = new JPanel();
//  GridLayout trafficLightLayout = new GridLayout(3, 2, 5, 5);
//  trafficLightPanel.setLayout(trafficLightLayout);
//  trafficLightPanel.setBackground(Color.gray);
//  TitledBorder trafficLightBorder = new TitledBorder("Traffic Light Border");
//  trafficLightBorder.setTitleJustification(TitledBorder.CENTER);
//  trafficLightPanel.setBorder(trafficLightBorder);
//
//  JPanel performer = new JPanel();
//  //BoxLayout performerLayout = new BoxLayout(performer, BoxLayout.Y_AXIS);
//  //performer.setLayout(performerLayout);
//  performer.setBackground(Color.blue);
//  Dimension dim = new Dimension(50, 150);
//  performer.setMaximumSize(dim);
//
//  JLabel label = new JLabel("performer");
//  label.setVerticalTextPosition(JLabel.CENTER);
//  performer.add(label);
//
//  JButton ok = new JButton("OK");
//  performer.add(ok);
//
//  JTextArea dateTimeOk = new JTextArea();
//  dateTimeOk.setSize(100, 20);
//  performer.add(dateTimeOk);
//
//  JPanel next = new JPanel();
//  GridLayout nextLayout = new GridLayout(3, 1, 5, 5);
//  TitledBorder nextBorder = new TitledBorder("nextPanel");
//  next.setLayout(nextLayout);
//  next.setBackground(Color.yellow);
//  next.setBorder(nextBorder);
//
//  mainPanel.add(trafficLightPanel);
//  mainPanel.add(performer);
//  mainPanel.add(next);
//
//  JTextArea dateTimeGreen = new JTextArea();
//  dateTimeGreen.setSize(100, 20);
//
//  JTextArea dateTimeYellow = new JTextArea();
//  dateTimeGreen.setSize(100, 20);
//
//  JTextArea dateTimeRed = new JTextArea();
//  dateTimeGreen.setSize(100, 20);
//
//  JButton yellowButton = new JButton("yellow");
//  yellowButton.setSize(50, 50);
//  yellowButton.setBackground(Color.yellow);
//
//  JButton greenButton = new JButton("green");
//  greenButton.setSize(50, 50);
//  greenButton.setBackground(Color.green);
//
//  JButton redButton = new JButton("red");
//  redButton.setSize(50, 50);
//  redButton.setBackground(Color.red);
//
//  trafficLightPanel.add(greenButton);
//  trafficLightPanel.add(dateTimeGreen);
//  trafficLightPanel.add(yellowButton);
//  trafficLightPanel.add(dateTimeYellow);
//  trafficLightPanel.add(redButton);
//  trafficLightPanel.add(dateTimeRed);
//
//
//  trafficLightFrame.add(mainPanel);
  trafficLightFrame.setVisible(true);
}