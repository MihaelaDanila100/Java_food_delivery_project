package logistics;

public class Car {
    private static int id = 0;
    private int carId;
    private String name;
    private int capacity;
    private boolean disponibility;

    public Car(String carName, int carCapacity) {
        carId = id;
        id += 1;
        this.name = carName;
        this.capacity = carCapacity;
        disponibility = true;
    }

    public int getId(){
        return this.carId;
    }

    public boolean getDisponibility(){
        return this.disponibility;
    }

    public void setDisponibility(boolean d){
        this.disponibility = d;
    }

    @Override
    public String toString() {
        return "Car no. " + carId + ": name='" + name + '\'' + ", capacity=" + capacity + ", disponibility="
                + disponibility + "\n";
    }
}
