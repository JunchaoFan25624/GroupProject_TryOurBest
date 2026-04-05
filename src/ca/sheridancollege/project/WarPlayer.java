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
 * EXTENDS Player. 
 */

public class WarPlayer extends Player {

    // THIS REPRESENTS THE PLAYER'S PERSONAL HAND/DECK.
    private WarGroups deck;
    
    public WarPlayer(String name) {
        super(name);
        deck = new WarGroups(0);
    }

//TODO: DEV NOTES - ADDS WON CARDS TO THE BOTTOM OF THE DECK.

    public void addCard(WarCard card) {
        deck.addCard(card);
    }
    
    public WarGroups getDeck() {
        return deck;
    }
    
    @Override
    public void play() {
    }
}