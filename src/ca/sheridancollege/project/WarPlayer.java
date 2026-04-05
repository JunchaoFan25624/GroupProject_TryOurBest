/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Sam Kallu kallusa@sheridancollege.ca
 * 
 * TODO: DEV NOTES - EXTENDS Player. 
 * REPRESENTS A SINGLE PLAYER IN THE WAR GAME. 
 * STRICT 1-TO-1 COMPOSITION WITH WarGroups.
 */

public class WarPlayer extends Player {

    // DECLARE A PRIVATE WarGroups ATTRIBUTE (E.G., private WarGroups deck;)
    // THIS REPRESENTS THE PLAYER'S PERSONAL HAND/DECK.
    private WarGroups deck;
    
    public WarPlayer(String name) {
        super(name);
        deck = new WarGroups(0);
    }

    /**
     * TODO: DEV NOTES - ADDS WON CARDS TO THE BOTTOM OF THE DECK.
     * CALLS THE UNDERLYING WarGroups OBJECT TO ADD THE CARD.
     */
    public void addCard(WarCard card) {
        // TODO: IMPLEMENT ADDING CARD LOGIC
        deck.addCard(card);
    }
    
    public WarGroups getDeck() {
        return deck;
    }
    
    @Override
    public void play() {
        // IMPLEMENT ANY PLAYER SPECIFIC PLAY LOGIC IF NEEDED.
        // IN WAR, THIS MIGHT JUST BE TRIGGERING THEIR DECK TO grabCard(0).
    }
}