import io.exceptions.FileReadingException;
import io.exceptions.FileWritingException;
import services.*;
import products.Dish;
import users.RestaurantOrder;
import users.User;

import java.util.*;

public class Main {

    public static void etapa1(String[] args) {

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

        User newUser = new User(numeUser, prenumeUser, localitateUser, adresaUser);
        Dish comandaUser = new Dish("piept de pui", 1);
        List<Dish> listComandaUser = new ArrayList<Dish>();
        listComandaUser.add(comandaUser);

        RestaurantOrder comandaUser1 = new RestaurantOrder(new Date(System.currentTimeMillis()), 0, 0, listComandaUser);

        ServiceClass s = new ServiceClass();
        s.addOrderToHistory(comandaUser1, newUser);
    }

    public static void main(String[] args) throws FileReadingException, FileWritingException {
        CarSingletonService c = CarSingletonService.getInstance();
        c.writeData();
        DriverSingletonService d = DriverSingletonService.getInstance();
        d.writeData();
        UserSingletonService u = UserSingletonService.getInstance();
        u.writeData();
        Audit a = Audit.getInstance();
        a.writeCSV();
    }
}
