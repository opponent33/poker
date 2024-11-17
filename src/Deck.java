import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> PlayDeck;

    public Deck() {
        String[] suits = { "Hearts", "Diamonds", "Spades", "Clubs" };
        String[] nums = { "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10 ", "J ", "Q ", "K ", "A " };
        PlayDeck = new ArrayList<>(52);

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 13; y++) {
                Card c = new Card(nums[y], suits[x]);
                PlayDeck.add(c);
            }
        }
        shuffle();
    }

    public int getSize() {
        return PlayDeck.size();
    }

    public void shuffle() {
        int currentIndex = PlayDeck.size();

        while (currentIndex != 0) {

            int randomIndex = (int) (Math.random() * PlayDeck.size());
            currentIndex--;

            Card mem = PlayDeck.get(currentIndex);
            PlayDeck.set(currentIndex, PlayDeck.get(randomIndex));
            PlayDeck.set(randomIndex, mem);
        }
    }

    public Card[] takeCards(int count) {
        Card[] picked = new Card[count];

        for (int x = 0; x < count; x++) {
            picked[x] = PlayDeck.get(x);
            PlayDeck.remove(x);
        }
        
        return picked;
    }


}
