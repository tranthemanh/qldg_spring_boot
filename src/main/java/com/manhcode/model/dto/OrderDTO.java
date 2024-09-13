package com.manhcode.model.dto;

import java.time.LocalDate;
import java.util.Date;

public class OrderDTO {
    private Long id;
    private String productName;
    private int price;
    private String typeName;
    private Date purchaseDate;
    private int quantity;
    private int totalPrice;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String productName, int price, String typeName, Date purchaseDate, int quantity, int totalPrice) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.typeName = typeName;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
