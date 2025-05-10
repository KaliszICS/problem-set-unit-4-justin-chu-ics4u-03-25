import java.util.ArrayList;

/**
 * @author JUSTIN CHU
 * @version 69
 * @since 2025-05-01
 */
public class Player {
    private String name;
    private int age;
    private ArrayList<Card> hand;

    // INSTANCE VARS (UP)
    // CONSTRUCTORS

    /**
     * Creates a new player with a name, age, and a starting hand of cards.
     *
     * @param name of the player, e.g. "Justin".
     * @param age of the player. If negative, will be set to 0.
     * @param initialHand array of Card objects to start the player's hand with.
     */
    public Player(String name, int age, Card[] initialHand) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }

        else {
            this.name = "Unknown Player";
        }

        if (age >= 0) {
            this.age = age;
        }

        else {
            this.age = 0;
        }

        this.hand = new ArrayList<>();
        if (initialHand != null) {
            for (int i = 0; i < initialHand.length; i++) {
                if (initialHand[i] != null) {
                    this.hand.add(initialHand[i]);
                }
            }
        }
    }

    /**
     * Creates a new player with a name and age, but an empty hand.
     *
     * @param name of the player.
     * @param age of the player. If negative, will be set to 0.
     */
    public Player(String name, int age) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }

        else {
            this.name = "Unknown Player";
        }

        if (age >= 0) {
            this.age = age;
        }

        else {
            this.age = 0;
        }

        this.hand = new ArrayList<>();
    }

    /**
     * Creates a new player with a name and initial hand, but default age (0).
     *
     * @param name of the player.
     * @param initialHand array of Card objects to start with.
     */
    public Player(String name, Card[] initialHand) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }

        else {
            this.name = "Unknown Player";
        }

        this.age = 0;

        this.hand = new ArrayList<>();
        if (initialHand != null) {
            for (int i = 0; i < initialHand.length; i++) {
                if (initialHand[i] != null) {
                    this.hand.add(initialHand[i]);
                }
            }
        }
    }

    /**
     * Creates a new player with just a name.
     *
     * @param name of the player.
     */
    public Player(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }

        else {
            this.name = "Unknown Player";
        }

        this.age = 0;
        this.hand = new ArrayList<>();
    }

    /**
     * Creates a new player with just an age.
     *
     * @param age of the player. If negative, will be set to 0.
     */
    public Player(int age) {
        this.name = "Unknown Player";

        if (age >= 0) {
            this.age = age;
        }

        else {
            this.age = 0;
        }

        this.hand = new ArrayList<>();
    }

    /**
     * Creates a default player.
     * They will have the name "Unknown Player", age 0, and an empty hand.
     */
    public Player() {
        this.name = "Unknown Player";
        this.age = 0;
        this.hand = new ArrayList<>();
    }

    // GETTERS

    /**
     * @return the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the age of the player.
     */
    public int getAge() {
        return age;
    }

    /**
     * @return an array of Card objects currently in the player's hand.
     */
    public Card[] getHand() {
        return hand.toArray(new Card[0]);
    }

    /**
     * @return thenumber of cards in the player's hand.
     */
    public int size() {
        return hand.size();
    }

    // METHODS

    /**
     * Takes a card from the specified deck and adds it to the player's hand.
     * If the deck is empty, no card is drawn.
     *
     * @param deck where the player will draw a card.
     */
    public void draw(Deck deck) {
        if (deck != null) {
            Card drawnCard = deck.draw();
            if (drawnCard != null) {
                hand.add(drawnCard);
            }
        }
    }

    /**
     * Discards a player's card.
     * Removes the specified card from their hand and adds it to the given discard pile.
     * Tells you if it was successful (e.g. if the player actually had that card).
     *
     * @param card the player wants to discard from their hand.
     * @param discardPile where the card will be placed.
     * @return true if the card was successfully found in the hand and discarded, false otherwise.
     */
    public boolean discardCard(Card card, DiscardPile discardPile) {
        if (card != null && discardPile != null && hand.remove(card)) {
            discardPile.addCard(card);
            return true;
        }
        return false;
    }

    /**
     * Returns a card to the deck instead of discarding it.
     * Attempts to remove the specified card from the player's hand and add it back to the given deck.
     *
     * @param card the player wants to return from their hand to the deck.
     * @param deck where the card will be returned.
     * @return true if the card was found in the hand and returned to the deck, false otherwise.
     */
    public boolean returnCard(Card card, Deck deck) {
        if (card != null && deck != null && hand.remove(card)) {
            deck.addCard(card);
            return true;
        }
        return false;
    }

    /**
     * Shows what the player is holding.
     * Prints out their name, age, and a list of cards in their hand.
     * e.g. "Justin Chu, 18, Ace of Hearts, King of Spades."
     *
     * @return a string describing the player and their current hand.
     */
    @Override
    public String toString() {
        String handString = "";
        if (hand.isEmpty()) {
            handString = "empty hand";
        }

        else {
            for (int i = 0; i < hand.size(); i++) {
                handString += hand.get(i).toString();
                if (i < hand.size() - 1) {
                    handString += ", ";
                }
            }
        }

        return name + ", " + age + ", " + handString + ".";
    }
}