import io.exceptions.FileReadingException;
import io.exceptions.FileWritingException;
import logistics.Car;
import products.Drink;
import repository.*;
import services.*;
import products.Dish;
import users.BarOrder;
import users.RestaurantOrder;
import users.User;
import config.DatabaseConfig;


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
        adrseUser.add(adresaUser);

        User newUser = new User(numeUser, prenumeUser, localitateUser, adrseUser);
        Dish comandaUser = new Dish("piept de pui", 1);
        List<Dish> listComandaUser = new ArrayList<Dish>();
        listComandaUser.add(comandaUser);

        RestaurantOrder comandaUser1 = new RestaurantOrder(new Date(System.currentTimeMillis()), 0, 0, listComandaUser);

        ServiceClass s = new ServiceClass();
        s.addOrderToHistory(comandaUser1, newUser);
    }

    public static void main(String[] args) throws FileReadingException, FileWritingException {
     /*   CarSingletonService c = CarSingletonService.getInstance();
        c.writeData();
        DriverSingletonService d = DriverSingletonService.getInstance();
        d.writeData();
        UserSingletonService u = UserSingletonService.getInstance();
        u.writeData();
        Audit a = Audit.getInstance();
        a.writeCSV();*/

        //CREARE TABELE

       CarRepository carRepository = new CarRepository();
        carRepository.createTable();

        DriverRepository driverRepository = new DriverRepository();
        driverRepository.createTable();

        DrinkRepository drinkRepository = new DrinkRepository();
        drinkRepository.createTable();

        OrdersRepository ordersRepository = new OrdersRepository();
        ordersRepository.createTable();

        UserRepository userRepository = new UserRepository();
        userRepository.createTable();

        BarRepository barRepository = new BarRepository();
        barRepository.createTable();
        DatabaseConfig.closeDatabaseConfiguration();

        //MENIU
        System.out.println("Doresc sa: \n1.Creez un cont nou\n2.Editez un cont\n3.Sterg un cont\n4. Iesire\n[Alegeti cifra corespunzatoare]");
        Scanner sc = new Scanner(System.in);
        int optiune = sc.nextInt();
        while(optiune!= 4){
            sc.nextLine();
            User user;
            if(optiune == 1){
                String nume, prenume, oras;
                int nrAdrese;
                List<String> adrese = new ArrayList<>();
                System.out.println("First name: ");
                nume = sc.nextLine();
                System.out.println("Last name: ");
                prenume = sc.nextLine();
                System.out.println("City: ");
                oras = sc.nextLine();
                System.out.println("Number of addresses: ");
                nrAdrese = sc.nextInt();
                for(int i = 0; i < nrAdrese; i++){
                    String nextAdresa = sc.nextLine();
                    adrese.add(nextAdresa);
                }
                user = new User(nume, prenume, oras, adrese);
                userRepository.insertUser(user);
            }
            if(optiune == 2){
                String nume, prenume, oras;
                int nrAdrese;
                int idCont;
                System.out.println("Id cont: ");
                idCont = sc.nextInt();
                sc.nextLine();
                List<String> adrese = new ArrayList<>();
                System.out.println("First name: ");
                nume = sc.nextLine();
                System.out.println("Last name: ");
                prenume = sc.nextLine();
                System.out.println("City: ");
                oras = sc.nextLine();
                System.out.println("Number of addresses: ");
                nrAdrese = sc.nextInt();
                for(int i = 0; i < nrAdrese; i++){
                    String nextAdresa = sc.nextLine();
                    adrese.add(nextAdresa);
                }
                userRepository.updateUser(idCont, nume, prenume, oras, adrese);
            }
            if(optiune == 3){
                int idCont;
                System.out.println("Id cont: ");
                idCont = sc.nextInt();
                userRepository.deletUser(idCont);
            }
            sc.nextLine();
            optiune = sc.nextInt();
            System.out.println(optiune);
        }
    }
}
