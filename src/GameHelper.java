import java.util.*;
import java.lang.String;
//todo прописать то что когда человек делает фолд игра останавливается, победа второму, и идет все заново.

public class GameHelper {//todo написать медоты на префлоп, флоп, терн и ривер или подумать нахуй они тут нужны вообще.
    ArrayList<Card> cards = new ArrayList<>();
    int SumOfBets = 0;
    int Bet = 0;
    Scanner inputBet = new Scanner(System.in);

    public ArrayList<Card> cardsOnDesk(Deck d) {
        cards = d.takeCards(5);
        return cards;
    }

    public void resultOfGame(Player p1, Player p2) {//todo написать медот когда А игрок выиграл и когда Б игрок выиграл
        Player winner ;
        if (p1.powOfComb() > p2.powOfComb()) {
            winner = p1;
            winner.Stack+=Bet;
            System.out.println("В этой раздаче победу одержал игрок1 с комбинацией:" + p1.getCombination());
        }
        if (p1.powOfComb() == p2.powOfComb()){
            if (p1.highCard() > p2.highCard()){
                winner = p1;
                winner.Stack+=Bet;
                System.out.println("В этой раздаче победу одержал игрок1 с комбинацией: "+p1.combination );
            }else if (p2.highCard() > p1.highCard()){
                winner = p2;
                winner.Stack+=Bet;
                System.out.println("В этой раздаче победу одержал игрок2 с комбинацией: "+p2.combination);
            }
        }
        if (p1.powOfComb() < p2.powOfComb()){
            winner = p2;
            winner.Stack+=Bet;
            System.out.println("В этой раздаче победу одержал игрок2 с комбинацией:" + p2.getCombination());
        }
        if (p1.Hand.isEmpty()) {
            winner = p2;
            winner.Stack += Bet;
        }
        if (p2.Hand.isEmpty()){
            winner = p1;
            winner.Stack += Bet;
        }
        SumOfBets = 0;
    }

    public void inputPlayerBet() {
        Bet = inputBet.nextInt();
        SumOfBets += Bet;
    }

    public boolean inGame(Player p1, Player p2) {
        return (!p1.Hand.isEmpty()) && (!p2.Hand.isEmpty());
    }

    public void checkAction(Player p1, Player p2) {
        Scanner act = new Scanner(System.in);
        System.out.println("Выберите действие: " +
                "1: уровнять ставки " +
                "2: поднять ставку " +
                "3: поставить все  " +
                "4: скинуть карты ");
        String actNum = act.nextLine();
        if (!p1.Hand.isEmpty() && !p2.Hand.isEmpty()) {
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
        }
    }
    public void startGame(Player p1, Player p2) {
        while ((p1.Stack != 0) && (p2.Stack != 0)) {
            while (inGame(p1,p2)){}

        }
    }
}
