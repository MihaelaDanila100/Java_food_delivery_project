package users;

import products.Dish;

import java.util.Date;
import java.util.List;

public class RestaurantOrder extends Order{
    private List<Dish> dishes;

    public RestaurantOrder(Date received, int idPub, int idUser, List<Dish> dishList) {
        super(received, idPub, idUser);
        this.dishes = dishList;
    }
}
