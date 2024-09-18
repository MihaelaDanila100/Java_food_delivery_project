package pubs;

public class Pub {
    protected static int id = 0;
    protected String name;
    protected String city;
    protected String address;

    public Pub(String pubName, String location, String pubAddress) {
        this.name = pubName;
        this.city = location;
        this.address = pubAddress;
    }
}
