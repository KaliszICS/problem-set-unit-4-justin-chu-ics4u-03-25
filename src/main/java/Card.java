/**
 * @author JUSTIN CCHU
 * @version 69
 * @since 2025-05-01
 */
public class Card {
    private String name;
    private String suit;
    private int value;

    // INSTANCE VARS (UP)
    // CONSTRUCTORS

    /**
     * Create card with a name, suit, and value.
     *
     * @param name of the card, e.g. "2".
     * @param suit of the card, e.g. "Spades".
     * @param value of the card, e.g. 2.
     */
    public Card(String name, String suit, int value) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }

        else {
            this.name = "Unknown Name";
        }

        if (suit != null && !suit.isEmpty()) {
            this.suit = suit;
        }

        else {
            this.suit = "No Suit";
        }

        this.value = value;
    }

    /**
     * Create a card with just a name and suit. Value defaults to 0.
     *
     * @param name of the card, e.g. "2".
     * @param suit of the card, e.g. "Spades".
     */
    public Card(String name, String suit) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }

        else {
            this.name = "Unknown Name";
        }

        if (suit != null && !suit.isEmpty()) {
            this.suit = suit;
        }

        else {
            this.suit = "No Suit";
        }

        this.value = 0;
    }

    /**
     * Create a card with just a name and value. Suit defaults to "No Suit".
     *
     * @param name of the card, e.g. "Joker".
     * @param value of the card, e.g. "14".
     */
    public Card(String name, int value) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }

        else {
            this.name = "Unknown Name";
        }

        this.suit = "No Suit";
        this.value = value;
    }

    /**
     * Create a card with only a name. Suit defaults to "No Suit" and value to 0.
     *
     * @param name of the card, e.g. "King".
     */
    public Card(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }

        else {
            this.name = "Unknown Name";
        }

        this.suit = "No Suit";
        this.value = 0;
    }

    /**
     * Creates a default card, "Unknown Name of No Suit" with value 0.
     *
     */
    public Card() {
        this.name = "Unknown Name";
        this.suit = "No Suit";
        this.value = 0;
    }

    // GETTERS

    /**
     * @return the name of the card.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the suit of the card.
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @return number value of the card.
     */
    public int getValue() {
        return value;
    }

    // METHODS

    /**
     * This method gives you the card in a formatted way.
     *
     * @return a string representing the card.
     */
    @Override
    public String toString() {
        return name + " of " + suit;
    }

    /**
     * This method checks if two cards have the same name, suit, and value.
     *
     * @param obj is the other card you're comparing this one to.
     * @return true if the cards have the same name, suit, and value, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Card other = (Card) obj;

        return value == other.value && name.equals(other.name) && suit.equals(other.suit);
    }
} 