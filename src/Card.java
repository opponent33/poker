public class Card {
    String Suit;
    int Rank;
    String CardChar;
    public Card(String Suit, int Rank){
        this.Suit = Suit;
        this.Rank = Rank;
        CardChar = Rank + Suit;
    }
    public String getCardChar(){
        String rank = String.valueOf(Rank);
        CardChar = rank + Suit;
        return CardChar;
    }
}
