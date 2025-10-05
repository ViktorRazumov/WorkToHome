
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TrafficLightPanel {
  static int panelNumber;
  static JTextField textField1;
  static JTextField textField2;
  static JTextField textField3;
  static JTextField textField4;
  static JTextField textField5;

  public static JPanel createPanel(int number, AlarmClock ac) {
    panelNumber = number;
    JPanel generalPanel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(generalPanel, BoxLayout.Y_AXIS);
    Dimension gpDim = new Dimension(300, 370);
    generalPanel.setLayout(boxLayout);
    generalPanel.setMaximumSize(gpDim);
    generalPanel.setPreferredSize(gpDim);
    generalPanel.setMinimumSize(gpDim);

    JPanel trafficLightPanel = new JPanel(new GridLayout(3, 2, 5, 5));
    trafficLightPanel.setBackground(Color.gray);
    Dimension tlpDim = new Dimension(298, 120);
    trafficLightPanel.setMaximumSize(tlpDim);
    trafficLightPanel.setPreferredSize(tlpDim);
    trafficLightPanel.setMinimumSize(tlpDim);

    JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

    JLabel label1 = new JLabel("Traffic Light №" + number);
    JLabel label2 = new JLabel("Performer: ");
    JLabel label3 = new JLabel("Next Action: ");

    JButton button1 = new JButton("Green");
    JButton button2 = new JButton("Yellow");
    JButton button3 = new JButton("Red");
    JButton button4 = new JButton("Action");

    textField1 = new JTextField("Green");
    textField2 = new JTextField("Yellow");
    textField3 = new JTextField("Red");
    textField4 = new JTextField("Action");
    textField5 = new JTextField("Next Action");

    button1.setBackground(Color.GREEN);
    button2.setBackground(Color.yellow);
    button3.setBackground(Color.RED);

    button4.setMaximumSize(new Dimension(90, 40));
    button4.setEnabled(false);

    String[] items = {"ONE", "TWO", "THREE"};
    JComboBox<String> comboBox = new JComboBox<>(items);
    Dimension cbDim = new Dimension(200, 40);
    comboBox.setPreferredSize(cbDim);
    comboBox.setMaximumSize(comboBox.getPreferredSize());
    comboBox.setMinimumSize(cbDim);

    comboPanel.add(comboBox);

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
    generalPanel.add(comboPanel);
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

    click(button1, button4, textField1, textField2, textField3, textField4, textField5, label1, ac);
    click(button3, button4, textField3, textField2, textField1, textField4, textField5, label1, ac);
    click(button2, button4, textField1, textField2, textField3, textField4, textField5, ac, label1);
    click(button4, textField4, textField5, ac, label1, comboBox);

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

  private static void click(JButton b, JButton b2, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JLabel label, AlarmClock ac) {
    b.addActionListener(_ -> {
      setTextAndLog(tf1, b, label);
      changeTheState(tf2, tf3, tf4, tf5, b2);
      ac.stop();
    });
  }

  private static void click(JButton b, JButton b2, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, AlarmClock ac, JLabel label) {
    b.addActionListener(_ -> {
      setTextAndLog(tf2, tf5, b, label);
      changeTheState(tf1, tf3, tf4, b2);
      handleAlarm(ac);
    });
  }

  private static void click(JButton b, JTextField tf4, JTextField tf5, AlarmClock ac, JLabel label, JComboBox cb) {
    b.addActionListener(_ -> {
      setTextAndLog(tf4, tf5, b, label, cb);
      changeTheState(tf4);
      handleAlarm(ac);
    });
  }

  private static void changeTheState(JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JButton b2) {
    disabled(tf2);
    disabled(tf3);
    disabled(tf5);
    b2.setEnabled(false);
    tf4.setEnabled(false);
  }

  private static void setTextAndLog(JTextField tf1, JButton b, JLabel label) {
    setTextTf(tf1);
    LogHelper.append(label.getText(), " " + b.getText() + " fgfgdfgfgdgdg " + label.getText());
  }

  private static void handleAlarm(AlarmClock ac) {
    ac.setAlarm(LocalDateTime.now());
  }

  private static void changeTheState(JTextField tf1, JTextField tf3, JTextField tf4, JButton b2) {
    disabled(tf1);
    disabled(tf3);
    b2.setEnabled(true);
    tf4.setEnabled(true);
  }

  private static void setTextAndLog(JTextField tf2, JTextField tf5, JButton b, JLabel label) {
    setTextTf(tf2);
    setTextTfNext(tf5);
    LogHelper.append(label.getText(), " " + b.getText() + " fgfgdfgfgdgdg " + label.getText() + " next text " + tf5.getText() );
  }

  private static void changeTheState(JTextField tf4) {
    tf4.setEnabled(true);
  }

  private static void setTextAndLog(JTextField tf4, JTextField tf5, JButton b, JLabel label, JComboBox cb) {
    setTextTf(tf4);
    setTextTfNext(tf5);
    LogHelper.append(label.getText(), " " + Objects.requireNonNull(cb.getSelectedItem()) +  " " + b.getText() + " fgfgdfgfgdgdg " + label.getText() + " next text " + tf5.getText() );
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