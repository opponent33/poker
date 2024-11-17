import java.util.ArrayList;

public class Deck {
   private final ArrayList<Card> PlayDeck = new ArrayList<>(52);
    public Deck(){
        String[] suits = {"Черви ", "Буби ", "Пики ", "Трефы "};
        String[] nums =  {"2 ","3 ","4 ","5 ","6 ", "7 ", "8 ", "9 ", "10 ","J " ,"Q ", "K ", "A "};
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 13; y++) {
                Card c  = new Card(nums[y], suits[x]);
                PlayDeck.add(c);
            }
        }
        shuffle();
    }
    public ArrayList<Card> takeCards(int cnt){
        ArrayList<Card> hand = new ArrayList<>(cnt);
        for( int x = 0; x < cnt; x++){
            hand.add(x,PlayDeck.get(x));
            PlayDeck.remove(x);
        }
        return hand;
    }
    public ArrayList<Card> shuffle(){
        int currIndx = getSize();
        while( currIndx!= 0){
            int randomIndx = (int)(Math.random()*PlayDeck.size());
            currIndx--;
            Card temp = PlayDeck.get(currIndx);
            PlayDeck.set(currIndx, PlayDeck.get(randomIndx));
            PlayDeck.set(randomIndx, temp);
        }
        return PlayDeck;
    }
    public int getSize(){
        return  PlayDeck.size();
    }
}
