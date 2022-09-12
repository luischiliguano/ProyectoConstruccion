/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;

/**
 *
 * @author User
 */
public class Score {
    private int value;
    private int numberItem;
    private int playerID;
    private String dateGame;
    private String game;

    public Score() {
    }

    public Score(int value, int playerID, String date, String game) {
        this.value = value;
        //this.number = number;
        this.playerID = playerID;
        this.dateGame = date;
        this.game = game;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumber() {
        return numberItem;
    }

    public void setNumber(int number) {
        this.numberItem = number;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getDate() {
        return dateGame;
    }

    public void setDate(String date) {
        this.dateGame = date;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

   
    
    
    
}
