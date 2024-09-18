import products.Dish;
import pubs.Restaurant;
import services.Service;
import services.ServiceClass;
import users.RestaurantOrder;
import users.User;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Dish> preparateRestaurant = new ArrayList<Dish>();

        List<String> listIngrediente = new ArrayList<String>();
        listIngrediente.add("piept de pui");
        listIngrediente.add("sare");

        Dish p = new Dish("Piept de pui", 1, listIngrediente);
        preparateRestaurant.add(p);

        Scanner keyboard = new Scanner(System.in);

        String numeUser, prenumeUser, localitateUser, adresaUser;

        System.out.println("Introduceti utilizator: ");

        System.out.println("Nume: ");
        numeUser = keyboard.nextLine().toString();

        System.out.println("Prenume: ");
        prenumeUser = keyboard.nextLine().toString();

        System.out.println("Localitate: ");
        localitateUser = keyboard.nextLine().toString();

        System.out.println("Adresa: ");
        List<String> adrseUser = new ArrayList<String>();
        adresaUser = keyboard.nextLine().toString();
        adrseUser.add(adresaUser);

        User newUser = new User(numeUser, prenumeUser, localitateUser, adrseUser);
        Dish comandaUser = new Dish("piept de pui", 1);
        List<Dish> listComandaUser = new ArrayList<Dish>();
        listComandaUser.add(comandaUser);

        RestaurantOrder comandaUser1 = new RestaurantOrder(new Date(System.currentTimeMillis()), 0, 0, listComandaUser);

        ServiceClass s = new ServiceClass();
        s.addOrderToHistory(comandaUser1, newUser);
    }
}
