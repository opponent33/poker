import java.lang.String;
import java.util.*;

public class Player {
    int Stack;
    int Bet = 0;
    ArrayList<Card> Hand;
    static String combination= "";

    public Player(int Stack, ArrayList<Card> cards){
        this.Stack = Stack;
        Hand = cards;
    }
    public int rise(int Bet){
        int rise = Bet;
        Stack -= rise;
        return rise;
    }

    public  int call (int opponentBet){
        Bet = opponentBet;
        Stack -= Bet;
        return opponentBet;
    }
    public int allin(){
        Bet = Stack;
        Stack  = 0;
        return Bet;
    }
    public  ArrayList<Card> fold(){
        Hand.clear();
        return Hand;
    }
    public int powOfComb(){
        String[] combinations = {"high card", "pair", "two pairs", "set", "straight", "flash", "full house", "quads", "straight flash", "royal flash"};
        Map<String, Integer> PowComb = new HashMap<>();
        for (int i = 1; i<combinations.length; i++){
            PowComb.put(combinations[i] , i);
        }
        return PowComb.get(combination);
    }
    public String checkComb(ArrayList<Card> cards){//todo записать в порядке убывания
        cards.addAll(Hand);
        if (isRoyalFlush(cards)) combination = "royal flush";
        if ((isFlush(cards))&&(isStraight(cards))) combination = "straight flush";
        if (isFourOfAKind(cards)) combination = "quads";
        if (isFullHouse(cards)) combination = "full house";
        if (isFlush(cards)) combination = "flush";
        if (isStraight(cards)) combination = "straight";
        if (isSet(cards)) combination = "set";
        if (isTwoPair(cards)) combination = "two pairs";
        if (isPair(cards)) combination = "pair";
        else return "high card";
        //todo написать метод под фулл хаус и Роял флеш и высшая карта;
        return  combination;
    }
    public boolean isStraight(ArrayList<Card> cards) {
        if (cards.size() < 5) return false; // Не может быть стрита, если меньше 5 карт

        List<Integer> ranks = new ArrayList<>();
        for (Card card : cards) ranks.add(card.Rank);
        Collections.sort(ranks);

        // Проверка на стрит, учитывая туза как низкий или высокий
        boolean isStraight = true;
        for (int i = 1; i < ranks.size(); i++) {
            if (ranks.get(i) - ranks.get(i - 1) != 1) {
                isStraight = false;
                break; // Выход из цикла, если разница не равна 1
            }
        }

        // Проверка на стрит с тузом внизу (A, 2, 3, 4, 5)
        if (!isStraight && ranks.get(0) == 2 && ranks.get(1) == 3 && ranks.get(2) == 4 && ranks.get(3) == 5 && ranks.get(4) == 14) {
            isStraight = true;
        }
        return isStraight;
    }
    public boolean isFlush(ArrayList<Card> cards) {
        if (cards.size() < 5) {return false;} // Не может быть флеша, если меньше 5 карт

        Map<String, Integer> suitCounts = new HashMap<>();
        for (Card card : cards) {
            suitCounts.put(card.Suit, suitCounts.getOrDefault(card.Suit, 0) + 1);
        }

        for (int count : suitCounts.values()) {
            if (count >= 5) {
                return true;
            }
        }
        return false;
    }

    public Map<Integer, Integer> getRankCounts(ArrayList<Card> cards) {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (Card card : cards) {
            rankCounts.put(card.Rank, rankCounts.getOrDefault(card.Rank, 0) + 1);
        }
        return rankCounts;
    }
    public boolean isFullHouse(ArrayList<Card> cards){
        Map <Integer, Integer> rankCounts = getRankCounts(cards);
        boolean hasSet= false;
        boolean hasPair = false;
        for (int count : rankCounts.values()){
            if (count == 3) hasSet = true;
            if (count == 2) hasPair = true;
        }
        return hasSet && hasPair;
    }

    public boolean isPair(ArrayList<Card> cards) {
        Map<Integer, Integer> rankCounts = getRankCounts(cards);
        for (int count : rankCounts.values()) {
            if (count == 2) {return true;};
        }
        return false;
    }

    public boolean isTwoPair(ArrayList<Card> cards) {
        Map<Integer, Integer> rankCounts = getRankCounts(cards);
        int pairCount = 0;
        for (int count : rankCounts.values()) {
            if (count == 2) pairCount++;
        }
        return pairCount == 2;
    }

    public boolean isSet(ArrayList<Card> cards) {
        Map<Integer, Integer> rankCounts = getRankCounts(cards);
        for (int count : rankCounts.values()) {
            if (count == 3) return true;
        }
        return false;
    }

    public boolean isFourOfAKind(ArrayList<Card> cards) {
        Map<Integer, Integer> rankCounts = getRankCounts(cards);
        for (int count : rankCounts.values()) {
            if (count == 4) return true;
        }
        return false;
    }
    public  boolean isRoyalFlush(ArrayList<Card> cards){
        if (!isFlush(cards)) return false;
        Map<Integer, Integer> rank = getRankCounts(cards);
        boolean  pass = true;
        for (int i = 10; i < 15; i++) {
            pass = pass && (rank.getOrDefault(i, 0) == 1);
        }
        return pass;

    }
}
