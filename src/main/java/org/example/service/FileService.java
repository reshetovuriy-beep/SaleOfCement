package org.example.service;

import org.example.Main;
import org.example.order.Order;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.example.service.FileParser;


public class FileService {

    public static List<Order> ordersLoadFromFile (String fileName, List <Order> orders) {
        //метод для загрузки списка заказов из файла


        // 1. Получаем поток данных из файла через ClassLoader
        // Имя файла должно начинаться со слэша "/" для поиска в корне ресурсов
        InputStream inputStream = Main.class.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IncorrectInputException("Ошибка: Файл " + fileName + " не найден в ресурсах!");
        }
        FileParser fileParser = new FileParser(new AdapterPipeLine());

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
                // 3. Создаем объект Order и добавляем в список
                orders.add(fileParser.orderParse(line));




            }
            // 4. Проверка результата
            System.out.println("Успешно загружено заказов: " + orders.size());
            return orders;
        }
    }
    }

