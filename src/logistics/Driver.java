package logistics;

public class Driver {
    private String name;
    private int age;
    private String city;
    private int carId;
    private boolean disponibility;

    public void setCar(int id){
        this.carId = id;
    }

    public void toggleDisponibility(){
        this.disponibility = ! this.disponibility;
    }
}
