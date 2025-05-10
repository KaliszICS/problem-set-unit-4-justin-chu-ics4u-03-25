import java.util.ArrayList;

/**
 * @author JUSTIN CHU
 * @version 69
 * @since 2025-05-01
 */
public class DiscardPile {
    private ArrayList<Card> discardedCards;

    // INSTANCE VAR (UP)
    // CONSTRUCTORS

    /**
     * Creates a new empty discard pile.
     */
    public DiscardPile() {
        this.discardedCards = new ArrayList<>();
    }

    /**
     * Create a discard pile with cards already in it, given an array of cards.
     * Takes null arrays or null cards within the array into account, leading to an empty or partially filled pile.
     *
     * @param initialCards array of Card objects to start the discard pile with. Creates an empty pile if null or all cards are null.
     */
    public DiscardPile(Card[] initialCards) {
        this.discardedCards = new ArrayList<>();
        if (initialCards != null) {
            for (int i = 0; i < initialCards.length; i++) {
                if (initialCards[i] != null) {
                    this.discardedCards.add(initialCards[i]);
                }
            }
        }
    }

    /**
     * Same thing as above but for an arraylist.
     *
     * @param initialCardsList list of Card objects to initialize the discard pile.
     */
    public DiscardPile(ArrayList<Card> initialCardsList) {
        this.discardedCards = new ArrayList<>();
        if (initialCardsList != null) {
            for (int i = 0; i < initialCardsList.size(); i++) {
                if (initialCardsList.get(i) != null) {
                    this.discardedCards.add(initialCardsList.get(i));
                }
            }
        }
    }

    // GETTERS

    /**
     * @return an array of Card objects that are in the discard pile.
     */
    public Card[] getDiscardPile() {
        return discardedCards.toArray(new Card[0]);
    }

    /**
     * @return the number of cards currently in the discard pile.
     */
    public int size() {
        return discardedCards.size();
    }

    // METHODS

    /**
     * Adds the given card to the pile.
     * If you add a "null" card, it won't add it.
     *
     * @param card to add to the discard pile.
     */
    public void addCard(Card card) {
        if (card != null) {
            discardedCards.add(card);
        }
    }

    /**
     * Takes out a specific card in the discard pile
     * It will search for it, remove it if found, and then return it to you.
     * If the card isn't there, it'll just return null.
     *
     * @param card you want to remove from the discard pile.
     * @return the removed Card, or null if the card wasn't found in the pile.
     */
    public Card removeCard(Card card) {
        if (card != null && discardedCards.remove(card)) {
            return card;
        }
        return null;
    }

    /**
     * Clears the entire discard pile and gives all the cards back.
     * If the pile was already empty, you'll just get an empty array.
     *
     * @return an array containing all the cards that were removed from the discard pile.
     */
    public Card[] removeAll() {
        Card[] allCards = discardedCards.toArray(new Card[0]);
        discardedCards.clear();
        return allCards;
    }

    /**
     * Looks at all the cards in the discard pile.
     * Gives you a string listing them out.
     * If the pile is empty, it'll just say it's empty.
     *
     * @return a string representation of all cards in the discard pile, separated by commas.
     */
    @Override
    public String toString() {
        if (discardedCards.isEmpty()) {
            return "The discard pile is empty.";
        }

        String result = "";
        for (int i = 0; i < discardedCards.size(); i++) {
            result += discardedCards.get(i).toString();
            if (i < discardedCards.size() - 1) {
                result += ", ";
            }
        }
        result += ".";
        return result;
    }
} 