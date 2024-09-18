package logistics;

public class Car {
    private static int id = 0;
    private String name;
    private int capacity;
    private boolean disponibility;

    public Car(String carName, int carCapacity) {
        this.name = carName;
        this.capacity = carCapacity;
        disponibility = true;
    }

    public int getId(){
        return this.id;
    }

    public boolean getDisponibility(){
        return this.disponibility;
    }

    public void setDisponibility(boolean d){
        this.disponibility = d;
    }
}
