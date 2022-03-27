package Solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Card {

    public enum Rank { deuce, three, four, five, six, seven, eight,
                    nine, ten, jack, queen, king, ace;}

    public enum Suit { clubs, diamonds, spades, hearts;}

    private Rank rank;
    private Suit suit;

    public Rank getRank() { return rank; }
    public Suit getSuit() { return suit; }

    private Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() { return getRank() + " of " + getSuit(); }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return  true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Card  card = (Card) obj;
        return Objects.equals(suit, card.suit) && Objects.equals(rank, card.rank);
    }

    @Override
    public int hashCode(){
        return Objects.hash(suit, rank);
    }

    public String checkDeckMembership(Card card) {
        if (card.suit.equals(suit)) {
            return "The card belongs to the deck";
        } else {
            return "The card does not belong to the deck";
        }
    }

    public String checkRank(Card card) {
        if (card.suit.equals(suit) && rank.compareTo(card.rank) > 0) {
            return "The rank of this card is higher";
        } else if (card.suit.equals(suit) && rank.compareTo(card.rank) < 0) {
            return "The rank of this card is lower";
        } else if (card.suit.equals(suit)){
            return "Card ranks are the same";
        } else {
            return "Cards do not match";
        }
    }

    public int compareTo(Card card) {
        int suitCompare = suit.compareTo(card.suit);

        return (suitCompare != 0 ? suitCompare : rank.compareTo(card.rank));
    }

    public static int compareCards(Card firstCard, Card secondCard) {
        int cardPairCompare = firstCard.getSuit().compareTo(secondCard.getSuit());

        return (cardPairCompare != 0 ? cardPairCompare : firstCard.getRank().compareTo(secondCard.getRank()));
    }

    private static final List<Card> prototypeDeck = new ArrayList<Card>(52);

    static {
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                prototypeDeck.add(new Card(rank, suit));
            }
        }
    }

    public static List<Card> newDeck(){
        return new ArrayList<Card>(prototypeDeck);
    }

    public static Card getCard(int cardIndex){
        return prototypeDeck.get(cardIndex);
    }


}
