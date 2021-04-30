package com.example.properprepapp;

public class TestModel {
    private String testName, hostedBy, difficultyLevel, testDescription, noOfQuestions, testId;


    public TestModel(String testName, String hostedBy, String difficultyLevel, String noOfQuestions) {
        this.testName = testName;
        this.hostedBy = hostedBy;
        this.difficultyLevel = difficultyLevel;
        this.noOfQuestions = noOfQuestions;
    }

    public TestModel(){}

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getHostedBy() {
        return hostedBy;
    }

    public void setHostedBy(String hostedBy) {
        this.hostedBy = hostedBy;
    }


    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(String noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }
}
