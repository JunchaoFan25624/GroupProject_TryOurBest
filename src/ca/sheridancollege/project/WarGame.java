/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sam Kallu kallusa@sheridancollege.ca
 */
public class WarGame extends Game {

    // DEV NOTES - DECLARE THE FOLLOWING PRIVATE ATTRIBUTES EXACTLY AS UML STATES:
    private int currentRound;
    private ArrayList<WarCard> cardsOnTable;
    private boolean tie;
    private final int MAX_THRESHOLD = 0;

    public WarGame(String name) {
        super(name);
        // INITIALIZE currentRound TO 0
        // INITIALIZE cardsOnTable AS A NEW EMPTY ARRAYLIST
        // INITIALIZE tie TO FALSE
        currentRound = 0;
        cardsOnTable = new ArrayList<WarCard>();
        tie = false;
    }

    // CREATE GETTERS AND SETTERS FOR currentRound

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

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
        
        // Create players
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1 Name: ");
        String p1Name = sc.nextLine();
        System.out.println("Player 2 Name: ");
        String p2Name = sc.nextLine();
        WarPlayer player1 = new WarPlayer(p1Name);
        WarPlayer player2 = new WarPlayer(p2Name);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        setPlayers(players);
        // Make standard deck and shuffle
        GroupOfCards deck = new GroupOfCards(52);
        
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                deck.getCards().add(new WarCard(suit, number));
            }
        }
        
        deck.shuffle();
        // Deal cards to players
        int index = 0;
        for (Card c : deck.getCards()) {
            ((WarPlayer) getPlayers().get(index % 2)).getDeck().addCard((WarCard) c);
            index++;
        }
        // Start while loop
        while((currentRound < MAX_THRESHOLD) && (((WarPlayer) getPlayers().get(0)).getDeck().getSize() > 0) && ((WarPlayer) getPlayers().get(1)).getDeck().getSize() > 0) {
            WarCard p1Card = ((WarPlayer) getPlayers().get(0)).getDeck().grabCard(0);
            WarCard p2Card = ((WarPlayer) getPlayers().get(1)).getDeck().grabCard(1);
            cardsOnTable.add(p1Card);
            cardsOnTable.add(p2Card);
            
            comparing(p1Card, p2Card);
            if (tie == true) {
                resolveWar(p1Card, p2Card);
            }
            
            // HERE: give everything to winner. Depends if comparing is void 
            
            resetTable();
            currentRound++;
        }
        
        // Call declareWinner
        declareWinner();
    }
    
    @Override
    public void play() {
        // CALL startGame() HERE TO KICK OFF THE GAME
        startGame();
    }
    
    /**
     * TODO: DEV NOTES - COHESION IS VITAL HERE. DO NOT PUT WAR LOOP LOGIC HERE.
     * EVALUATE THE STANDARD 1V1 FLIP.
     * IF P1 WINS: MARK P1 AS WINNER FOR THIS ROUND.
     * IF P2 WINS: MARK P2 AS WINNER FOR THIS ROUND.
     * IF TIE: SIMPLY SET THE 'tie' BOOLEAN FLAG TO TRUE. DO NOTHING ELSE.
     */
    public void comparing(WarCard p1, WarCard p2) {
        // COMPARE P1 AND P2 NUMBERS. 
        // SET tie = TRUE IF THEY ARE EQUAL.
        if(p1.getNumber().getValue() > p2.getNumber().getValue()) {
            
        }
        else if(p1.getNumber().getValue() < p2.getNumber().getValue()) {
            
        }
        else {
            tie = true;
        }
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
     * DEV NOTES - FETCHES HOW MANY CARDS A PLAYER CURRENTLY HAS.
     * DELEGATES TO THE PLAYER'S WarGroups INSTANCE.
     */
    public int groupSize(WarPlayer player) {
        return player.getDeck().getSize();
    }

    /**
     * TODO: DEV NOTES - STATE RESET.
     * CLEARS THE 'cardsOnTable' ARRAYLIST SO IT IS EMPTY FOR THE NEXT ROUND.
     * RESETS THE 'tie' BOOLEAN FLAG TO FALSE.
     */
    public void resetTable() {
        cardsOnTable.clear();
        tie = false;
    }

    @Override
    public void declareWinner() {
        // TODO: DEV NOTES - EVALUATE WHO WON.
        // CHECK IF A PLAYER HAS 52 CARDS, OR IF ROUND LIMIT HIT, CHECK WHO HAS HIGHER groupSize().
        // PRINT OUT THE WINNER CLEARLY TO THE CONSOLE.
        if(groupSize((WarPlayer) getPlayers().get(0)) == 52) {
           System.out.println(getPlayers().get(0).getName() + " Wins");
        }
        else if(groupSize((WarPlayer) getPlayers().get(1)) == 52) {
           System.out.println(getPlayers().get(1).getName() + " Wins");
        }
        
    }
}