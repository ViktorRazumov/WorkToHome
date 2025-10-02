import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuBar {
  private MainPanel mainPanel;

  public MenuBar(MainPanel mainPanel) {
    this.mainPanel = mainPanel;
  }

  public JMenuBar getMenuBar() {

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JCheckBoxMenuItem winterMode = new JCheckBoxMenuItem("Winter Mode");

    winterMode.setSelected(true);
    winterMode.addActionListener(e -> {
      if (winterMode.isSelected()) {
        mainPanel.onWinter();
        winterMode.setText("Winter Mode");
      } else {
        mainPanel.offWinter();
        winterMode.setText("Summer Mode");
      }
    });

    JMenuItem item1 = new JMenuItem("item1");
    JMenuItem item2 = new JMenuItem("item2");
    menu.add(item1);
    menu.add(item2);
    menu.add(winterMode);
    menuBar.add(menu);
    return menuBar;
  }
}
