package com.investInside;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;

public class query {
    public static void bestBid(TreeMap<Integer, Order> orders) throws IOException {
        int count = 0;
        int size = orders.get(orders.lastKey() - count).getSize();
        while (size == 0) {
                count++;
            }
        RW.writeResult(orders.get(orders.lastKey() - count).toString());
        }


    public static void bestAsk(TreeMap<Integer, Order> orders) throws IOException {
        int count = 0;
        int size = orders.get(orders.firstKey() + count).getSize();
        while (size == 0) {
            count++;
        }
        RW.writeResult(orders.get(orders.firstKey() + count).toString());
    }

    public static void sizePrice(TreeMap<Integer, Order> bookA, TreeMap<Integer, Order> bookB, int price) throws IOException {
        if (bookA.containsKey(price)) {
            RW.writeResult(Integer.toString(bookA.get(price).getSize()));
        } else if (bookB.containsKey(price)) {
            RW.writeResult(Integer.toString(bookB.get(price).getSize()));
        } else {
            RW.writeResult("0");

        }
    }

    public static Order buy(TreeMap<Integer, Order> orders, int shares) throws IOException {
        int count = 0;
        int size = orders.get(orders.firstKey() + count).getSize();
        while (size == 0) {
            count++;
        }
        Order tempOrder = orders.get(orders.firstKey() + count);
        tempOrder.setSize(tempOrder.getSize() - shares);
        return tempOrder;
    }

    public static Order sell(TreeMap<Integer, Order> orders, int shares) throws IOException {
        int count = 0;
        int size = orders.get(orders.lastKey() + count).getSize();
        while (size == 0) {
            count++;
        }
        Order tempOrder = orders.get(orders.lastKey() + count);
        tempOrder.setSize(tempOrder.getSize() - shares);
        return tempOrder;
    }
}
