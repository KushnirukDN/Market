package com.investInside;

import java.io.Serializable;

public class Order implements Serializable {
    private int price;
    private int size;
    String type;

    public Order(String price, String size, String s) {
        this.price = Integer.parseInt(price);
        this.size = Integer.parseInt(size);
        this.type = s;
    }

    public int getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

   /* @Override
    public String toString() {
        return price + ", " + size + "\n";
    }*/

    @Override
    public String toString() {
        return  price +
                ", " + size +
                 "\n" ;
    }
}
