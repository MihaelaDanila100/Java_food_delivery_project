package products;

public class Drink{
    private String name;
    private int quantity;

    public Drink(String newName, int q){
        this.name = newName;
        this.quantity = q;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }

    @Override
    public String toString() {
        return "Drink: " + name + '\'' + ", quantity=" + quantity + "\n";
    }

    public String getName() {
        return this.name;
    }

    public int getQuanity() {
        return this.quantity;
    }
}