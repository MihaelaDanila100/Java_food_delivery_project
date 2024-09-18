package pubs;

import java.util.HashMap;
import java.util.Map;

public class Supermarket extends Pub{
    private Map<String, Integer> items;

    public Supermarket(String supermarketName, String supermarketCity, String supermaketAddress) {
        super(supermarketName, supermarketCity, supermaketAddress);
        this.items = new HashMap<>();
    }

    public Supermarket(String supermarketName, String supermarketCity, String supermaketAddress, Map<String, Integer> supermaketItems) {
        super(supermarketName, supermarketCity, supermaketAddress);
        this.items = supermaketItems;
    }

    public Map<String, Integer> getItems(){
        return this.items;
    }

    public void setItems(Map<String, Integer> newItems){
        this.items = newItems;
    }
}
