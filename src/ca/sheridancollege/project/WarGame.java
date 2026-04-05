/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Sam Kallu kallusa@sheridancollege.ca
 */
public class WarGame extends Game {

    // TODO: DEV NOTES - DECLARE THE FOLLOWING PRIVATE ATTRIBUTES EXACTLY AS UML STATES:
    // private int currentRound;
    // private ArrayList<WarCard> cardsOnTable;
    // private boolean tie;

    public WarGame(String name) {
        super(name);
        // TODO: INITIALIZE currentRound TO 0
        // TODO: INITIALIZE cardsOnTable AS A NEW EMPTY ARRAYLIST
        // TODO: INITIALIZE tie TO FALSE
    }

    // TODO: CREATE GETTERS AND SETTERS FOR currentRound

    /**
     * TODO: DEV NOTES - THIS IS THE MAIN LOOP OF THE GAME. 
     * 1. CREATE A STANDARD 52 DECK AND SHUFFLE IT.
     * 2. DEAL 26 CARDS TO PLAYER 1 AND 26 TO PLAYER 2.
     * 3. START A WHILE LOOP: 
     *    LOOP CONDITION: (currentRound < MAX_THRESHOLD) AND (BOTH PLAYERS HAVE > 0 CARDS)
     * 4. INSIDE LOOP:
     *    - GRAB TOP CARD FROM PLAYER 1
     *    - GRAB TOP CARD FROM PLAYER 2
     *    - ADD BOTH CARDS TO 'cardsOnTable'
     *    - CALL Comparing(p1Card, p2Card)
     *    - IF (tie == true) -> CALL resolveWar()
     *    - GIVE EVERYTHING IN 'cardsOnTable' TO THE WINNER
     *    - CALL resetTable()
     *    - INCREMENT currentRound
     * 5. ONCE LOOP ENDS, CALL declareWinner()
     */
    public void startGame() { // Or override play()
        // TODO: IMPLEMENT MAIN GAME LOOP HERE
    }
    
    @Override
    public void play() {
        // TODO: CALL startGame() HERE TO KICK OFF THE GAME
    }
    
    /**
     * TODO: DEV NOTES - COHESION IS VITAL HERE. DO NOT PUT WAR LOOP LOGIC HERE.
     * EVALUATE THE STANDARD 1V1 FLIP.
     * IF P1 WINS: MARK P1 AS WINNER FOR THIS ROUND.
     * IF P2 WINS: MARK P2 AS WINNER FOR THIS ROUND.
     * IF TIE: SIMPLY SET THE 'tie' BOOLEAN FLAG TO TRUE. DO NOTHING ELSE.
     */
    public void Comparing(WarCard p1, WarCard p2) {
        // TODO: COMPARE P1 AND P2 NUMBERS. 
        // TODO: SET tie = TRUE IF THEY ARE EQUAL.
    }

    /**
     * TODO: DEV NOTES - CALLED BY MAIN GAME LOOP WHEN tie == true.
     * 1. EACH PLAYER GRABS 3 CARDS FROM THEIR DECK (IF THEY HAVE ENOUGH)
     * 2. ADD THESE 6 CARDS FACE DOWN TO 'cardsOnTable'
     * 3. PLAYERS REVEAL 1 MORE CARD EACH.
     * 4. COMPARE THESE NEW CARDS (YOU CAN RE-USE Comparing() LOGIC OR EVALUATE HERE).
     * 5. RETURN THE NEW ARRAYLIST (THOUGH BECAUSE YOU MAINTAIN cardsOnTable GLOBALLY, 
     *    YOU CAN ALSO JUST RELY ON THE GLOBAL STATE AS PER YOUR MAINTAINABILITY NOTE).
     */
    public ArrayList<WarCard> resolveWar(WarCard p1, WarCard p2) {
        // TODO: IMPLEMENT WAR LOGIC (3 CARDS DOWN, 1 UP)
        return null;
    }

    /**
     * TODO: DEV NOTES - FETCHES HOW MANY CARDS A PLAYER CURRENTLY HAS.
     * DELEGATES TO THE PLAYER'S WarGroups INSTANCE.
     */
    public int groupSize(WarPlayer player) {
        // TODO: RETURN player.getDeck().getSize() OR SIMILAR
        return 0;
    }

    /**
     * TODO: DEV NOTES - STATE RESET.
     * CLEARS THE 'cardsOnTable' ARRAYLIST SO IT IS EMPTY FOR THE NEXT ROUND.
     * RESETS THE 'tie' BOOLEAN FLAG TO FALSE.
     */
    public void resetTable() {
        // TODO: clear() cardsOnTable AND SET tie = false
    }

    @Override
    public void declareWinner() {
        // TODO: DEV NOTES - EVALUATE WHO WON.
        // CHECK IF A PLAYER HAS 52 CARDS, OR IF ROUND LIMIT HIT, CHECK WHO HAS HIGHER groupSize().
        // PRINT OUT THE WINNER CLEARLY TO THE CONSOLE.
    }
}