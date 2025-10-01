
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrafficLightPanel {

  public static JPanel createPanel(int number) {
    JPanel generalPanel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(generalPanel, BoxLayout.Y_AXIS);
    generalPanel.setLayout(boxLayout);
    generalPanel.setMaximumSize(new Dimension(300, 500));

    JPanel trafficLightPanel = new JPanel();
    GridLayout trafficLightLayout = new GridLayout(3, 2, 5, 5);
    trafficLightPanel.setLayout(trafficLightLayout);
    trafficLightPanel.setBackground(Color.gray);
    trafficLightPanel.setMaximumSize(new Dimension(300, 150));

    JLabel label1 = new JLabel("Traffic Light №" + number);
    JLabel label2 = new JLabel("Performer: ");
    JLabel label3 = new JLabel("Next Action: ");

    JButton button1 = new JButton("Green");
    JButton button2 = new JButton("Yellow");
    JButton button3 = new JButton("Red");
    JButton button4 = new JButton("Action");

    JTextField textField1 = new JTextField("Green");
    JTextField textField2 = new JTextField("Yellow");
    JTextField textField3 = new JTextField("Red");
    JTextField textField4 = new JTextField("Action");
    JTextField textField5 = new JTextField("Next Action");

    button1.setBackground(Color.GREEN);
    button2.setBackground(Color.yellow);
    button3.setBackground(Color.RED);

    button4.setMaximumSize(new Dimension(90, 40));
    button4.setEnabled(false);

    String[] items = {"ONE", "TWO", "THREE"};
    JComboBox<String> comboBox = new JComboBox<>(items);
    comboBox.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
    comboBox.setMaximumSize(new Dimension(100, 40));

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
    generalPanel.add(Box.createVerticalStrut(10));

    generalPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
    generalPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    makeCenter(generalPanel);
    makeSize(generalPanel);
    disable(generalPanel);
    disable(trafficLightPanel);

    click1(button1, button4, textField1, textField2, textField3, textField4, textField5);
    click1(button3, button4, textField3, textField2, textField1, textField4, textField5);
    click2(button2, button4, textField1, textField2, textField3, textField4, textField5);
    click3(button4, textField4, textField5);

    return generalPanel;
  }

  private static void makeCenter(JPanel panel) {
    for (Component c : panel.getComponents()) {
      if (c instanceof JPanel || c instanceof JButton || c instanceof JLabel || c instanceof JTextField) {
        ((JComponent) c).setAlignmentX(Component.CENTER_ALIGNMENT);
      }
    }
  }

  private static void makeSize(JPanel panel) {
    for (Component c : panel.getComponents()) {
      if (c instanceof JTextField || c instanceof JComboBox) {
        c.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        c.setMinimumSize(new Dimension(Integer.MAX_VALUE, 30));
      }
    }
  }

  private static void disable(JPanel panel) {
    for (Component c : panel.getComponents()) {
      if (c instanceof JTextField) {
        ((JTextField) c).setEditable(false);
        ((JTextField) c).setHorizontalAlignment(JTextField.CENTER);
      }
    }
  }

  private static void click1(JButton b, JButton b2, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5) {
    b.addActionListener(_ -> {
      setTextTf(tf1);
      disabled(tf2);
      disabled(tf3);
      disabled(tf5);
      b2.setEnabled(false);
      tf4.setEnabled(false);
    });
  }

  private static void click2(JButton b, JButton b2, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5) {
    b.addActionListener(_ -> {
      setTextTf(tf2);
      disabled(tf1);
      disabled(tf3);
      b2.setEnabled(true);
      tf4.setEnabled(true);
      setTextTfNext(tf5);
    });
  }

  private static void click3(JButton b, JTextField tf4, JTextField tf5) {
    b.addActionListener(_ -> {
      tf4.setEnabled(true);
      setTextTf(tf4);
      setTextTfNext(tf5);
    });
  }

  private static void setTextTfNext(JTextField tf) {
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    LocalDateTime nextDateTime = currentDateTime.plusDays(3);
    tf.setText(nextDateTime.format(formatter));
  }

  private static void setTextTf(JTextField tf) {
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    String formattedDateTime = currentDateTime.format(formatter);
    tf.setText(formattedDateTime);
  }

  private static void disabled(JTextField tf) {
    tf.setText("-- -- -- -- --");
  }

}