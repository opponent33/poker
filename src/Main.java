import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public  class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player1 = new Player(1200, deck.takeCards(2));
        Player player2 = new Player(1200, deck.takeCards(2));
        GameHelper Game = new GameHelper();
        Game.startGame(player1, player2);
    }
}
