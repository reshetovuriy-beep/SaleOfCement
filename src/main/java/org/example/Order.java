package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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


    }




