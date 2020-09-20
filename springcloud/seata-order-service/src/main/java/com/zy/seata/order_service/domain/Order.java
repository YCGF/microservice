package com.zy.seata.order_service.domain;

public class Order {

    private int id;

    private int userId;

    private int productId;

    private int count;

    private double price;

    private int status;

    public Order() {

    }

    public Order(int id, int userId, int productId, int count, double price, int status) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.count = count;
        this.price = price;
        this.status = status;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
