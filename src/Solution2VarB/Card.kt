package Solution2VarB

class Card private constructor(private val rank: Rank, private val suit: Suit){
    enum class Rank {
        deuce, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace
    }

    enum class Suit {
        clubs, diamonds, spades, hearts
    }

    override fun toString(): String {
        return "$rank of $suit"
    }

    fun checkDeckMemberShip(card: Card): String {
        return if (card.suit == suit) {
            "The card belongs to the deck"
        } else {
            "The card does not belong to the deck"
        }
    }

    fun checkRank(card: Card): String {
        return if (card.suit == suit && rank > card.rank) {
            "The rank of this card is higher"
        } else if (card.suit == suit && rank < card.rank) {
            "The rank of this card is lower"
        } else if (card.suit == suit) {
            "Card ranks are the same"
        } else {
            "Cards do not match"
        }
    }

    operator fun compareTo(card: Card): Int {
        val suitCompare = suit.compareTo(card.suit)
        return if (suitCompare != 0) suitCompare else rank.compareTo(card.rank)
    }

    companion object {

        fun compareCards(firstCard: Card, secondCard: Card): Int {
            val cardPairCompare = firstCard.suit.compareTo(secondCard.suit)
            return if (cardPairCompare != 0) cardPairCompare else firstCard.rank.compareTo(
                secondCard.rank
            )
        }

        private val prototypeDeck = mutableListOf<Card>();

        init {
            for (suit in Suit.values()) {
                for (rank in Rank.values()) {
                    prototypeDeck.add(Card(rank, suit))
                }
            }
        }

        fun newDeck(): List<Card> {
            return prototypeDeck
        }

        fun getCard(cardIndex: Int): Card {
            return prototypeDeck[cardIndex]
        }
    }
}

fun main(){
    println(Card.newDeck())

    println()

    println(Card.getCard(12).compareTo(Card.getCard(13)));
    println(Card.getCard(13).compareTo(Card.getCard(12)));
    println(Card.getCard(13).compareTo(Card.getCard(13)));

    println();

    println(Card.compareCards(Card.getCard(12), Card.getCard(13)));
    println(Card.compareCards(Card.getCard(13), Card.getCard(12)));
    println(Card.compareCards(Card.getCard(13), Card.getCard(13)));

    println();

    println(Card.getCard(3).checkRank(Card.getCard(2)));
    println(Card.getCard(2).checkRank(Card.getCard(3)));
    println(Card.getCard(3).checkRank(Card.getCard(3)));
}