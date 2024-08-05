package lld.deckofcards;

import java.util.*;

public class Deck {

    Integer max = 54;
    Integer min = 0;

    public Card[] createDeckOfCards() {
        Card []cards = new Card[54];
        int index = 1;
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                if (index < cards.length) {
                    Card card = new Card(suit, rank);
                    cards[index] = card;
                    index++;
                }
            }
        }
        cards[53] = new Card(Suit.JOKER, Rank.JOKER, true);
        return cards;

    }


    public Map<String, List<Card>> dealCards(int playerSize) {
        Map<String, List<Card>> playerCards = new HashMap<>();
        int []randomNumbers = new int[54];
        int player = 0;
        Arrays.fill(randomNumbers, -1);
        Card []cards = createDeckOfCards();
        int loopIndex = (int) cards.length / playerSize;
        for (int i = 0;i < loopIndex;i++) {
            if (player == playerSize) {
                playerSize = 0;
            }
            int random = generateRandomNumber(randomNumbers);
            randomNumbers[random]  = 1;
            String key = "player"+player;
            if (!playerCards.containsKey(key)) {
                List<Card> list = new ArrayList<>();
                list.add(cards[random]);
                playerCards.put(key, list);
            } else {
                playerCards.get(key).add(cards[random]);
            }
            player++;
        }
        System.out.println("printing the final deck");
        System.out.println(playerCards);
//        playerCards.entrySet().stream().map(entry -> entry.getValue()).forEach(System.out::println);
        return playerCards;
    }

    public int generateRandomNumber(int[] randoms) {
        Random r = new Random();
        int random = (int) r.nextInt(max-min) + min;
        boolean inRange = validateRandomNumber(random, randoms);
        if (!inRange) {
            return generateRandomNumber(randoms);
        }
        return random;
    }

    private boolean validateRandomNumber(int random, int[] randomNumbers) {
        if (0 <= random && random <= 54) {
            if (randomNumbers[random] != -1) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String []args) {
        Deck deck = new Deck();
        deck.dealCards(4);
    }
}
