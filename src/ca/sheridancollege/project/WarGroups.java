/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Sam Kallu kallusa@sheridancollege.ca
 * 
 * TODO: DEV NOTES - EXTENDS GroupOfCards. 
 * ACTS AS THE PERSONAL DECK/HAND FOR A WAR PLAYER. 
 * HANDLES LIST MANAGEMENT SO WarGame DOES NOT HAVE TO (DELEGATION).
 */
public class WarGroups extends GroupOfCards {
    
    public WarGroups(int size) {
        super(size);
    }

    /**
     * TODO: DEV NOTES - AS PER DESIGN, THIS METHOD DELEGATES LIST MANAGEMENT.
     * IT MUST ACCEPT AN INDEX (number: int), REMOVE THE CARD AT THAT INDEX 
     * FROM THE ARRAYLIST, AND RETURN IT TO BE PLAYED ON THE TABLE.
     * 
     * HINT: REMEMBER TO CAST THE RETURNED CARD TO WarCard SINCE GroupOfCards USES Generic Card!
     * 
     * @param number The index of the card to grab (usually 0 for the top card)
     * @return WarCard The card pulled from the player's deck
     */
    public WarCard grabCard(int number) {
        // IMPLEMENT REMOVAL AND RETURN OF CARD AT INDEX 'number'
        Card targetCard = getCards().remove(number);
        return (WarCard) targetCard;
    }
    
    // YOU WILL ALSO LIKELY NEED AN addCard(WarCard c) METHOD HERE TO 
    // ADD WON CARDS TO THE BOTTOM OF THIS PLAYER'S DECK.
    public void addCard(WarCard card) {
        getCards().add(card);
    }
}
