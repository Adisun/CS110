import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyFrame extends JFrame 
{
   private JPanel p1,p2;
   private JLabel label;
   MyFrame(String s) 
   {
      super(s);
      setLayout(new FlowLayout());
      p1 = new JPanel();
      p1.setBackground(Color.green);
      label = new JLabel("I'm a label..");
      p1.add(label); // default location, center
      add(p1);
   }
}