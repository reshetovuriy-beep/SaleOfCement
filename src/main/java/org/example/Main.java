package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List <Order> order = new ArrayList<>();

        order.add(new Order(null,"16:00:22", "Industrial", 8800));   // добавляем в конец
//        order.add(new Order(null,"16:00:22", "Industrial", 8800));   // добавляем в конец
//        order.add(new Order("2021-02-09","08:42:59", "Power Engineer", 17480));

        System.out.println(order.size());   // размер списка

        // перебор всех элементов
        for (Order o : order) {
            System.out.println(o.getDate());
            System.out.println(o.getTime());
            System.out.println(o.getCompany());
            System.out.println(o.getQuantity());
            System.out.println("");

        }
    }
}