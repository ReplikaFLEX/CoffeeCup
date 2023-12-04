package com.example.coffeecup;

public class CoffeeModelClass {

    String coffeeName;
    String description;
    int image;

    public CoffeeModelClass(String coffeeName, String description,int image) {
        this.coffeeName = coffeeName;
        this.image = image;
        this.description = description;
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
}
