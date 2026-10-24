package org.example.service;

import org.example.order.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileParser {

    private final Adapter adapter;

    // Внедряем адаптер через конструктор
    public FileParser(Adapter adapter) {
        this.adapter = adapter;
    }


    public Order orderParse (String line) {

        String[] parts = adapter.adapt(line);

        //сюда нужно добавить адаптер под разные разделители

        // Проверка: должно быть ровно 3 поля
        if (parts.length != 3) {
            throw new IncorrectInputException("Неверное количество полей (ожидалось 3, найдено " + parts.length + ")");
        }
        //Проверка на положительный объем закупаемого цемента,
        if (!(parts[2].matches("\\d+"))) {
            throw new IncorrectInputException("Неверное задан объем цемента, должно быть целое положительное число");
        }
        LocalDateTime dateTime = LocalDateTime.parse(parts[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String company = parts[1];
        int quantity = Integer.parseInt(parts[2]);


        Order orderParse = new Order(dateTime, company, quantity);

        return orderParse;
    }

}
