package com.example.shop;

import java.util.ArrayList;

public class Card {
    String textNumberCard;
    String textNameBankCard;
    String textDateCard;

    public Card(String textNumberCard, String textNameBankCard, String textDateCard) {
        this.textNumberCard = textNumberCard;
        this.textNameBankCard = textNameBankCard;
        this.textDateCard = textDateCard;
    }

    public String getTextNumberCard() {
        return textNumberCard;
    }

    public void setTextNumberCard(String textNumberCard) {
        this.textNumberCard = textNumberCard;
    }

    public String getTextNameBankCard() {
        return textNameBankCard;
    }

    public void setTextNameBankCard(String textNameBankCard) {
        this.textNameBankCard = textNameBankCard;
    }

    public String getTextDateCard() {
        return textDateCard;
    }

    public void setTextDateCard(String textDateCard) {
        this.textDateCard = textDateCard;
    }
}
