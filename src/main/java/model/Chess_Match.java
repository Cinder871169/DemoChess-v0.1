/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author user
 */
public class Chess_Match implements Serializable{
    private int id;
    private String result;
    private String opponentName;
    private float eloGain;
    private float elo;
    private int tblMatchId;
    private int tblChessPlayerId;

    public Chess_Match() {
    }

    public Chess_Match(int id, String result, String opponentName, float eloGain, float elo, int tblMatchId, int tblChessPlayerId) {
        this.id = id;
        this.result = result;
        this.opponentName = opponentName;
        this.eloGain = eloGain;
        this.elo = elo;
        this.tblMatchId = tblMatchId;
        this.tblChessPlayerId = tblChessPlayerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public float getEloGain() {
        return eloGain;
    }

    public void setEloGain(float eloGain) {
        this.eloGain = eloGain;
    }

    public float getElo() {
        return elo;
    }

    public void setElo(float elo) {
        this.elo = elo;
    }

    public int getTblMatchId() {
        return tblMatchId;
    }

    public void setTblMatchId(int tblMatchId) {
        this.tblMatchId = tblMatchId;
    }

    public int getTblChessPlayerId() {
        return tblChessPlayerId;
    }

    public void setTblChessPlayerId(int tblChessPlayerId) {
        this.tblChessPlayerId = tblChessPlayerId;
    }

    
}
