import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import javax.swing.*;

public class War
{
  public static void main(String[] args)
  {
      Scanner keyboard = new Scanner(System.in); //Allows Input
      ArrayList<Card> deck = new ArrayList<Card>();
      String decision;
      
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
      
      
         
      //Add two players to play the game
      ArrayList<Card> Player1 = new ArrayList<Card>();
      ArrayList<Card> Player2 = new ArrayList<Card>();
      
      //Split the deck for the players
      for(int i = 0; i<deck.size();i++)
      {
         if(i<26)
           Player1.add(deck.get(i));
         
         else
           Player2.add(deck.get(i));
 
      }
          
       System.out.println("-----------------------------------");
       System.out.println("LET THE GAME BEGIN!!!!");
       
         System.out.println("Deal? yes/no");
         decision = keyboard.nextLine();  
       
    try
    {
       while((!((Player1.isEmpty() && Player2.isEmpty())))&& decision.equals("yes"))
       {
         
         System.out.println("\n Player 1 deck size: " +
         Player1.size()+" Player 2 deck size " +Player2.size());
         
         System.out.println("Player 1 : "+Player1.get(Player1.size()-1) +
         " VS Player 2: " + Player2.get(Player2.size()-1));
         
         int compare = Player1.get(Player1.size()-1).compareTo(Player2.get(Player2.size()-1));

         
         if(compare == 1)
         {
            
            System.out.println("Player 1 wins!!!!!");
            
            Player1.add(Player2.remove(Player2.size()-1));
            Collections.shuffle(Player1);
            
         }
         
         
         if(compare == -1)
         {
            System.out.println("Player 2 wins!!!!!");
            
            Player2.add(Player1.remove(Player1.size()-1));
            Collections.shuffle(Player2);
            
         }
         
         while(compare == 0)
         {
            Collections.shuffle(Player1);
            Collections.shuffle(Player2);
            
            System.out.println("WAR!!!!!!!!!!");
            
            compare = Player1.get(Player1.size()-3).compareTo(Player2.get(Player2.size()-3));
            
            if(compare == 1)
            {
               System.out.println("Player 1 wins the war!!");
               
                for (int i = 1; i<=3; i++)
                  Player1.add(Player2.remove(Player2.size()-i));
                  
                  
                Collections.shuffle(Player1);
             }
             
             if(compare == -1)
             {
               System.out.println("Player 2 wins the war!!");
               
                 
                for (int i = 1; i<=3; i++)
                 Player2.add(Player1.remove(Player1.size()-i));
                
                  
               Collections.shuffle(Player2);
               
             }
             
              
          }    
             System.out.println("Deal? yes/no");
             decision = keyboard.nextLine();
       } 
       
       
     }
      catch (IndexOutOfBoundsException theException)  //tries to catch this type...

        {
            
            if(Player1.size() == 0)
               System.out.println("Winner is Player 2" );

          

            if(Player2.size() == 0)
               System.out.println("Winner is Player 1" );
 
        }       
            
         
   }   
 
 }  
         
         
         
         
         
 
  
     
      
      
  
  
  
 

