import java.util.ArrayList;

public class Deck {
    String[] suits = {"Черви ", "Буби ", "Пики ", "Трефы "};
    String[] nums =  {"2 ","3 ","4 ","5 ","6 ", "7 ", "8 ", "9 ", "10 ","J " ,"Q ", "K ", "A "};
    ArrayList<String> PlayDeck = new ArrayList<>(52);
    public ArrayList<String> playDeck(){
        int x = 0;
        int cnt = 0;
        while ((cnt< 52) && (x < 4)) {
            for (int y = 0; y < 13; y++) {
                PlayDeck.add(cnt,(nums[y] + suits[x]));
                cnt++;
            }
            x++;
        }
        return PlayDeck;
    }
    public String[] suffle(ArrayList<String> Deck){
        String[] hand = new String[2];
        String[] CardCharacter = new String[2];
        int x = 0;
        while (x<2){
            int card = (int)(Math.random()*52+1);
            hand[x] = Deck.get(card);
            PlayDeck.remove(Deck.indexOf(card));
            x++;
        }
        return hand;
    }
}
