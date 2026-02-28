package uaedunung.se.models;

public class Fruit {
    private String name;
    private double price;
    private int quantity;

    public Fruit(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}