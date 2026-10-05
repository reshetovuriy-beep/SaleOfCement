package org.example.service;

import org.example.order.order;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class printOrders {

    public static void printOrders (List<order> orders) {
        // метод для вывода списка заказов содержащихся в orders
        // перебор всех элементов
        for (order o : orders) {
            System.out.println(o.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            System.out.println(o.getCompany());
            System.out.println(o.getQuantity());
            System.out.println("");

        }
    }

}
