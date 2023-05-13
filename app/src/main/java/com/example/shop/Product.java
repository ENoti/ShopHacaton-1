package com.example.shop;

public class Product {
    private int id;
    private String name;
    private String category;
    private int amount;
    private int price;

    public Product(int id, String name, String category, int amount, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public int getAmount() {
        return amount;
    }
    public int getPrice() {
        return price;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setPrice(int price) {
        this.price = price;
    }


}