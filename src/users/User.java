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

    public User(String userName, String userLastName, String userCity, List<String> adresses) {
        this.firstName = userName;
        this.lastName = userLastName;
        this.city = userCity;
        this.addresses = new ArrayList<>();
        for(String adresa: addresses){
            this.addresses.add(adresa);
        }
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

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getCity() {
        return this.city;
    }

    public List<String> getAddresses() {
        List<String> currentAddreses = new ArrayList<>();
        for(String addresss:this.addresses){
            currentAddreses.add(addresss);
        }
        return currentAddreses;
    }
}
