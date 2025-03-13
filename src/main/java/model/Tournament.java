package model;

import java.io.Serializable;
import java.util.Date;

public class Tournament implements Serializable {
    private int id;
    private String name;
    private Date starttime;
    private String location;
    private String rules;
    private String prizes;

    public Tournament() {
        super();
    }

    public Tournament(int id, String name, Date starttime, String location, String rules, String prizes) {
        super();
        this.id = id;
        this.name = name;
        this.starttime = starttime;
        this.location = location;
        this.rules = rules;
        this.prizes = prizes;
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getPrizes() {
        return prizes;
    }

    public void setPrizes(String prizes) {
        this.prizes = prizes;
    }
}
