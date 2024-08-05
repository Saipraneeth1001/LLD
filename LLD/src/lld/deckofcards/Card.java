package lld.deckofcards;

public class Card {
    Suit suit;
    Rank rank;
    boolean isJoker;
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card(Suit suit, Rank rank, boolean isJoker) {
        this.suit = suit;
        this.rank = rank;
        this.isJoker = true;
    }

    public String toString() {
        return "Suit: "+ suit.toString() + " rank: "+rank.toString();
    }

}
