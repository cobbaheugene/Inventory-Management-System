package models;

public class IssuedGood {
    public  int vendorId;
    public int quantity;
    public  double price;

    public IssuedGood(int goodId, int vendorId, int quantity, double price) {
        this.vendorId = vendorId;
        this.quantity = quantity;
        this.price = price;

    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
