package users;

import java.util.Date;

public class Order {
    protected static int id = 0;
    protected int orderId;
    protected Date received;
    protected Date delivered;
    protected int idPub;
    protected int idUser;

    public Order(Date receivingHour, int pubId, int userId) {
        this.received = receivingHour;
        this.idPub = pubId;
        this.idUser = userId;
        this.orderId = id;
        id += 1;
    }

    public void setDelivered(Date delivered) {
        this.delivered = delivered;
    }
}
