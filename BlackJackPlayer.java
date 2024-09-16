import java.util.ArrayList;

public class BlackJackPlayer {
    
    public String name;
    public ArrayList<Card> cards = new ArrayList<Card>();
    public int money = 100;
    public int bet;


    BlackJackPlayer(String name)
    {
        this.name = name;
    }

    public void bet(int value)
    {
        this.bet = value;
        this.money -= value;
    }

    public void drawCard(Card card)
    {
        this.cards.add(card);
    }

    public int getCardsValue()
    {
        int val = 0;
        for(Card card : this.cards) {
            val += card.value;
        }
        return val;
    }

    public void payUp(boolean wonHand)
    {
        if(wonHand)
        {
            this.money += 2 * this.bet;
        }
        this.bet = 0;
        while(this.cards.size() > 0)
        {
            this.cards.remove(0);
        }
    }

    public void payTie()
    {
        this.money += this.bet;
        this.bet = 0;
        while(this.cards.size() > 0)
        {
            this.cards.remove(0);
        }
    }
}
