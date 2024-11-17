import java.lang.String;
import java.util.*;

public class Player {
    int Stack;
    int Bet = 0;
    ArrayList<Card> Hand;
    String combination= "";

    public Player(int Stack){
        this.Stack = Stack;
    }
    public void setHand(ArrayList<Card> cards){
        Hand = cards;
    }

    public int rise(int Bet){
        int rise = Bet;
        Stack -= rise;
        return rise;
    }

    public  int call (int opponentBet, boolean isCall){
        Bet = opponentBet;
        Stack -= Bet;
        return opponentBet;
    }
    public int allin(){
        Bet = Stack;
        Stack  = 0;
        return Bet;
    }
    public void checkComb(){}
}
