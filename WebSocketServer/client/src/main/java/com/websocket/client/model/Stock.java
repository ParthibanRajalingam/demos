package com.websocket.client.model;

public class Stock {
    String name;
    String icon;
    float price;
    boolean increased;

    public boolean isIncreased() {
        return increased;
    }

    public void setIncreased(boolean increased) {
        this.increased = increased;
    }

    public Stock(String name, String icon, float price) {
        this.name = name;
        this.icon = icon;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
