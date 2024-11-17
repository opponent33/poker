import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public  class Main {
    public static void main(String[] args) {
        Deck d;
        ArrayList<Card> table;
        ArrayList<Card> hands;
        Player P;
        ArrayList<String> stockList = new ArrayList<>(0) ;
        while (!stockList.contains("straight")) {
            d = new Deck();
            table = d.takeCards(5);
            P = new Player(100, d.takeCards(2));
            for (int y = 0; y < 5; y++) {
                System.out.print(table.get(y).Rank + table.get(y).Suit);
            }
            System.out.print(P.Hand.get(0).Rank + P.Hand.get(0).Suit);
            System.out.print(P.Hand.get(1).Rank + P.Hand.get(1).Suit);
            stockList.add(P.checkComb(table));
        }
    }
}
