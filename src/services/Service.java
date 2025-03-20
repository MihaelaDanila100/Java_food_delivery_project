package services;

import logistics.Car;
import logistics.Driver;
import products.Dish;
import products.Drink;
import pubs.Bar;
import pubs.Supermarket;
import users.Order;
import users.User;

public interface Service {
    public void updateAvailabilityCar(Car c);
    public void associateCar(Driver d, Car c);
    public void releaseCar(Car c);
    public void bringMoreDrinks(Drink dr, int number);
    public void orderDish(Dish ds, int q);
    public void updateAvailabilityDish(Dish ds);
    public boolean checkAvailabilityDrink(Bar b, Drink dr);
    public void consumeItem(Supermarket s, String item, int quantity);
    public void deliverOrder(Order o, Driver d);
    public void addOrderToHistory(Order o, User u);
}
