package com.example.laxmi9946.foodcourt;

/**
 * Created by laxmi9946 on 4/22/2018.
 */

public class FoodItems {

    public String foodTitle;
    public String ingredients;
    public String quantity;
    public int foodImage;

    public FoodItems(String foodTitle, String ingredients, String quantity, int foodImage) {
        this.foodTitle = foodTitle;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.foodImage = foodImage;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

}
