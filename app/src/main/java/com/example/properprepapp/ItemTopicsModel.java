package com.example.properprepapp;

public class ItemTopicsModel {
    private String itemTopicView, questionSolvedView;

    public ItemTopicsModel(String itemTopicView, String questionSolvedView) {
        this.itemTopicView = itemTopicView;
        this.questionSolvedView = questionSolvedView;
    }

    public ItemTopicsModel(){}

    public String getItemTopicView() {
        return itemTopicView;
    }

    public void setItemTopicView(String itemTopicView) {
        this.itemTopicView = itemTopicView;
    }

    public String getQuestionSolvedView() {
        return questionSolvedView;
    }

    public void setQuestionSolvedView(String questionSolvedView) {
        this.questionSolvedView = questionSolvedView;
    }
}
