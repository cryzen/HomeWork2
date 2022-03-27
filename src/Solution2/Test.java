package Solution2;

public class Test {
    public static void main(String[] args){
        System.out.println(Card.newDeck());

        System.out.println();

        System.out.println(Card.getCard(12).compareTo(Card.getCard(13)));
        System.out.println(Card.getCard(13).compareTo(Card.getCard(12)));
        System.out.println(Card.getCard(13).compareTo(Card.getCard(13)));

        System.out.println();

        System.out.println(Card.compareCards(Card.getCard(12), Card.getCard(13)));
        System.out.println(Card.compareCards(Card.getCard(13), Card.getCard(12)));
        System.out.println(Card.compareCards(Card.getCard(13), Card.getCard(13)));

        System.out.println();

        System.out.println(Card.getCard(3).checkRank(Card.getCard(2)));
        System.out.println(Card.getCard(2).checkRank(Card.getCard(3)));
        System.out.println(Card.getCard(3).checkRank(Card.getCard(3)));
    }
}
