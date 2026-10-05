package org.example;

import java.util.ArrayList;
import java.util.List;

import java.io.InputStream;
import java.util.Scanner;

import static org.example.Order.ordersLoadFromFile;
import static org.example.Order.printOrders;

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