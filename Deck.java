import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck
{
    static ArrayList<Card> deck = new ArrayList<Card>();
   
   public Deck(Card card)
   {
      deck.add(card);
   }
   
   public static ArrayList<Card> getDeck()
   {
      return deck;
   }
   
   public ArrayList<Card> shuffle()
   {
       Collections.shuffle(deck);
       
       return deck;
   } 
   
   public String toString()
    {
        return deck.toString();
    }
 
   
}
   
   