import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<BlackJackPlayer> players = new ArrayList<BlackJackPlayer>(0);
        BlackJackDealer dealer = new BlackJackDealer();


        for(int i = 0; i < 4; i++)
        {
            System.out.println("Name of player " + (i + 1));
            String playerName = input.nextLine();
            players.add(new BlackJackPlayer(playerName));            
        }

        String quit = "n";
        while(!quit.equals("y"))
        {
            Deck deck = new Deck();
            deck.shuffle();

            //take bets
            for(BlackJackPlayer player : players)
            {
                player.bet();
            }
            //deal cards
            for(int h = 0; h < 2; h++)
            {
                for(int i = 0; i < 4; i++)
                {
                    players.get(i).drawCard(deck.getTopCard());

                }
                dealer.drawCard(deck.getTopCard());
            }

            //players turns
            for(BlackJackPlayer player : players)
            {
                boolean stayed = false;
                while(!stayed)
                {
                    //print out cards
                    clearScreen();
                    System.out.println("Dealer: ");
                    dealer.showCards(false);
                    for(BlackJackPlayer plyr : players)
                    {
                        if(player == plyr)
                        {
                            System.out.println("You: " + plyr.money);
                        }
                        else
                        {
                            System.out.println(plyr.name  + ": " + plyr.money);
                        }
                        for(Card card : plyr.cards)
                        {
                            System.out.print("|" + card.suit + "-" + card.name + "| ");
                        }
                        System.out.println();
                    }


                    //handle hit or stay
                    System.out.print(player.name + ", H to hit or S to stay: ");
                    String hOrS = input.nextLine();
                    if(hOrS.equals("h") || hOrS.equals("H"))
                    {
                        player.drawCard(deck.getTopCard());
                        if (player.getCardsValue() >= 21)
                        {
                            stayed = true;
                        }
                    }
                    else
                    {
                        stayed = true;
                    }
                }
            }
            
            //dealer turn
            dealer.play(deck);


            //allocates winnings
            int dealerVal = dealer.getCardsValue();
            System.out.println("dealer got: " + dealerVal);
            for(BlackJackPlayer player : players)
            {
                if(player.getCardsValue() <= 21 && player.getCardsValue() > dealerVal)
                {
                    player.payUp(true);
                }
                else if(player.getCardsValue() <= 21 && player.getCardsValue() == dealerVal)
                {
                    player.payTie();
                }
                else if (player.getCardsValue() <= 21 && dealerVal > 21)
                {
                    player.payUp(true);
                }
                else
                {
                    player.payUp(false);
                }
            }
            dealer.reset();
            System.out.println("quit?");
            quit = input.nextLine();
        }
    
        input.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
