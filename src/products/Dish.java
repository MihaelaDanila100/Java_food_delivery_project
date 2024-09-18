package products;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;
    private int quantity;
    private List<String> ingredients;
    private boolean disponibility;

    public Dish(String newName, int newQuantity){
        this.name = name;
        this.quantity = quantity;
        this.ingredients = new ArrayList<>();
        disponibility = true;
    }

    public Dish(String newName, int newQuantity, List<String> newIngredients){
        this.name = name;
        this.quantity = quantity;
        this.ingredients = ingredients;
        disponibility = true;
    }

    public boolean getDisponibility(){
        return disponibility;
    }

    public void setDisponibility(boolean newDisponibility){
        this.disponibility = newDisponibility;
    }

    public void setQuantity(int q){
        this.quantity = q;
    }
}
