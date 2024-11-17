import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Deck d;
        Card[] table;
        Card[] hands;
        Player P;
        ArrayList<String> stockList;
        String[] v;

        do {
            d = new Deck();

            P = new Player(100);

            table = d.takeCards(5);

            hands = d.takeCards(2);

            P.giveHards(hands);

            stockList = P.checkForComb(table);

            v = new String[stockList.size()];
            v = stockList.toArray(v);
        } while (!(Arrays.stream(v).anyMatch("straight"::equals)));

        for (int x = 0; x < 5; x++) {
            System.out.println(table[x].num + " " + table[x].suit);
        }

        for (int x = 0; x < 2; x++) {
            System.out.println(hands[x].num + " " + hands[x].suit);
        }

        for (String x : v) {
            System.out.println(x);
        }

    }

    public static void func(Deck d) {
        Player P = new Player(100);

        Card[] table = d.takeCards(5);

        Card[] hands = d.takeCards(2);
        for (int x = 0; x < 5; x++) {
            System.out.println(table[x].num + " " + table[x].suit);
        }

        for (int x = 0; x < 2; x++) {
            System.out.println(hands[x].num + " " + hands[x].suit);
        }

        P.giveHards(hands);

        System.out.println(P.checkForComb(table));
    }
}