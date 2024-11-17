import java.lang.String;
import java.util.*;

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

    public ArrayList<String> checkForComb(Card[] cardsOnTable) {
        ArrayList<String> out = new ArrayList<>(10);

        // Assuming hand is already filled with two cards
        Card[] allCards = new Card[cardsOnTable.length + 2]; // total cards = hand cards + cards on table
        System.arraycopy(hand, 0, allCards, 0, hand.length);
        System.arraycopy(cardsOnTable, 0, allCards, hand.length, cardsOnTable.length);

        // Count occurrences of each rank and suit
        Map<Integer, Integer> rankCount = new HashMap<>();
        Map<String, Integer> suitCount = new HashMap<>();

        for (Card card : allCards) {
            rankCount.put(card.num, rankCount.getOrDefault(card.num, 0) + 1);
            suitCount.put(card.suit, suitCount.getOrDefault(card.suit, 0) + 1);
        }

        boolean isFlush = false;
        for (Map.Entry<Integer, Integer> entry : rankCount.entrySet()) {
            isFlush = (entry.getValue() >= 5) || isFlush;
        }
        boolean isStraight = isStraight(rankCount.keySet());

        // Check for combinations
        if (isFlush && isStraight) {
            if (rankCount.containsKey(14)) { // Ace is high
                out.add("royal flush");
            }
            out.add("straight flush");
        }

        int maxCount = Collections.max(rankCount.values());

        if (maxCount == 4)
            out.add("quads");
        if (maxCount == 3) {
            if (rankCount.values().contains(3) && rankCount.values().contains(2)) {
                out.add("full house");
            }
            out.add("set");
        }
        if (maxCount == 2) {
            int count = 0;

            for (Integer x : rankCount.values()) {
                if (x == 2) {
                    count++;
                }
            }

            if (count >= 2) {
                out.add("two pairs");
            }
            if (count >= 1) {
                out.add("pair");
            }
        }

        if (isFlush)
            out.add("flash");
        if (isStraight)
            out.add("straight");

        out.add("high card");

        return out;
    }

    private boolean isStraight(Set<Integer> ranks) {
        List<Integer> sortedRanks = new ArrayList<>(ranks);
        Collections.sort(sortedRanks);
        for (int x = 0; x < sortedRanks.size() - 4; x++) {
            int c = 0;
            for (int y = 0; y < 4; y++) {
                if (sortedRanks.get(x + y) + 1 == sortedRanks.get(x + y + 1)) {
                    c ++;
                }
            }

            if (c == 4) {
                return true;
            }
        }
        return false;
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
