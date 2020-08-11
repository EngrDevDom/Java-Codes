import java.util.Arrays;

public class ModifiedCardDeckApp {
    public static void main(String[] args) {
        System.out.println("DECK");
        String[] deck = getDeck();
//        String[][] hand = new String[4][5];
        displayCards(deck);

        System.out.println("SHUFFLED DECK");
        shuffleDeck(deck);
        displayCards(deck);

        int count = 5;
        System.out.println("HAND OF " + count + " CARDS");
        String[][] hand = loadCards(deck, count);
//        displayHands(hand);
//        loadCards(deck, count);
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

//    private static String[] dealCards(String[] deck, int count) {
//        String[] hand = new String[count];
//        hand = Arrays.copyOfRange(deck, 0, count);
//        return hand;
//    }
    private static String[][] loadCards(String[] deck, int count) {
//        int arr1[] = new int [5];
        //массив только еще заполнить не забудь чем-нибудь, а то NPE схватишь
//        int arr2[][] = new int [5][5];
        int N = 0;
        String[][] hands = new String[4][count];
//        int[] arr = {1, 5, 6, 7, 8, 8, 9, 10};
//        int[][] res = new int[N][];
//        for (int i = 0; i < N; i++) {
//            hands[i] = Arrays.copyOfRange(deck, i * deck.length / N, (i + 1) * deck.length / N);
//            System.out.println(Arrays.deepToString(hands));
//        }
        for (int i = 0; i < hands.length; i++) {
            System.out.print("|");
//            for (int j = 0; j < hands[i].length; j++) {
            for (int j = 0; j < j+1; j++) {
                hands[i][j] = deck[N++]; //перенос элементов из донора в матрицу
                
                System.out.print(hands[i][j] + "| ");
            }
            System.out.println();
        }
        return hands;
//        }
    }
    /*
    private static void displayHands(String[] deck, int count) {
//             add code that displays cards here
        System.out.print("|");
        for (String h[] : hands) {
            System.out.print(h + "|");
        }
        System.out.println();
//        int row, col,n, N;
//        String temp = "";
//        row = 4;
        col = 5;
        N = 0;
        String[][] hands = new String[4][count];
//        Scanner in = new Scanner(System.in);

//        System.out.println("Enter the number of rows");
//        row = in.nextInt();
//
//        System.out.println("Enter the number  columns");
//        col  = in.nextInt();
        if(row < col)
            n = row;
        else
            n = col;
//        int mat1[][] = new int[row][col];
//        String [][] revHands = new String[row][col];
//        System.out.println("Enter the elements of matrix");

//        for (  i= 0 ; i < row ; i++ )
//        {
//
//            for ( j= 0 ; j < col ;j++ )
//                mat1[i][j] = in.nextInt();
//
//        }
//        System.out.println("\n\nOriginal   matrix:-");
//        for (  i= 0 ; i < row ; i++ ) {
//            for ( j= 0 ; j < col; j++ )
//                System.out.print(hands[i][j]+" ");
//            System.out.println();
//        }

//        for (  i= 0 ; i < n; i++ ) {
//            for (j = i + 1; j < n; j++) {
//                temp = hands[i][j];
//                hands[i][j] = hands[j][i];
//                hands[j][i] = temp;
//            }
//        }

//        System.out.println("\n\nTranspose  of   matrix:-");
//        for (  i= 0 ; i < col; i++ ) {
//            for ( j= 0 ; j < row; j++ )
//                System.out.print(hands[i][j]+" ");
//            System.out.println();
//        }

        for (int i = 0; i < hands.length; i++) {
            System.out.print("|");
//            for (int j = 0; j < hands[i].length; j++) {
//                hands[i][j] = deck[i]; //перенос элементов из донора в матрицу
//                System.out.println("|" + deck[j+8] + "|");
//                System.out.print(hands[i][j] + "| ");
//                break;
//            }
//            System.out.println();
        }
    }*/
}

