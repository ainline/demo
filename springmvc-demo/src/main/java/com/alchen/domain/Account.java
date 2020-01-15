package com.alchen.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private String card;
    private float money;

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "card='" + card + '\'' +
                ", money=" + money +
                '}';
    }
}
