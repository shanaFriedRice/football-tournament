package com.capgemini.model.resources;

public abstract class Team {

    //Declare variables for the object team
    protected String name;
    private boolean isProfessional;
    private String sponsorType;
    private boolean hasLost;

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    //constructor for creating teams
    public Team (String name, boolean isProfessional, String sponsorType){
        this.name = name;
        this.isProfessional = isProfessional;
        this.sponsorType = sponsorType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isProfessional() {
        return this.isProfessional;
    }

    public void setProfessional(boolean professional) {
        this.isProfessional = professional;
    }

    public String getSponsorType() {
        return this.sponsorType;
    }

    public void setSponsorType(String sponsorType) {
        this.sponsorType = sponsorType;
    }

    public boolean isHasLost() {
        return this.hasLost;
    }

    public void setHasLost(boolean hasLost) {
        this.hasLost = hasLost;
    }
}
