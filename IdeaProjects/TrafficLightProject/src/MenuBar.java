import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuBar {

  public static JMenuBar getMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenu menu2 = new JMenu("Menu2");
    JMenuItem logBtn = new JMenuItem("View log");
    JMenuItem item2 = new JMenuItem("item2");
    JMenuItem item3 = new JMenuItem("item3");
    JMenuItem item4 = new JMenuItem("item4");
    menu.add(logBtn);
    menu.add(item2);
    menu2.add(item3);
    menu2.add(item4);

    logBtn.addActionListener(e -> new LogWindow().setVisible(true));

    item3.addActionListener((ActionEvent e) -> MainPanel.offWinter());
    item4.addActionListener((ActionEvent e) -> MainPanel.onWinter());

    menuBar.add(menu);
    menuBar.add(menu2);

    return menuBar;
  }
}
