package com.example.coffeecup;

public class CoffeeModelClass {

    String coffeeName;
    String description;
    int price;
    int image;

    public CoffeeModelClass(String coffeeName, String description,int image, int price) {
        this.coffeeName = coffeeName;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
