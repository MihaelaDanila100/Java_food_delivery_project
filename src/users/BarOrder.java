package users;

import products.Drink;

import java.util.Date;
import java.util.List;

public class BarOrder extends Order{
    private List<Drink> drinks;

    public BarOrder(Date received, int idPub, int idUser, List<Drink> dirnkList) {
        super(received, idPub, idUser);
        this.drinks = dirnkList;
    }

    public List<Drink> getDrinks() {
        return this.drinks;
    }
}
