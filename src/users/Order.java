package users;

import java.util.Date;

public class Order {
    protected static int id = 0;
    protected Date received;
    protected Date delivered;
    protected int idPub;
    protected int idUser;

    public Order(Date receivingHour, int pubId, int userId) {
        this.received = receivingHour;
        this.idPub = pubId;
        this.idUser = userId;
    }

    public void setDelivered(Date delivered) {
        this.delivered = delivered;
    }
}
