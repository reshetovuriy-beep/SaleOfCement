package org.example.service;

import org.example.order.Order;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class PrintOrders {

    public static void printOrders (List<Order> orders) {
        // метод для вывода списка заказов содержащихся в orders
        // перебор всех элементов
        for (Order o : orders) {
            System.out.println(o.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            System.out.println(o.getCompany());
            System.out.println(o.getQuantity());
            System.out.println("");

        }
    }

}
