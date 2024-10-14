public class BlackJackDealer extends BlackJackPlayer 
{
    BlackJackDealer()
    {
        super("dealer");
    }

    public void play(Deck deck)
    {
        boolean allDone = false;
        while(!allDone)
        {
            int val = this.getCardsValue();
            if(val <= 16)
            {
                this.drawCard(deck.getTopCard());
            }
            else
            {
                allDone = true;
            }
        }
    }
    public void showCards(boolean showFullHand)
    {
        for(int i = 0; i < this.cards.size(); i++)
        {
            if(i == 0 || showFullHand)
            {
                String suit = this.cards.get(i).suit;
                String name = this.cards.get(i).name;
                System.out.print("| " + suit + "-" + name + " | ");
            }
            else
            {
                System.out.print("| ? |");
            }
        }
        System.out.println();
    }
    public void reset()
    {
        while(this.cards.size() > 0)
        {
            this.cards.remove(0);
        }
    }
}
