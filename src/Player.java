import java.lang.String;
import java.util.Scanner;

public class Player {
    int Stack;
    int Bet = 0;
    String[] Hand;
    String[] SuitsOfCard;
    String[] valueOfCard;
    String combination = "";
    Scanner InputBet = new Scanner(System.in);
    public void setArrays(String[] cards){
        for (int i = 0; i<2; i++){
            Hand[i] = cards[i];
            String[] cardChar = cards[i].split(" ");
            SuitsOfCard[i] = cardChar[0];
            valueOfCard[i] = cardChar[1];
        }
    }
    public void setBeginStack(){
        System.out.println("Введите сумму, на которую хотите сыграть.");
        Scanner CrackSum = new Scanner(System.in);
        Stack = CrackSum.nextInt();
    }
    public void StackAfrerRound(int bet, boolean GameResult){//GameResut переменная для игроков по отдельности
        if (GameResult){Stack += Bet;}
        else {Stack -= Bet;}
    }

    public int rise(boolean isRise, int opponentBet){
        int rise = 0;
        while (rise <= opponentBet){
            System.out.println("Введите значение ставки (больше, чем " + opponentBet + "): ");
            System.out.println("Ставка соперника выше, вам необходимо повысить ставку");
            rise = InputBet.nextInt();
            Stack -= rise;
            Bet = rise;
        }
    return rise;
    }
    public boolean fold(boolean inGame){
        if (!inGame){
            Hand[0] = null;
            Hand[1] = null;
            System.out.println("Вы скинули карты, вы проиграли.");

        }
return inGame;
    }
    public  int call (int opponentBet, boolean isCall){
    Bet = opponentBet;
    Stack -= Bet;
return opponentBet;
    }
    public int blind (){
        System.out.println("Введите количество фишек, которое хотите поставить в слепую");
        Scanner bet = new Scanner(System.in);
        return bet.nextInt();
    }
    public int allin(){
        Bet = Stack;
        Stack  = 0;
        return Bet;
    }
}
