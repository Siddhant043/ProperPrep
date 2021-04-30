package com.example.properprepapp;

public class ItemTopicsModel {
    private String itemTopicView, questionSolvedView, topicId;

    private String belongsCategory = "";

    public ItemTopicsModel(String itemTopicView, String questionSolvedView, String topicId) {
        this.itemTopicView = itemTopicView;
        this.questionSolvedView = questionSolvedView;
        this.topicId = topicId;
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

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getBelongsCategory() {
        return belongsCategory;
    }

    public void setBelongsCategory(String belongsCategory) {
        this.belongsCategory = belongsCategory;
    }
}
