package com.example.coffeecup;

public class CoffeeModelClass {

    String coffeeName;
    int image;

    public CoffeeModelClass(String coffeeName, int image) {
        this.coffeeName = coffeeName;
        this.image = image;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public int getImage() {
        return image;
    }
}
