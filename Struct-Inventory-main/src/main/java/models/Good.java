package models;

public class Good {

    public String id;
    public String category;
    public String name;
    public  int quantity;
    public  double buyingPrice;

    public void setId(String id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public double sellingPrice;
    public double grossPrice;

    public String getId() {
        return id;
    }

    public Good(String category, String name, int quantity, double buyingPrice, double sellingPrice, double grossPrice) {
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.grossPrice = grossPrice;

    }

}
