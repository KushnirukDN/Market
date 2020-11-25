package com.investInside;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.file.Files;
import java.util.TreeMap;

public class RW {
    public static void readAndSolve() throws IOException {
        File file = new File("input.txt");

        TreeMap<Integer, Order> bookA = new TreeMap<>();
        TreeMap<Integer, Order> bookB = new TreeMap<>();

        String[] units = new String(Files.readAllBytes(file.toPath())).split("\n");

        for (String str: units) {
            String[] forObjectCreating = str.split(",");

            if (forObjectCreating.length == 4) {
                    if (forObjectCreating[3].equals("ask")) {
                        bookA.put(Integer.parseInt(forObjectCreating[1]),
                                new Order(forObjectCreating[1], forObjectCreating[2], forObjectCreating[3]));
                    } else {
                        bookB.put(Integer.parseInt(forObjectCreating[1]),
                                new Order(forObjectCreating[1], forObjectCreating[2], forObjectCreating[3]));
                    }
            } else {
                    if (forObjectCreating[0].equals("q")) {
                            if (forObjectCreating[1].equals("best_bid")) {
                                query.bestBid(bookB);
                            } else if (forObjectCreating[1].equals("best_ask")) {
                                query.bestAsk(bookA);
                            } else {
                                query.sizePrice(bookA, bookB, Integer.parseInt(forObjectCreating[2]));
                            }
                    } else {
                        if (forObjectCreating[1].equals("buy")) {
                            Order updatedOrder = query.buy(bookA, Integer.parseInt(forObjectCreating[2]));
                            bookA.put(updatedOrder.getPrice(), updatedOrder);
                        } else {
                            Order updatedOrder =  query.sell(bookB, Integer.parseInt(forObjectCreating[2]));
                            bookB.put(updatedOrder.getPrice(), updatedOrder);
                        }
                    }
                }
        }
    }

    public static void writeResult(String order) throws IOException {
        File file = new File("output.txt");
        OutputStream os = new FileOutputStream(file, true);

        os.write(order.getBytes());
    }
}
