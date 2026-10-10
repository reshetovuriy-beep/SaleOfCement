package org.example;

import org.example.order.Order;

import java.util.ArrayList;
import java.util.List;

import static org.example.service.FileService.ordersLoadFromFile;
import static org.example.service.PrintOrders.printOrders;

public class Main {
    public static void main(String[] args) {

        List <Order> orders = new ArrayList<>();

        // переменная для имени файла из которого загружаем список заказов
        String fileName = "/discount_day.txt";
        String separator = "\\|";
        //загружаем список заказов
        ordersLoadFromFile (fileName, orders, separator);

        fileName = "/discount_day_without_ext";
        separator = "#";
        ordersLoadFromFile (fileName, orders, separator);

        //выводим список заказов
        printOrders(orders);



        }


}