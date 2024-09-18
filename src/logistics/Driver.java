package logistics;

public class Driver {
    private String name;
    private int age;
    private String city;
    private int carId;
    private boolean disponibility;

    public Driver(String name, int age, String city, int carId) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.carId = carId;
        this.disponibility = true;
    }

    public void setCar(int id){
        this.carId = id;
    }

    public void toggleDisponibility(){
        this.disponibility = ! this.disponibility;
    }

    @Override
    public String toString() {
        return "Driver: '" + name + '\'' + ", age=" + age + ", city='" + city + '\'' + ", carId=" + carId +
                ", disponibility=" + disponibility + "\n";
    }
}
