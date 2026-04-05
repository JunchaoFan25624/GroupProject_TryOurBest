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
 * @author Nathaniel Bachynski bachynsn@sheridancollege.ca
 * @author Junchao Fan fanjun@sheridancollege.ca
 * @author Rongjun Zhang zharongj@sheridancollege.ca
 */
public class WarGame extends Game {

    private WarPlayer player1;
    private WarPlayer player2;
    private int currentRound;
    private ArrayList<WarCard> cardsOnTable;
    private boolean tie;
    private boolean gameOver;
    private final int MAX_THRESHOLD = 10000;

    public WarGame(String name) {
        super(name);
        currentRound = 0;
        cardsOnTable = new ArrayList<WarCard>();
        tie = false;
        gameOver = false;
    }

    // CREATE GETTERS AND SETTERS FOR currentRound

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }
    
    public void startGame() {
        
        // Create players
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1 Name: ");
        String p1Name = sc.nextLine();
        System.out.println("Player 2 Name: ");
        String p2Name = sc.nextLine();
        player1 = new WarPlayer(p1Name);
        player2 = new WarPlayer(p2Name);
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
            WarGroups playerDeck = ((WarPlayer) getPlayers().get(index % 2)).getDeck();
            playerDeck.addCard((WarCard) c);
            index++;
        }
        
        // Start the round
        while((currentRound < MAX_THRESHOLD) 
                && player1.getDeck().getSize() > 0 
                && player2.getDeck().getSize() > 0
                && !gameOver) {
            
            WarCard p1Card = ((WarPlayer) getPlayers().get(0)).getDeck().grabCard(0);
            WarCard p2Card = ((WarPlayer) getPlayers().get(1)).getDeck().grabCard(0);
            cardsOnTable.add(p1Card);
            cardsOnTable.add(p2Card);
            
            System.out.println("\nRound " + (currentRound + 1));
            System.out.println(player1.getName() + " deck size: " + (player1.getDeck().getSize()+1));
            System.out.println(player2.getName() + " deck size: " + (player2.getDeck().getSize()+1));
            
            //call comparing
            comparing(p1Card, p2Card);
            
            //check tie status
            if (tie) {
                //if true, start the war
                resolveWar(p1Card, p2Card);
            } else {
                //check which card is larger and display
                if (p1Card.getNumber().getValue() > p2Card.getNumber().getValue()) {
                    for (WarCard card : cardsOnTable) {
                        player1.addCard(card);
                    }
                    System.out.println(player1.getName() + " wins this round");
                } else {
                    for (WarCard card : cardsOnTable) {
                        player2.addCard(card);
                    }
                    System.out.println(player2.getName() + " wins this round");
                }
            }
            
            System.out.println("Cards on table: " + cardsOnTable.size());
            
            System.out.println(player1.getName() + " deck size: " + player1.getDeck().getSize());
            System.out.println(player2.getName() + " deck size: " + player2.getDeck().getSize());

            resetTable();
            currentRound++;
        }
        
        // Call declareWinner
        declareWinner();
    }
    
    @Override
    public void play() {
        startGame();
    }
    
    
    public void comparing(WarCard p1, WarCard p2) {
        // show cards from the player
        System.out.println(player1.getName() + " : " + p1);
        System.out.println(player2.getName() + " : " + p2);
        
        // check tie
        if (p1.getNumber().getValue() == p2.getNumber().getValue()) {
            tie = true;
            System.out.println("War occurs");
            System.out.println("Each player grab 3 crads and put them on the table");
        } else {
            tie = false;
        }
    }


    public void resolveWar(WarCard p1, WarCard p2) {
        // if one of the players do not have enough card to start the war
        while (tie) {
            if (player1.getDeck().getSize() < 4 || player2.getDeck().getSize() < 4) {
                System.out.println("One player does not have enough cards for war.");
                tie = false;
                gameOver = true;
                return;
            }

        // 3 face-down cards each
        for (int i = 0; i < 3; i++) {
            cardsOnTable.add(player1.getDeck().grabCard(0));
            cardsOnTable.add(player2.getDeck().grabCard(0));
        }

        // 1 face-up card each
        WarCard p1NewCard = player1.getDeck().grabCard(0);
        WarCard p2NewCard = player2.getDeck().grabCard(0);

        cardsOnTable.add(p1NewCard);
        cardsOnTable.add(p2NewCard);
        comparing(p1NewCard, p2NewCard);
        
        // compare the number of cards and check if there is a new war or not
        if (!tie) {
            if (p1NewCard.getNumber().getValue() > p2NewCard.getNumber().getValue()) {
                for (WarCard card : cardsOnTable) {
                    player1.addCard(card);
                }
                System.out.println(player1.getName() + " wins the war.");
            } else {
                for (WarCard card : cardsOnTable) {
                    player2.addCard(card);
                }
                System.out.println(player2.getName() + " wins the war.");
            }
            return;
        } else {
            System.out.println("WAR again!");
        }
    }
}

    //HOW MANY CARDS A PLAYER CURRENTLY HAS.
    public int groupSize(WarPlayer player) {
        return player.getDeck().getSize();
    }

    //CLEARS THE 'cardsOnTable' ARRAYLIST SO IT IS EMPTY FOR THE NEXT ROUND.
    public void resetTable() {
        cardsOnTable.clear();
        tie = false;
    }

    @Override
    public void declareWinner() {
        //EVALUATE WHO WON.
        int p1Size = groupSize(player1);
        int p2Size = groupSize(player2);
        
        // CHECK IF A PLAYER HAS 52 CARDS, OR IF ROUND LIMIT HIT, CHECK WHO HAS HIGHER groupSize().
        if (p1Size == 52 || p2Size == 0) {
            System.out.println(player1.getName() + " Wins");
        } else if (p2Size == 52 || p1Size == 0) {
            System.out.println(player2.getName() + " Wins");
        } else if (p1Size > p2Size) {
            System.out.println(player1.getName() + " Wins");
        } else if (p2Size > p1Size) {
            System.out.println(player2.getName() + " Wins");
        } else {
            System.out.println("The game is a tie.");
        }
    }
}
