import java.util.*;
import java.lang.String;

public class GameHelper {
    int SumOfBets = 0;
    int Bet = 0;
    Scanner inputBet = new Scanner(System.in);

    public Player resultOfGame(Player p1, Player p2) {
        Player winner = null;
        if (p1.Hand.isEmpty()) {
            p1.PowOfComb = 0;
            p2.PowOfComb = 1;
            winner = p2;
            winner.Stack += Bet;
            System.out.println("В этой раздаче победу одержал игрок2, т.к. игрок1 скинул карты");
            return p2;
        }
        if (p2.Hand.isEmpty()){
            p1.PowOfComb = 1;
            p2.PowOfComb = 0;
            winner = p1;
            winner.Stack += Bet;
            System.out.println("В этой раздаче победу одержал игрок1, т.к. игрок2 скинул карты");
            return p1;
        }
        if (p1.powOfComb() > p2.powOfComb()) {
            winner = p1;
            winner.Stack+=Bet;
            System.out.println("В этой раздаче победу одержал игрок1 с комбинацией: " + p1.getCombination());
        }
        if (p1.powOfComb() == p2.powOfComb()){
            if (p1.highCard() > p2.highCard()){
                winner = p1;
                winner.Stack+=Bet;
                System.out.println("В этой раздаче победу одержал игрок1 с комбинацией: "+ p1.getCombination());
            }else if (p2.highCard() > p1.highCard()){
                winner = p2;
                winner.Stack+=Bet;
                System.out.println("В этой раздаче победу одержал игрок2 с комбинацией: "+p2.getCombination());
            }
        }
        if (p1.powOfComb() < p2.powOfComb()){
            winner = p2;
            winner.Stack+=Bet;
            System.out.println("В этой раздаче победу одержал игрок2 с комбинацией: " + p2.getCombination());
        }
        SumOfBets = 0;
        return winner;
    }
    public void flop(Player p1, Player p2, ArrayList<Card> desk){
        for (int i = 0; i<3; i ++){System.out.println(desk.get(i).CardChar);}
        checkAction(p1, p2);
        checkAction(p2, p1);
    }
    public void turn(Player p1, Player p2, ArrayList<Card> desk){
        for (int i = 0; i<4; i ++){System.out.println(desk.get(i).CardChar);}
        checkAction(p1, p2);
        checkAction(p2, p1);
    }
    public void river(Player p1, Player p2, ArrayList<Card> desk){
        for (int i = 0; i<5; i ++){System.out.println(desk.get(i).CardChar);}
        checkAction(p1, p2);
        checkAction(p2, p1);
    }

    public void inputPlayerBet() {
        Bet = inputBet.nextInt();
        SumOfBets += Bet;
        Bet = 0;
    }


    public void checkAction(Player p1, Player p2) {
        Scanner act = new Scanner(System.in);
        System.out.println("Выберите действие: " +
                "1: уровнять ставки/check" +
                "2: поднять ставку " +
                "3: поставить все  " +
                "4: скинуть карты ");
        String actNum = act.nextLine();
        if (!p1.Hand.isEmpty() && !p2.Hand.isEmpty()) {
            switch (actNum) {
                case "1" -> {
                    p1.call(p2.Bet);
                    SumOfBets += p1.Bet;
                }
                case "2" -> {
                    inputPlayerBet();
                    p1.rise(Bet);
                    SumOfBets += p1.Bet;
                }
                case "3" -> {
                    p1.allin();
                    SumOfBets += p1.Bet;
                }
                case "4" -> p1.fold();
            }
        }
    }
    public void startGame(Player p1, Player p2, Deck deck) {

    }
}
