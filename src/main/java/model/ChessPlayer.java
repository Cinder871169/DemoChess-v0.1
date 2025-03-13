package model;

import java.io.Serializable;
import java.util.Date;

public class ChessPlayer implements Serializable {
    private int id;
    private String name;
    private Date dob;
    private String national;
    private String result;
    private float totalPoint;
    private float totalOpponentPoint;
    private float eloCoEfficient;

    public ChessPlayer() {
    }

    public ChessPlayer(int id, String name, Date dob, String national, String result, float totalPoint,
            float totalOpponentPoint, float eloCoEfficient) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.national = national;
        this.result = result;
        this.totalPoint = totalPoint;
        this.totalOpponentPoint = totalOpponentPoint;
        this.eloCoEfficient = eloCoEfficient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public float getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(float totalPoint) {
        this.totalPoint = totalPoint;
    }

    public float getTotalOpponentPoint() {
        return totalOpponentPoint;
    }

    public void setTotalOpponentPoint(float totalOpponentPoint) {
        this.totalOpponentPoint = totalOpponentPoint;
    }

    public float getEloCoEfficient() {
        return eloCoEfficient;
    }

    public void setEloCoEfficient(float eloCoEfficient) {
        this.eloCoEfficient = eloCoEfficient;
    }

}
