import javax.swing.*;

public class Tester 
{
	public static void main(String [] args) 
{
		JFrame frame = new MyFrame("New Frame ...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
      // OR
      frame.setSize(200,400);
      frame.validate();
      frame.setVisible(true);

	}
}
