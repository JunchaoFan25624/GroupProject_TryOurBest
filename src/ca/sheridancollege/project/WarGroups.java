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
 * EXTENDS GroupOfCards. 
 * ACTS AS THE PERSONAL DECK/HAND FOR A WAR PLAYER. 
 */
public class WarGroups extends GroupOfCards {
    
    public WarGroups(int size) {
        super(size);
    }

    
//     number: The index of the card to grab
//     return WarCard The card pulled from the player's deck
    
    public WarCard grabCard(int number) {
        // IMPLEMENT REMOVAL AND RETURN OF CARD AT INDEX 'number'
        Card targetCard = getCards().remove(number);
        setSize(getSize()-1);
        return (WarCard) targetCard;
    }
    

    // ADD WON CARDS TO THE BOTTOM OF THIS PLAYER'S DECK.
    public void addCard(WarCard card) {
        getCards().add(card);
        setSize(getSize()+1);
    }
}
