package org.example;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private String dateTime;
    private String company;
    private String quantity;

    public Order(String dateTime, String company, String quantity) {
        this.setDateTime(dateTime);
        this.setCompany(company);
        this.setQuantity(quantity);
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException("Дата и время не могут быть NULL");
        }
        this.dateTime = dateTime;
      }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public static List <Order> OrdersLoadFromFile (String fileName,List <Order> orders) {
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
        return orders;


    }

    public static void PrintOrders (List <Order> orders) {
        // метод для вывода списка заказов содержащихся в orders
        // перебор всех элементов
        for (Order o : orders) {
            System.out.println(o.getDateTime());
            System.out.println(o.getCompany());
            System.out.println(o.getQuantity());
            System.out.println("");

        }
    }

    }




