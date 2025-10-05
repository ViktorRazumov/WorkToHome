import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class LogWindow extends JFrame {
  private final JTextArea textArea;

  public LogWindow() {
    setTitle("Log Viewer");
    setSize(900, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

    JPanel datePanel = new JPanel();
    datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.Y_AXIS));

    JLabel labelFrom = new JLabel("С:");
    JDateChooser dateFrom = new JDateChooser();
    dateFrom.setDateFormatString("yyyy-MM-dd HH:mm");

    JLabel labelTo = new JLabel("По:");
    JDateChooser dateTo = new JDateChooser();
    dateTo.setDateFormatString("yyyy-MM-dd HH:mm");

    JButton filterButton = new JButton("OK");
    filterButton.addActionListener(e -> {
      Date from = dateFrom.getDate();
      Date to = dateTo.getDate();
      if (from == null || to == null) {
        JOptionPane.showMessageDialog(this, "dsasad");
        return;
      }
      showLogsByDate(from, to);
    });

    JButton allButton = new JButton("All Logs");
    leftPanel.add(allButton);
    leftPanel.add(Box.createVerticalStrut(10));

    for (int i = 1; i<= 10; i++) {
      JButton btn = new JButton("T/L №" + i);
      leftPanel.add(btn);
      leftPanel.add(Box.createVerticalStrut(5));
      final int index = i;
      btn.addActionListener(e -> showLogs("Traffic Light №" + index));
    }

    allButton.addActionListener(e -> showAllLogs());

    textArea = new JTextArea();
    textArea.setEditable(false);
    JScrollPane scroll = new JScrollPane(textArea);
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(leftPanel, BorderLayout.WEST);
    getContentPane().add(scroll, BorderLayout.CENTER);

    showAllLogs();
  }

  private void showLogsByDate(Date from, Date to) {
    StringBuilder sb = new StringBuilder();
    for (String log : LogHelper.filterByObjectName("")){
      try {
        String dateStr = log.substring(1, 17);
        LocalDateTime logTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

      } catch (Exception e) {
        e.printStackTrace();

      }
    }
  }

  private void showAllLogs() {
    try {
      List<String> lines = LogHelper.filterByObjectName("");
      textArea.setText(String.join("\n", lines));
    } catch (Exception e) {
      textArea.setText("Ошибка загрузки логов");
    }
  }

  private void showLogs(String objectName) {
    List<String> lines = LogHelper.filterByObjectName(objectName);
    textArea.setText(String.join("\n", lines));
  }
}
