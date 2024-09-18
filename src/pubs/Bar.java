package pubs;
import products.Drink;

import java.util.List;

public class Bar extends Pub{
    private List<Drink> availableDrinks;

    public Bar(String barName, String barLocation, String barAddress, List<Drink> barAvailableDrinks) {
        super(barName, barLocation, barAddress);
        this.availableDrinks = barAvailableDrinks;
    };

    public List<Drink> getAvailableDrinks(){
        return this.availableDrinks;
    }
}
