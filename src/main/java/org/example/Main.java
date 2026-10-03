package org.example;

import java.util.ArrayList;
import java.util.List;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();

        // 1. Получаем поток данных из файла через ClassLoader
        // Имя файла должно начинаться со слэша "/" для поиска в корне ресурсов
        InputStream inputStream = Main.class.getResourceAsStream("/discount_day.txt");

        if (inputStream == null) {
            System.err.println("Ошибка: Файл discount_day.txt не найден в ресурсах!");
            return;
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

                    // Проверка: должно быть ровно 3 поля
                    if (parts.length != 3) {
                        throw new IllegalArgumentException("Неверное количество полей (ожидалось 3, найдено " + parts.length + ")");
                    }

                    String dateTime = parts[0];
                    String company = parts[1];
                    String quantity = parts[2];

                    // 4. Создаем объект Order и добавляем в список
                    Order order = new Order(dateTime, company, quantity);
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

        // перебор всех элементов
        for (Order o : orders) {
            System.out.println(o.getDateTime());
            System.out.println(o.getCompany());
            System.out.println(o.getQuantity());
            System.out.println("");

//        order.add(new Order(null, "16:00:22", "Industrial", 8800));   // добавляем в конец
//        order.add(new Order(null,"16:00:22", "Industrial", 8800));   // добавляем в конец
//        order.add(new Order("2021-02-09","08:42:59", "Power Engineer", 17480));




        }

    }
}