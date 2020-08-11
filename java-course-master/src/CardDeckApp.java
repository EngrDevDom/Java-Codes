import java.util.Arrays;

public class CardDeckApp {
    public static void main(String[] args) {
        System.out.println("DECK");
        String[] deck = getDeck();
        displayCards(deck);

        System.out.println("SHUFFLED DECK");
        shuffleDeck(deck);
        displayCards(deck);

        int count = 5;
        System.out.println("HAND OF " + count + " CARDS");
        String[] hand = dealCards(deck, count);
        displayCards(hand);
    }

    private static String[] getDeck() {
        String[] deck = new String[52];
        // add code that creates deck here
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "Jack", "Queen", "King"};

        int i = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[i] = rank + " of " + suit;
                i++;
            }
        }
        return deck;
    }

    private static void displayCards(String[] cards) {
        // add code that displays cards here
        System.out.print("|");
        for (String card : cards) {
            System.out.print(card + "|");
        }
        System.out.println();
    }

    private static void shuffleDeck(String[] deck) {
//        int randomIndex = (int) (Math.random() * deck.length-1);
        int randomIndex = 1;

        // add code that shuffles the deck here
        for (int i = 0; i < deck.length; i++) {
            String savedCard = deck[i];
            randomIndex = (int) (Math.random() * deck.length - 1);
            deck[i] = deck[randomIndex];
            deck[randomIndex] = savedCard;
        }
    }

    private static String[] dealCards(String[] deck, int count) {
//        String[] hand = new String[count];
        String[] hand = Arrays.copyOfRange(deck, 0, count);
        return hand;
    }
}
