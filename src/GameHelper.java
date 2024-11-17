import java.util.*;
import java.lang.String;


public class GameHelper {
    ArrayList<Card> cards = new ArrayList<>();
    int SumOfBets = 0;
    int Bet = 0;
    Scanner inputBet = new Scanner(System.in);

    public ArrayList<Card> cardsOnDesk(Deck d) {
        cards = d.takeCards(5);
        return cards;
    }

    public void resultOfGame(Player p1, Player p2) {
        Player winner;
        if (p1.powOfComb() > p2.powOfComb()) {
            winner = p1;
        }else {
        winner = p2;
        winner.Stack+=Bet;
        SumOfBets = 0;
        }
    }

    public void inputPlayerBet() {
        Bet = inputBet.nextInt();
        SumOfBets += Bet;
    }

    public boolean inGame(Player p1, Player p2) {
        return (!p1.Hand.isEmpty()) && (!p2.Hand.isEmpty());
    }

    public String checkAction(Player p1, Player p2) {
        Scanner act = new Scanner(System.in);
        System.out.println("Выберите действие: //n" +
                "1: уровнять ставки //n" +
                "2: поднять ставку //n" +
                "3: поставить все //n " +
                "4: скинуть карты //n");
        String actNum = act.nextLine();
        if (actNum.equals("1")) {
            p1.call(p2.Bet);
            SumOfBets += p1.Bet;
        } else if (actNum.equals("2")) {
            inputPlayerBet();
            p1.rise(Bet);
            SumOfBets += p1.Bet;
        } else if (actNum.equals("3")) {
            p1.allin();
            SumOfBets += p1.Bet;
        } else if (actNum.equals("4")) {
            p1.fold();
        }
        return actNum;
    }

    public void startGame(Player p1, Player p2) {
        while ((p1.Stack != 0) && (p2.Stack != 0)) {
            Deck deck = new Deck();
            cards = cardsOnDesk(deck);
            p1.Hand = deck.takeCards(2);
            p2.Hand = deck.takeCards(2);
            while (inGame(p1, p2)) {
                checkAction(p1, p2);
                checkAction(p2, p1);
                p1.checkComb(cards);
                p2.checkComb(cards);
            }
        }
    }
}
