/*
 * Copyright (C) 2018 Trant Batey <trant.batey at trantbatey.com>
 *
 * 
 */
package com.trantbatey.groceries;

/**
 *
 * @author Trant Batey <trant.batey at trantbatey.com>
 */
public class Product {

    private int productID;
    private String description;
    private java.util.Date lastSold;
    private int shelfLife;
    private String department;
    private float price;
    private String unit;
    private int xFor;
    private float cost;

    public Product() {
        // TODO: Any needed initialization
    }

    public Product(int productID, String description, java.util.Date lastSold,
            int shelfLife, String department, float price, String unit,
            int xFor, float cost) {
        this.productID = productID;
        this.description = description;
        this.lastSold = lastSold;
        this.shelfLife = shelfLife;
        this.department = department;
        this.price = price;
        this.unit = unit;
        this.xFor = xFor;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format(
                "Procduct[productID=%d, description='%s', lastSold='%s', "
                + "shelfLife=%d, department='%s', price=%f, unit='%s', "
                + "xFor=%d, cost=%f]",
                productID, description, lastSold.toString(), shelfLife,
                department, price, unit, xFor, cost);
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.util.Date getLastSold() {
        return lastSold;
    }

    public void setLastSold(java.util.Date lastSold) {
        this.lastSold = lastSold;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getxFor() {
        return xFor;
    }

    public void setxFor(int xFor) {
        this.xFor = xFor;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
