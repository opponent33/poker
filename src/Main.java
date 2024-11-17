import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public  class Main{
    public static void main(String[] args){
        Deck d  = new Deck();
        ArrayList<Card> CardOnDesk = d.takeCards(3);
        for (int x = 0; x < 3; x++){
            System.out.println(CardOnDesk.get(x).getCardChar());
        }
    }
}