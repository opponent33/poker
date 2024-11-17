import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Player {
    int stack;
    Card[] hand = new Card[2];
    int bet = 0;

    public Player(int stack) {
        this.stack = stack;
    }

    public void giveHards(Card[] cards) {
        if (cards.length != 2) {
            System.out.println("ТЫ ДОЛБАЕБ");
            return;
        }
        hand = cards;
    }

    public String checkForComb(int count, Card[] cardsOnTable) {
        // Assuming hand is already filled with two cards
        Card[] hand = new Card[2]; // Replace with actual hand cards
        Card[] allCards = new Card[count + 2]; // total cards = hand cards + cards on table
        System.arraycopy(hand, 0, allCards, 0, hand.length);
        System.arraycopy(cardsOnTable, 0, allCards, hand.length, cardsOnTable.length);

        // Count occurrences of each rank and suit
        Map<Integer, Integer> rankCount = new HashMap<>();
        Map<Integer, Integer> suitCount = new HashMap<>();

        for (Card card : allCards) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
            suitCount.put(card.getSuit(), suitCount.getOrDefault(card.getSuit(), 0) + 1);
        }

        boolean isFlush = suitCount.values().stream().anyMatch(count -> count >= 5);
        boolean isStraight = isStraight(rankCount.keySet());

        // Check for combinations
        if (isFlush && isStraight) {
            if (rankCount.containsKey(14)) { // Ace is high
                return "royal flush";
            }
            return "straight flush";
        }

        int maxCount = Collections.max(rankCount.values());

        if (maxCount == 4)
            return "quads";
        if (maxCount == 3) {
            if (rankCount.size() == 2)
                return "full house";
            return "set";
        }
        if (maxCount == 2) {
            if (rankCount.size() == 3)
                return "two pairs";
            return "pair";
        }

        if (isFlush)
            return "flash";
        if (isStraight)
            return "straight";

        return "high card";
    }

    private boolean isStraight(Set<Integer> ranks) {
        List<Integer> sortedRanks = new ArrayList<>(ranks);
        Collections.sort(sortedRanks);
        for (int i = 0; i < sortedRanks.size() - 1; i++) {
            if (sortedRanks.get(i + 1) - sortedRanks.get(i) != 1) {
                return false;
            }
        }
        return true;
    }

    public void rise(int bet) {
        stack -= bet;
    }

    public void call(int opponentBet) {
        stack -= opponentBet;
    }

    public void allin() {
        stack = 0;
    }
}
