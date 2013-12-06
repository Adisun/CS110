//Adisun Wheelock
//CS110
//12/4/13


/* This program will simulate the kids card game 'War'. In this variation of War,
a deck is split equally or 26 cards for each player. Cards are based solely off of their 
rank. When a war occurs, the top card of the deck is flipped face down and the winner of the war
is whom has the higher ranked next card of the deck.       */


import java.util.*;
import java.util.Collections;     //Import all packages needed for program functionality
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class WarGUI extends JFrame //Extend JFrame for its method convenience
{

  //4 panels used for the War card game
  private JPanel panel1 = new JPanel();
  private JPanel panel2 = new JPanel();
  private JPanel panel3 = new JPanel();
  private JPanel panel4 = new JPanel();
 
  private ImageIcon back = new ImageIcon("back.jpg");//ImageIcon for the back of a card
  private ImageIcon cardLeft = new ImageIcon();//ImageIcon for the left most face-up card
  private ImageIcon cardRight = new ImageIcon();//ImageIcon for the right most face-up card
  private ImageIcon cardLeftWar = new ImageIcon();//ImageIcon for the face down card when War occurs for Player 1
  private ImageIcon cardRightWar = new ImageIcon();//ImageIcon for the face down card when War occurs for Player 2
  private ImageIcon cardRightWarTop = new ImageIcon();//ImageIcon for the face up card when War occurs for Player 2
  private ImageIcon cardLeftWarTop = new ImageIcon();//ImageIcon for the face up card when War occurs for Player 1
  
  private JLabel player1Card = new JLabel();
  private JLabel player2Card = new JLabel();
  private JLabel player1CardWar = new JLabel();
  private JLabel player2CardWar = new JLabel();          //These labels are used to hold the images
  private JLabel player1CardWarTop = new JLabel();
  private JLabel player2CardWarTop = new JLabel();
  private JLabel deck1 = new JLabel(back);
  private JLabel deck2 = new JLabel(back);
  
  private JLabel deck1size; //Label to display the size of Player 1's deck
  private JLabel deck2size; //Label to display the size of Player 2's deck
  private JLabel winner = new JLabel(); //Label to display the winner of the game
   
  private JButton play = new JButton();//Play button
  
  private ArrayList<Card> deck = new ArrayList<Card>(); //ArrayList to hold a full deck
  private ArrayList<Card> player1 = new ArrayList<Card>();//ArrayList to hold Player 1's deck
  private ArrayList<Card> player2 = new ArrayList<Card>();//ArrayList to hold Player 2's deck
  
  private int compare; //Integer for holding the value of the compareTo card method
 
 
  //Set the resolution of the window 
  private final int WINDOW_WIDTH = 1500; 
  private final int WINDOW_HEIGHT = 800;
  
 
      
     
     public WarGUI()
     {
         setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        
         //Make a deck
          for(int i = 2; i<=14; i++)
              {
                  Card hearts = new Card('h',i);
                  deck.add(hearts);
                  Card clubs = new Card('c',i);
                  deck.add(clubs);
                  Card diamonds = new Card('d',i);
                  deck.add(diamonds);
                  Card spades = new Card('s',i);
                  deck.add(spades);
              }
                  
               //Shuffle the deck
               Collections.shuffle(deck); 
               
               
                  
               
               //Split the deck for the players
               for(int i = 0; i<deck.size();i++)//deck.size()
               {
                  if(i<26)
                    player1.add(deck.get(i));
                  
                  else
                    player2.add(deck.get(i));
          
               }
         
         //Display the size of the decks      
         deck1size = new JLabel("Player 1: "+player1.size());
         deck2size = new JLabel("Player 2: "+player2.size());
         
         //Add a play button and give it a listener
         play = new JButton("Play");
         play.addActionListener(new PlayerListener());
        
         //Set each panel to the background color of dark green
         panel1.setBackground(new Color(0, 122, 0));
         panel2.setBackground(new Color(0, 122, 0));
         panel3.setBackground(new Color(0, 122, 0));
         panel4.setBackground(new Color(0, 122, 0));
         
         
         panel1.add(deck1size); //Add Player 1's deck size label to panel 1
         panel1.add(play);//Add the play button to panel 1
         panel1.add(deck2size);//Add Player 2's deck size label to panel 1
         
         //Set the font for Player 1's and Player 2's deck size
         deck1size.setFont(new Font("HELVETICA",Font.ITALIC,24));
         deck2size.setFont(new Font("HELVETICA",Font.ITALIC,24));
         
         //Set the font for the "play" button
         play.setFont(new Font("HELVETICA",Font.ITALIC,24));
         
         winner.setFont(new Font("HELVETICA",Font.ITALIC,50));
         
         panel2.add(deck1);//Add the "deck" ImageIcon for Player 1 panel 2
         panel2.add(player1Card); //Add Player 1's face up card to panel 2
         panel2.add(player1CardWar);//Add Player 1's face down war card to panel 2
         panel2.add(player1CardWarTop);//Add Player 1's face up war card to panel 2
         panel3.add(player2CardWarTop);//Add Player 2's face up war card to panel 3
         panel3.add(player2CardWar);//Add Player 2's face down war card to panel 3
         panel3.add(player2Card); //Add Player 2's face up card to panel 3
         panel3.add(deck2); //Add the "deck" ImageIcon for Player 2 to panel 3
         panel4.add(winner); //Add the winner label to display who is the winner after a war or the game ends
         
         
         
         
       
         
         
          setLayout(new BorderLayout());//Set the layout to a BorderLayout
          add(panel1,BorderLayout.NORTH);//Add panel 1  to the North end of the BorderLayout 
          add(panel2,BorderLayout.WEST);//Add panel 2  to the West end of the BorderLayout 
          add(panel3,BorderLayout.EAST);//Add panel 3  to the East end of the BorderLayout
          add(panel4,BorderLayout.SOUTH);//Add panel 4  to the West end of the BorderLayout
          
          
          setVisible(true); //Make this BorderLayout visible
     }
     
     /*  The purpose for the PlayerListener class is to simulate the action of the Player's flipping
     over their top card in the deck which would be referred to as a "battle" in the game of War
           */
           
     private class PlayerListener implements ActionListener
     {
         public void actionPerformed(ActionEvent e)
         {
            
            //This string will be set to "Play" when the play button is pushed
            String actionCommand = e.getActionCommand();
            
               try//Need try due to end of game ArrayList out of bounds exception thrown
               {
                   if(actionCommand.equals("Play")) //when the play button is pushed
                     {
                        
                        winner.setText(null); //Set the winner label to null initially
                        
                        
                        
                        //Set each "war" card initially to null. Only want to see them when a war occurs
                        player1CardWar.setIcon(null);
                        player2CardWar.setIcon(null);
                        player1CardWarTop.setIcon(null);
                        player2CardWarTop.setIcon(null);
                        
                        //Set both deck size labels to there appropriate values
                        deck1size.setText("Player 1: "+player1.size());
                        deck2size.setText("Player 2: "+player2.size());
                        
                        
                        //These two lines will set the appropriate ImageIcons with their respective top deck card image
                        cardLeft = new ImageIcon(player1.get(player1.size()-1)+".jpg");
                        cardRight = new ImageIcon(player2.get(player2.size()-1)+".jpg");
   
                        //These two lines will set the two image icons to their respective labels
                        player1Card.setIcon(cardLeft);
                        player2Card.setIcon(cardRight);
                        
                        //Compare the top cards for each players deck
                        compare = player1.get(player1.size()-1).compareTo(player2.get(player2.size()-1));
                        
                           if(compare == 1)//If player 1's card wins
                           {
                              //Add player 2's card to player 1's deck
                              player1.add(player2.remove(player2.size()-1));
                              //Shuffle Player 1's deck
                              Collections.shuffle(player1);
            
                            }
                            
                            
                            if(compare == -1)//If player 2's card wins
                            {
                               //Add player 1's card to player 2's deck
                               player2.add(player1.remove(player1.size()-1));
                               //Shuffle Player 2's deck
                               Collections.shuffle(player2);
            
                            }
                            
                            
                              while(compare == 0)//If a war occurs
                              {
                                 //Shuffle both decks
                                 Collections.shuffle(player1);
                                 Collections.shuffle(player2);
                                 
                                 //Display a face down card image 
                                 player1CardWar.setIcon(back);
                                 player2CardWar.setIcon(back);
                                 
                                 //Set the ImageIcons with their appropriate card images when a war occurs
                                 cardLeftWarTop = new ImageIcon(player1.get(player1.size()-3)+".jpg");
                                 cardRightWarTop = new ImageIcon(player2.get(player2.size()-3)+".jpg");
                                 
                                //Set the labels with their respective card
                                 player1CardWarTop.setIcon(cardLeftWarTop);
                                 player2CardWarTop.setIcon(cardRightWarTop);
                                 
                                 //use the compareTo method in Card class
                                 compare = player1.get(player1.size()-3).compareTo(player2.get(player2.size()-3));
                                 
                                 if(compare == 1)//If player 1 wins the war
                                 {
                                    
                                     winner.setText("Player 1 wins the war!");//display player 1 wins the war
                                     
                                     //Add the 3 cards to player 1's deck
                                     for (int i = 1; i<=3; i++)
                                       player1.add(player2.remove(player2.size()-i));
                                       
                                    //shuffle the deck   
                                     Collections.shuffle(player1);
                                  }
                                  
                                  if(compare == -1)//if player 2 wins
                                  {
                                    
                                    
                                      winner.setText("Player 2 wins the war!");//display player 2 wins the war
                                      
                                      //Add the 3 cards to player 2's deck
                                      for (int i = 1; i<=3; i++)
                                      player2.add(player1.remove(player1.size()-i));
                                     
                                    //shuffle the deck  
                                    Collections.shuffle(player2);
                                    
                                  }
                                  
                                   
                               }
                        
                        
                        
                     
                        }
                      
                   }  
                    
            catch (IndexOutOfBoundsException theException)  //tries to catch this type...
            {
            
               if(player1.size() == 0)//If player 2 wins
               {
                  winner.setText("Winner is Player 2" );//Display player 2 wins
                  panel1.remove(play); //Remove the play button
   
               }
   
               if(player2.size() == 0)//If player 1 wins
               {
                  winner.setText("Winner is Player 1" );//Display player 1 wins
                  panel1.remove(play);//Remove the play button
               }
               
 
            } 
            
         }
       
       
      }
      
      //The driver
      public static void main(String[] args)
      {
         //Make an instance of the war GUI
         WarGUI war = new WarGUI();
         
         //Set the title
         war.setTitle("War Card Game");
         
         //Set the background to dark green
         war.getContentPane().setBackground(new Color(0, 122, 0));
         
         //Exit on close
         war.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

  
}
     
         
      
      
         
         
         
         
         
 
  
     
      
      
  
  
  
 

