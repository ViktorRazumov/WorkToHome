import javax.swing.*;
import java.awt.*;

public class TrafficLightPanel {
  public static JPanel createPanel(int number) {
    JPanel generalPanel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(generalPanel, BoxLayout.Y_AXIS);
    generalPanel.setLayout(boxLayout);

    JPanel trafficLightPanel = new JPanel();
    GridLayout trafficLightLayout = new GridLayout(3, 2, 5, 5);
    trafficLightPanel.setLayout(trafficLightLayout);
    trafficLightPanel.setBackground(Color.gray);
    trafficLightPanel.setMaximumSize(new Dimension(500, 150));

    JLabel label1 = new JLabel("Traffic Light №" + number);
    JLabel label2 = new JLabel("Performer: ");
    JLabel label3 = new JLabel("Next Action: ");

    JButton button1 = new JButton("Green");
    JButton button2 = new JButton("Yellow");
    JButton button3 = new JButton("Red");
    JButton button4 = new JButton("Action");

    button4.setMaximumSize(new Dimension(90, 40));

    JTextField textField1 = new JTextField("Green");
    JTextField textField2 = new JTextField("Yellow");
    JTextField textField3 = new JTextField("Red");
    JTextField textField4 = new JTextField("Action");
    JTextField textField5 = new JTextField("Next Action");

    String[] items = {"ONE", "TWO", "THREE"};
    JComboBox<String> comboBox = new JComboBox<>(items);
    comboBox.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

    trafficLightPanel.add(button1);
    trafficLightPanel.add(textField1);
    trafficLightPanel.add(button2);
    trafficLightPanel.add(textField2);
    trafficLightPanel.add(button3);
    trafficLightPanel.add(textField3);

    generalPanel.add(Box.createVerticalStrut(10));
    generalPanel.add(label1);
    generalPanel.add(Box.createVerticalStrut(10));
    generalPanel.add(trafficLightPanel);
    generalPanel.add(Box.createVerticalStrut(10));
    generalPanel.add(label2);
    generalPanel.add(Box.createVerticalStrut(10));
    generalPanel.add(comboBox);
    generalPanel.add(Box.createVerticalStrut(10));
    generalPanel.add(button4);
    generalPanel.add(Box.createVerticalStrut(10));
    generalPanel.add(textField4);
    generalPanel.add(Box.createVerticalStrut(10));
    generalPanel.add(label3);
    generalPanel.add(Box.createVerticalStrut(10));
    generalPanel.add(textField5);

    generalPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
    generalPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


    makeCenter(generalPanel);
    makeSize(generalPanel);
    disable(generalPanel);
    disable(trafficLightPanel);

    return generalPanel;
  }

  private static void makeCenter(JPanel panel){
    for (Component c : panel.getComponents()) {
      if (c instanceof JPanel || c instanceof JButton || c instanceof JLabel || c instanceof JTextField) {
        ((JComponent) c).setAlignmentX(Component.CENTER_ALIGNMENT);
      }
    }
  }

  private static void makeSize(JPanel panel){
    for (Component c : panel.getComponents()) {
      if (c instanceof JTextField || c instanceof JComboBox) {
        c.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        c.setMinimumSize(new Dimension(Integer.MAX_VALUE, 30));
      }
    }
  }

  private static void disable(JPanel panel){
    for (Component c : panel.getComponents()) {
      if (c instanceof JTextField) {
        ((JTextField) c).setEditable(false);
        ((JTextField) c).setHorizontalAlignment(JTextField.CENTER);
      }
    }
  }
}
