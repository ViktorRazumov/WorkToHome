import javax.swing.*;
import java.awt.*;

public class LogPanel extends JPanel{
  private JTextArea textArea;

  public LogPanel() {
    super(new BorderLayout());
    textArea = new JTextArea();
    textArea.setEditable(false);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

    JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    this.add(scrollPane,BorderLayout.CENTER);
    this.setPreferredSize(new Dimension(500, 300));
  }

  public void appendText(String text) {
    textArea.append(text);
    textArea.append("\n");

    textArea.setCaretPosition(textArea.getDocument().getLength());
  }

  public void setText(String text) {
    textArea.setText(text);
  }

  public String getText(){
    return textArea.getText();
  }

  public void clear(){
    textArea.setText("");
  }

  public JTextArea getTextArea() {
    return textArea;
  }
}
