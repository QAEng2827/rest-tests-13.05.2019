package petstore.models;

import java.util.Date;

public class StoreOrderModel {
    /*{
  "id": 0,
  "petId": 0,
  "quantity": 0,
  "shipDate": "2019-06-01T17:27:11.702Z",
  "status": "placed",
  "complete": false
}*/

    private int id;
    private int petId;
    private int quantity;
    private long shipDate;
    private String status;
    private boolean complete;

    public int getId() {
        return id;
    }

    public int getPetId() {
        return petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getShipDate() {
        return shipDate;
    }

    public String getStatus() {
        return status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setShipDate(long shipDate) {
        this.shipDate = shipDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public StoreOrderModel(int id, int petId, int quantity, long shipDate, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }
}
