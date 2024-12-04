import java.lang.String;
import java.util.*;

public class Player {
    int Stack;
    int Bet = 0;
    ArrayList<Card> Hand;
    String combination= "";
    int PowOfComb;
    boolean inGame = true;

    public Player(int Stack, ArrayList<Card> cards){
        this.Stack = Stack;
        Hand = cards;
    }
    public String getCombination(){
        return combination;
    }
    public void rise(int Bet){
        Stack -= Bet;
    }

    public void call (int opponentBet){
        Bet = opponentBet;
        Stack -= Bet;
    }
    public boolean allin(){
        Bet = Stack;
        Stack  = 0;
        return true;
    }
    public void fold(){
        Hand.clear();
        inGame = false;
    }

    public int powOfComb(){
        String[] combinations = {"high card", "pair", "two pairs", "set", "straight", "flash", "full house", "quads", "straight flash", "royal flash"};
        ArrayList<String> combination = new ArrayList<>(List.of(combinations));
        PowOfComb = combination.indexOf(getCombination());
        return PowOfComb;
    }
    public void checkComb(ArrayList<Card> cards){
        cards.addAll(Hand);
        if (isRoyalFlush(cards)) combination = "royal flush";
        else if ((isFlush(cards))&&(isStraight(cards))) combination = "straight flush";
        else if (isFourOfAKind(cards)) combination = "quads";
        else if (isFullHouse(cards)) combination = "full house";
        else if (isFlush(cards)) combination = "flush";
        else if (isStraight(cards)) combination = "straight";
        else if (isSet(cards)) combination = "set";
        else if (isTwoPair(cards)) combination = "two pairs";
        else if (isPair(cards)) combination = "pair";
        else combination = "high card";
        //todo  высшая карта;
    }
    public int highCard(){
        int[] ranks = new int[2];
        ranks[1] = Hand.get(1).Rank;
        ranks[0] = Hand.get(0).Rank;
        return Math.max(ranks[1], ranks[0]);
    }

    public boolean isStraight(ArrayList<Card> cards) {
        List<Integer> ranks = new ArrayList<>();
        for (Card card : cards){
            ranks.add(card.Rank);}
        Collections.sort(ranks);
        // Проверка на стрит, учитывая туза как низкий или высокий
        boolean isStraight = true;
        for (int i = 1; i < ranks.size(); i++) {
            if ((ranks.get(i) - ranks.get(i - 1)) != 1) {
                isStraight = false;
                break; // Выход из цикла, если разница не равна 1
            }
        }
        // Проверка на стрит с тузом внизу (A, 2, 3, 4, 5)
        if (!isStraight && (ranks.get(0) == 2) && (ranks.get(1) == 3) &&(ranks.get(2) == 4)&& (ranks.get(3) == 5) && (ranks.get(4) == 14)) {
            isStraight = true;
        }
        return isStraight;
    }
    public boolean isFlush(ArrayList<Card> cards) {
        boolean isFlush = false;
         // Не может быть флеша, если меньше 5 карт
        Map<String, Integer> suitCounts = new HashMap<>();
        for (Card card : cards) {
            suitCounts.put(card.Suit, suitCounts.getOrDefault(card.Suit, 0) + 1);
        }
        for (int count : suitCounts.values()) {
            if (count >= 5) {
                isFlush = true;
            }
        }
        return isFlush;
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
        boolean Set= false;
        boolean Pair = false;
        for (int count : rankCounts.values()){
            if (count == 3) Set = true;
            if (count == 2) Pair = true;
        }
        return Set && Pair;
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
        boolean isQuads = false;
        Map<Integer, Integer> rankCounts = getRankCounts(cards);
        for (int count : rankCounts.values()) {
            if (count == 4) {
                isQuads = true;
                break;
            }
        }
        return isQuads;
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
