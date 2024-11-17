import java.util.*;
import java.lang.String;


public class GameHelper {
    String[] combinations = {"high card", "pair", "two pairs", "set", "straight", "flash", "full house", "quads", "straight flash", "royal flash"};
    ArrayList<Card> cards = new ArrayList<>();
    int SumBet = 0;
    public ArrayList<Card> cardsOnDesk(Deck d){
    cards = d.takeCards(5);
    return cards;
    }
}
