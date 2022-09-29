package com.beast.nari.model;

public class ChatModel {

    String Text, PERSON;

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getPERSON() {
        return PERSON;
    }

    public void setPERSON(String PERSON) {
        this.PERSON = PERSON;
    }

    public ChatModel(String text, String PERSON) {
        Text = text;
        this.PERSON = PERSON;
    }
}
