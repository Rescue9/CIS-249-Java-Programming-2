package WorkArea;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Test extends JFrame {
  public Test() {
  ImageIcon usIcon = new ImageIcon("archives/Ch12/image/o.gif");
  JButton jbt1 = new JButton(usIcon);
  JButton jbt2 = new JButton(usIcon);

  JPanel p1 = new JPanel();
  p1.add(jbt1);

  JPanel p2 = new JPanel();
  p2.add(jbt2);

  JPanel p3 = new JPanel();
  p2.add(jbt1);

  add(p1, BorderLayout.NORTH);
  add(p2, BorderLayout.SOUTH);
  add(p3, BorderLayout.CENTER);
  }

  public static void main(String[ ] args) {
  // Create a frame and set its properties
  JFrame frame = new Test();
  frame.setSize(200, 100);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  }
}