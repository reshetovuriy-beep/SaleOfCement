package org.example;

import org.example.order.Order;

import java.util.ArrayList;
import java.util.List;

import static org.example.service.fileService.ordersLoadFromFile;
import static org.example.service.printOrders.printOrders;

public class Main {
    public static void main(String[] args) {

        List <Order> orders = new ArrayList<>();

        // переменная для имени файла из которого загружаем список заказов
        String fileName;
        fileName = "/discount_day.txt";
        //загружаем список заказов
        ordersLoadFromFile (fileName, orders);

        //выводим список заказов
        printOrders(orders);



        }


}