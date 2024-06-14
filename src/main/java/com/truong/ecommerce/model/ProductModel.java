package com.truong.ecommerce.model;

import com.truong.ecommerce.entity.Product;

public class ProductModel {
    private Product product; // Reference to the Product entity

    public ProductModel(Product product) {
        this.product = product;
    }

    public int getId() {
        return product.getId();
    }

    public void setId(int id) {
        product.setId(id);
    }

    public String getName() {
        return product.getName();
    }

    public void setName(String name) {
        product.setName(name);
    }

    public String getFormattedPrice() {
        return String.format("$%.2f", product.getPrice());
    }

    public String getShortDescription() {
        return product.getDescription().substring(0, 100) + "...";
    }

    public String find(String id, int count) {
        return product.getDescription().substring(0, 100) + "...";
    }
}
