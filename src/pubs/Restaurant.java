package pubs;
import products.Dish;

import java.util.List;

public class Restaurant extends Pub{
    private List<Dish> availableDishes;

    public Restaurant(String restaurantName, String restaurantLocation, String restaruantAddress, List<Dish> restaurantAvailableDishes) {
        super(restaurantName, restaurantLocation, restaruantAddress);
        this.availableDishes = restaurantAvailableDishes;
    }
}
