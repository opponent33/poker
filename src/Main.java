import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public  class Main{
    public static void main(String[] args){
        Deck d  = new Deck();
        d.playDeck();
        ArrayList<String> PlayDeck = d.playDeck();
        d.suffle(PlayDeck);
    }
}