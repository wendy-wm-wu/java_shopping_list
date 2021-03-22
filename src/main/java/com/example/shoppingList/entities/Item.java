package com.example.shoppingList.entities;

import java.util.Date;

public class Item {
    private String name;
    private Date date;

    public Item(String name) {
        this.name = name;
        this.date = new Date();
    }

    public Item(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
