/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
/**
 *
 * @author user
 */
public class Match implements Serializable{
    private int id;
    private String nameMatch;
    private int tblRoundId;

    public Match() {
    }

    public Match(int id, String nameMatch, int tblRoundId) {
        this.id = id;
        this.nameMatch = nameMatch;
        this.tblRoundId = tblRoundId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMatch() {
        return nameMatch;
    }

    public void setNameMatch(String nameMatch) {
        this.nameMatch = nameMatch;
    }

    public int getTblRoundId() {
        return tblRoundId;
    }

    public void setTblRoundId(int tblRoundId) {
        this.tblRoundId = tblRoundId;
    }
    
    
}
