package org.example.service;

public interface Adapter {
    // Метод принимает сырую строку и возвращает массив из 3-х элементов: [Дата, Компания, Количество]
    String[] adapt(String line);
}