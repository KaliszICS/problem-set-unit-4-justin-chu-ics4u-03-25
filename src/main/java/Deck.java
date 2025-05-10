import java.util.ArrayList;
import java.util.Random;

/**
 * @author JUSTIN CHU
 * @version 69
 * @since 2025-05-01
 */
public class Deck {
    private ArrayList<Card> cards;

    // INSTANCE VAR (UP)
    // CONSTRUCTORS

    /**
     * Sets up unshuffled deck of 52 cards, Ace through King, for Hearts, Clubs, Diamonds, and Spades (suits in that order).
     */
    public Deck() {
        this.cards = new ArrayList<>();
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        for (int s = 0; s < suits.length; s++) {
            for (int i = 0; i < names.length; i++) {
                this.cards.add(new Card(names[i], suits[s], values[i]));
            }
        }
    }

    /**
     * Use this constructor if you already have an array of cards that you want to use.
     * Give the array of cards, if the array is null or some cards in it are null,
     * they are just skipped, resulting in an empty or semi-filled deck.
     *
     * @param initialCards array of Card objects that will make up this deck. Empty deck is created if null or all cards are null.
     */
    public Deck(Card[] initialCards) {
        this.cards = new ArrayList<>();
        if (initialCards != null) {
            for (int i = 0; i < initialCards.length; i++) {
                if (initialCards[i] != null) {
                    this.cards.add(initialCards[i]);
                }
            }
        }
    }

    /**
     * Constructor for arraylist of cards
     * Same as the array version, but for an arraylist.
     *
     * @param initialCardsList of Card objects to form the deck.
     */
    public Deck(ArrayList<Card> initialCardsList) {
        this.cards = new ArrayList<>();
        if (initialCardsList != null) {
            for (int i = 0; i < initialCardsList.size(); i++) {
                if (initialCardsList.get(i) != null) {
                    this.cards.add(initialCardsList.get(i));
                }
            }
        }
    }

    // GETTERS

    /**
     * @return the current number of cards in the deck.
     */
    public int size() {
        return cards.size();
    }

    // METHODS

    /**
     * This takes the top card (index 0, beginning) off the deck and gives it to you.
     * If the deck is empty, it returns null.
     *
     * @return the card that was drawn from the top of the deck, or null if deck is empty.
     */
    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    /**
     * Shuffles the cards in the deck randomly.
     * SOURCES I USED TO HELP - https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/ AND https://www.geeksforgeeks.org/generating-random-numbers-in-java/
     */
    public void shuffle() {
        // Collections.shuffle(cards); // not allowed :(
        int n = cards.size();
        Random random = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    /**
     * Adds a card to the deck.
     * The card will be added to the "bottom" of the deck (end of the list).
     * Takes into account for null cards.
     *
     * @param card you want to add to the deck.
     */
    public void addCard(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    /**
     * Takes an array of cards, adds them to the current deck, then shuffles it.
     *
     * @param newCards array of Card objects to be added to the deck.
     */
    public void reshuffle(Card[] newCards) {
        if (newCards != null) {
            for (int i = 0; i < newCards.length; i++) {
                Card card = newCards[i];
                if (card != null) {
                    this.cards.add(card);
                }
            }
        }
        shuffle();
    }
}