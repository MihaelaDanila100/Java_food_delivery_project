package pubs;
import products.Dish;
import services.MyGenericList;

import java.util.List;

public class Restaurant extends Pub{
    private MyGenericList<Dish> availableDishes;

    public Restaurant(String restaurantName, String restaurantLocation, String restaruantAddress, MyGenericList<Dish> restaurantAvailableDishes) {
        super(restaurantName, restaurantLocation, restaruantAddress);
        this.availableDishes = restaurantAvailableDishes;
    }

    @Override
    public String toString() {
        return super.toString() + "availableDishes=" + availableDishes.toString() + '}';
    }
}
