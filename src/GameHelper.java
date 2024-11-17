import java.util.*;
import java.lang.String;


public class GameHelper {
    String[] combinations = {"high card", "pair", "two pairs", "set", "straight", "flash", "full house", "quads", "straight flash", "royal flash"};
    String PlayerComb = " ";
    ArrayList<String> cards = new ArrayList<>();
    int SumBet = 0;
    ArrayList<String> SuitsOfCards = new ArrayList<>();
    ArrayList<String> VolumeOfCards = new ArrayList<>();

    public void cardChar (String card){
        String[] cardsChar = new String[2];
        cardsChar = card.split(" ");
        SuitsOfCards.add(cardsChar[1]);
        VolumeOfCards.add(cardsChar[2]);
    }

    public ArrayList<String> showFlop(Deck playDeck){
        int x = 0;

        while (x < 5){
            int index = (int)(Math.random()*playDeck.getSize() +1);
            cards.add(playDeck.get(index));
            cardChar(playDeck.get(index));
            playDeck.remove(index);
            x++;
            CardsInDeck -=1;
        }
        return cards;
    }

    public boolean checkSuits(Player player){
        int CntEquals = 0;
        for ( int i = 0; i<2; i++){
            for (String suit: SuitsOfCards){
                if(suit.equals(player.SuitsOfCard[i])){CntEquals++;}
            }
        }
        return CntEquals >= 5;
    }

    public int checkValue(Player player){
        int CntEquals = 0;
        for ( int i = 0; i < 2; i++){
            for (String value : VolumeOfCards){
                if (value.equals(player.valueOfCard[i])){CntEquals++;}
            }
        }
        return CntEquals;
    }

    public boolean isStraight(Player player){
        ArrayList<String> distrub = new ArrayList<>(7);
        for (String cards : distrub  ) {}

        return false;
    }
}
