import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public  class Main {
    public static void main(String[] args) {
        GameHelper gameHelper = new GameHelper();
        Deck deck = new Deck();
        ArrayList<Card> Desk ;
        Player player1 = new Player(1000, deck.takeCards(2));
        Player player2 = new Player(1000, deck.takeCards(2));
        while (player1.Stack != 0 && player2.Stack !=0) {
            Desk = deck.takeCards(5);
            gameHelper.checkAction(player1, player2);
            gameHelper.checkAction(player2, player1);
            if ((!player2.allin()) || (!player1.allin())) {
                gameHelper.flop(player1, player2, Desk);
                gameHelper.turn(player1, player2, Desk);
                gameHelper.river(player1, player2, Desk);
            }else {
                for (Card c : Desk){System.out.println(c.CardChar);}
                player1.checkComb(Desk);
                player2.checkComb(Desk);
            }
            player1.checkComb(Desk);
            player2.checkComb(Desk);
            gameHelper.resultOfGame(player1, player2);
            deck = new Deck();
            player1.Hand = deck.takeCards(2);
            player2.Hand = deck.takeCards(2);
        }
    }
}
