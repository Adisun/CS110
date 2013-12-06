// GUI for tic tac toe
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame
{
   private TicTacToe game; // the guts
   private JPanel topPanel,gamePanel;  // break up regions
   private JButton [][] buttons;    // grid of buttons
   private JLabel status;  // game status
   private JLabel title;   // static title
   public TicTacToeGUI()
   {
      setLayout(new GridLayout(2,1));
      game =new TicTacToe();
      topPanel = new JPanel();
      topPanel.setBackground(Color.green);
      gamePanel = new JPanel(new GridLayout(3,3));
      buttons = new JButton[3][3];
      for (int r=0;r<3;r++)
         for(int c=0;c<3;c++)
         {
            buttons[r][c] = new TTTButton(r,c," ");
            buttons[r][c].addActionListener(new ButtonListener());
            gamePanel.add(buttons[r][c]);
         }
         
      title = new JLabel("Jackie's Tic Tac Toe Game");
      title.setFont(new Font("HELVETICA",Font.ITALIC,36));
      //title.setForeGround(Color.RED);
      topPanel.add(title);
         
      status = new JLabel("Game in progress");
      status.setFont(new Font("ARIAL",Font.BOLD,24));
      topPanel.add(status);
      

      add(topPanel);
      add(gamePanel);
   }
   // handle button events
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
         char winner;  

         TTTButton source = (TTTButton)(e.getSource());
         // make a move
         if (game.move(source.getRow(),source.getCol()))
         {
            // react
            if (game.getPlayer() == 'o')
               source.setIcon(new ImageIcon("x.jpg"));
            else
               source.setIcon(new ImageIcon("o.jpg"));
            
            winner = game.winner();
            
            if ((winner !='_')||game.getMoves()==9)
               if (winner != '_')
               {
                  status.setText("Winner is " + winner);
                  disableAll();
                 
               }
               else
               {
                  status.setText("It's a tie");
                  disableAll();

               
               }
              
         }
      }
      // disable all buttons
      public void disableAll()
      {
         for (int r=0;r<3;r++)
            for(int c=0;c<3;c++)
            {
               buttons[r][c].setEnabled(false);
            }
      
      }
   }     


}