package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String date;
    private String time;
    private String company;
    private int quantity;

    public Order(String date, String time, String company, int quantity) {
        this.date = date;
        this.time = time;
        this.company = company;
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date == null) {
            System.out.println("Дата не может быть NULL");
        } this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    }




