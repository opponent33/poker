import java.util.ArrayList;

public class Deck {
   private final ArrayList<Card> PlayDeck = new ArrayList<>(52);
    public Deck(){
        String[] suits = {"Черви ", "Буби ", "Пики ", "Крести "};
        int[] rank =  {2,3,4,5,6,7,8,9,10,11,12,13,14};
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 13; y++) {
                Card c  = new Card(suits[x],rank[y]);
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
    public void shuffle(){
        int currIndx = getSize()-1;
        while( currIndx!= 0){
            int randomIndx = (int)(Math.random()*PlayDeck.size());
            Card temp = PlayDeck.get(currIndx);
            PlayDeck.set(currIndx, PlayDeck.get(randomIndx));
            PlayDeck.set(randomIndx, temp);
            currIndx--;
        }
    }
    public int getSize(){
        return  PlayDeck.size();
    }
}
