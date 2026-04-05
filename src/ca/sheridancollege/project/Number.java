/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Sam Kallu kallusa@sheridancollege.ca
 * 
 * TODO: DEV NOTES - THIS IS THE NUMBER ENUMERATION AS DEFINED IN THE DESIGN DOC.
 * IT REPLACES RAW STRINGS/INTEGERS TO ENSURE LOOSE COUPLING.
 */
public enum Number {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
    
    private final int value;

    private Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}