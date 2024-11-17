public class Card {
    String Suit;
    String Value;
    String CardChar;
    public Card(String Suit, String Value){
        this.Suit = Suit;
        this.Value = Value;
        CardChar = Suit+Value;
    }
    public String getCardChar(){
        return CardChar;
    }
}
