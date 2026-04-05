/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Sam Kallu kallusa@sheridancollege.ca
 * @author Nathaniel Bachynski bachynsn@sheridancollege.ca
 * 
 * TODO: DEV NOTES - THIS CLASS EXTENDS CARD. 
 * IT COMPOSES THE ENUMS TO FORM A SPECIFIC PLAYING CARD.
 */
public class WarCard extends Card {
    private Suit suit;
    private Number number;

    public WarCard(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }
    
    // CREATE GETTERS FOR SUIT AND NUMBER

    public Suit getSuit() {
        return suit;
    }

    public Number getNumber() {
        return number;
    }

    @Override
    public String toString() {
        // OVERRIDE THIS METHOD TO RETURN A STRING LIKE "ACE of SPADES" OR "TWO of HEARTS"
        return number + " of " + suit;
    }
}
