package com.example.properprepapp;

public class User {
    private String name, email, password, physicsQuestionsAttempted, mathsQuestionsAttempted, chemistryQuestionsAttempted, biologyQuestionsAttempted, physicsScore, mathsScore, chemistryScore, biologyScore;

    public User(){}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhysicsQuestionsAttempted() {
        return physicsQuestionsAttempted;
    }

    public void setPhysicsQuestionsAttempted(String physicsQuestionsAttempted) {
        this.physicsQuestionsAttempted = physicsQuestionsAttempted;
    }

    public String getMathsQuestionsAttempted() {
        return mathsQuestionsAttempted;
    }

    public void setMathsQuestionsAttempted(String mathsQuestionsAttempted) {
        this.mathsQuestionsAttempted = mathsQuestionsAttempted;
    }

    public String getChemistryQuestionsAttempted() {
        return chemistryQuestionsAttempted;
    }

    public void setChemistryQuestionsAttempted(String chemistryQuestionsAttempted) {
        this.chemistryQuestionsAttempted = chemistryQuestionsAttempted;
    }

    public String getBiologyQuestionsAttempted() {
        return biologyQuestionsAttempted;
    }

    public void setBiologyQuestionsAttempted(String biologyQuestionsAttempted) {
        this.biologyQuestionsAttempted = biologyQuestionsAttempted;
    }

    public String getPhysicsScore() {
        return physicsScore;
    }

    public void setPhysicsScore(String physicsScore) {
        this.physicsScore = physicsScore;
    }

    public String getMathsScore() {
        return mathsScore;
    }

    public void setMathsScore(String mathsScore) {
        this.mathsScore = mathsScore;
    }

    public String getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(String chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    public String getBiologyScore() {
        return biologyScore;
    }

    public void setBiologyScore(String biologyScore) {
        this.biologyScore = biologyScore;
    }
}
