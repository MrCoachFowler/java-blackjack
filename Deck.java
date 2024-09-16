import java.util.Random;
import java.util.ArrayList;

public class Deck {
    
    public ArrayList<Card> cards = new ArrayList<Card>();

    Deck() {
        String[] names = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] values = new int[]{11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        String[] suits = new String[]{"D", "S", "C", "H"};

        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 13; j++)
            {
                Card newCard = new Card(suits[i], names[j], values[j]);
                this.cards.add(newCard);
            }
        }

    }

    public void shuffle() {
        ArrayList<Card> newCards = new ArrayList<Card>();
        int cardMaxIndex = this.cards.size();
        Random rand = new Random();

        while(cardMaxIndex > 0) 
        {
            int randCardIndex = rand.nextInt(cardMaxIndex);
            newCards.add(this.cards.get(randCardIndex));
            this.cards.remove(randCardIndex);
            cardMaxIndex--;
        }
        this.cards = newCards;
    }

    public Card getTopCard(){
        Card topCard = this.cards.get(0);
        this.cards.remove(topCard);
        return topCard;
    }
}
