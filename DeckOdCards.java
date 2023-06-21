import java.util.*;

class DeckOfCards {
    private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static void main(String[] args) {
        String[][] deck = initializeDeck();
        shuffleDeck(deck);
        String[][] players = distributeCards(deck, 4, 9);
        printPlayersCards(players);
    }

    private static String[][] initializeDeck() {
        String[][] deck = new String[suits.length * ranks.length][2];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index][0] = suit;
                deck[index][1] = rank;
                index++;
            }
        }

        return deck;
    }

    private static void shuffleDeck(String[][] deck) {
        Random random = new Random();

        for (int i = 0; i < deck.length; i++) {
            int j = random.nextInt(deck.length);
            swap(deck, i, j);
        }
    }

    private static void swap(String[][] deck, int i, int j) {
        String[] temp = deck[i];
        deck[i] = deck[j];
        deck[j] = temp;
    }

    private static String[][] distributeCards(String[][] deck, int numPlayers, int cardsPerPlayer) {
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;

        for (int i = 0; i < cardsPerPlayer; i++) {
            for (int j = 0; j < numPlayers; j++) {
                players[j][i] = deck[cardIndex][0] + " " + deck[cardIndex][1];
                cardIndex++;
            }
        }

        return players;
    }

    private static void printPlayersCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
            System.out.println();
        }
    }
}
