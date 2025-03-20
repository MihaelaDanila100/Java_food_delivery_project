package services;

import logistics.Car;
import logistics.Driver;
import products.Dish;
import products.Drink;
import pubs.Bar;
import pubs.Supermarket;
import users.Order;
import users.User;

import java.util.Date;
import java.util.Map;

public class ServiceClass implements Service{
    public void updateAvailabilityCar(Car c){
        c.setDisponibility(! c.getDisponibility());
    }

    public void associateCar(Driver d, Car c){
        int carId = c.getId();
        d.setCar(carId);
        c.setDisponibility(false);
    }

    public void releaseCar(Car c){
        c.setDisponibility(true);
    }

    public void bringMoreDrinks(Drink dr, int number){
        dr.setQuantity(dr.getQuantity() + number);
    }

    public void orderDish(Dish ds, int q){
        ds.setQuantity(q);
    }
    public void updateAvailabilityDish(Dish ds){
        boolean disponibilty = ds.getDisponibility();
        disponibilty = !disponibilty;
        ds.setDisponibility(disponibilty);
    }

    public boolean checkAvailabilityDrink(Bar b, Drink dr){
        if(b.getAvailableDrinks().contains(dr)){
            return true;
        }
        return false;
    }

    public void consumeItem(Supermarket s, String item, int quantity){
        Map<String, Integer> supermarketItems = s.getItems();
        supermarketItems.put(item, supermarketItems.get(item)+quantity);
        s.setItems(supermarketItems);
    }

    public void deliverOrder(Order o, Driver d){
        o.setDelivered(new Date());
        d.toggleDisponibility();
    }


    public void addOrderToHistory(Order o, User u){
        u.updateHistory(o);
    }
}
