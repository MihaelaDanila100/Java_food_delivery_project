package users;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int id = 0;
    private String firstName;
    private String lastName;
    private String city;
    private List<String> addresses;
    private List<Order> historyOrders;
    private List<Integer> coupons;

    public User(String userName, String userLastName, String userCity, String adress) {
        this.firstName = userName;
        this.lastName = userLastName;
        this.city = userCity;
        this.addresses = new ArrayList<>();
        this.addresses.add(adress);
        historyOrders = new ArrayList<>();
        coupons = new ArrayList<>();
    }

    public void updateHistory(Order o){
        this.historyOrders.add(o);
    }

    @Override
    public String toString() {
        return "User " + firstName + '\'' + " " + lastName + '\'' + ": city='" + city + '\'' + ", addresses="
                + addresses +", historyOrders=" + historyOrders + ", coupons=" + coupons + "\n";
    }
}
