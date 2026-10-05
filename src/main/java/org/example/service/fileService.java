package org.example.service;

import org.example.Main;
import org.example.order.order;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class fileService {

    public static List<order> ordersLoadFromFile (String fileName, List <order> orders) {
        //метод для загрузки списка заказов из файла


        // 1. Получаем поток данных из файла через ClassLoader
        // Имя файла должно начинаться со слэша "/" для поиска в корне ресурсов
        InputStream inputStream = Main.class.getResourceAsStream(fileName);

        if (inputStream == null) {
            System.err.println("Ошибка: Файл " + fileName + " не найден в ресурсах!");
            return orders;
        }

        // 2. Читаем файл построчно
        try (Scanner scanner = new Scanner(inputStream)) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                lineNumber++;

                // Пропускаем пустые строки
                if (line.isEmpty()) {
                    continue;
                }

                try {
                    // 3. Разбиваем строку на части по |
                    String[] parts = line.split("\\|");

                    //сюда нужно добавить адаптер под разные разделители

                    // Проверка: должно быть ровно 3 поля
                    if (parts.length != 3) {
                        throw new IllegalArgumentException("Неверное количество полей (ожидалось 3, найдено " + parts.length + ")");
                    }
                    //Проверка на положительный объем закупаемого цемента, кастомный Exception
                    if (Integer.parseInt(parts[2]) < 0) {
                        throw new IllegalArgumentException("Неверный объем цемента, не может быть меньше 0 в заказе компании " + parts[1] + " от " + parts[0]);
                    }

                    LocalDateTime dateTime = LocalDateTime.parse(parts[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    String company = parts[1];
                    int quantity = Integer.parseInt(parts[2]);

                    // 4. Создаем объект Order и добавляем в список
                    order order = new order(dateTime, company, quantity);
                    orders.add(order);

                } catch (NumberFormatException e) {
                    System.err.println("Ошибка формата числа в строке " + lineNumber + ": " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка в строке " + lineNumber + ": " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
        }

        // Проверка результата
        System.out.println("Успешно загружено заказов: " + orders.size());
        return orders;


    }
}
