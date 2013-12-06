//Adisun Wheelock
//CS110
//12/4/13


/* This class is used to simply simulate a Card. The card has 
  a suit which in this class is a character.
  
  d - diamonds
  h - hearts
  c - clubs
  s - spades
  
  The card also has a rank ranging from 2-14    */



import javax.swing.*;
import java.awt.*;


public class Card extends JButton
{
   //A card has a suit and rank
   private char suit;
   private int rank;
  
   /** 
      The Card constructor sets the respecting suit
      and rank of the card.
   
    @param suit - the suit of the card
    @param rank - the rank of the card
   */
   public Card (char suit, int rank)
   {
      this.suit = suit;
      this.rank = rank;
   }
   
   //Set the suit of the Card
   public void setSuit(char suit)
   {
      this.suit = suit;
   }
   
   //Set the rank of the Card
   public void setRank(int Rank)
   {
      this.rank = rank;
   }
   
   //Get the suit of the Card
   public char getSuit()
   {
      return suit;
   }
   
   //Get the rank of the Card
   public int getRank()
   {
      return rank;
   }
   
   
   /* toString method to return a string value of the card
      Ex. King of Hearts --> kingh
          2 of Clubs --> 2c
   */
   
   public String toString()
   {
      String str=null;
      
      if(rank == 11)
      str = "jack";
      
      if(rank == 12)
      str = "queen";
      
      if(rank == 13)
      str = "king";
      
      if(rank == 14)
        str = "ace";
      
      if(rank > 10)
      {
         String s = str+suit;
         return s;
      }
      
     String s1 = String.valueOf(rank)+suit;
     return s1;
     
   }
   
   /**
    The compareTo method is used to compare two card objects solely based off of their
    rank. A 1 will return if the card that is being compared to the other card is greater in
    rank. A -1 will return if the card that is being compared to the other card is less in rank. 
    A 0 will return if both cards are equal in rank. 
    
    @param other - The card being tested. 
   
   
   */
   public int compareTo(Card other)
   {
      if(this.rank > other.getRank())
         return 1;
      
      if(this.rank < other.getRank())
         return -1;
         
         else
         {
            return 0;
         }
    }
}