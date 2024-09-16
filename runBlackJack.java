public class runBlackJack
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        deck.shuffle();
        for (Card card : deck.cards)
        {
            System.out.println(card.suit + ' ' + card.name + ' ' + card.value);
        }
    }
}