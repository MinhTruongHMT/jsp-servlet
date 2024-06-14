package com.truong.ecommerce.entity;

public class Item {
    private int id;
    private int userId;
    private Product product;
    private int quantity;
    private double price;
    public Item() {}
    public Item(int id, int userId,Product product, int quantity, double price) {
        this.id = id;
        this.userId = userId;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +

                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
    public Item addItem(Product product, int quantity) {
        this.quantity += quantity;
        this.price += product.getPrice();
        return this;
    }

    public Product getProduct() {
        return this.product;
    }
}
