package com.encryptedcation.tankstars;

import java.io.Serializable;

public class SavedGame implements Serializable {
    // save the game state using json serialization and deserialization
    // save player position, health, fuel
    private static final long serialVersionUID = 1L;
    private Player p1;
    private Player p2;
    private int turn;

    public SavedGame(Player p1,Player p2, int turn) {
        this.player1 = p1;
        this.player2 = p2;
        this.turn = turn;
    }

    public Player getPlayer1() {
        return p1;
    }

    public void setPlayer1(Player player1) {
        this.p1 = player1;
    }

    public Player getPlayer2() {
        return p2;
    }

    public void setPlayer2(Player player2) {
        this.p2 = player2;
    }

    public int getTurn(){
        return this.turn;
    }

    public void setTurn(int turn){
        this.turn = turn;
    }

}
