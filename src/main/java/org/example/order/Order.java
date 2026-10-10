package org.example.order;

import org.example.service.IncorrectInputException;

import java.time.LocalDateTime;

public class Order {
    private LocalDateTime dateTime;
    private String company;
    private int quantity;

    public Order(LocalDateTime dateTime, String company, int quantity) {
        this.setDateTime(dateTime);
        this.setCompany(company);
        this.setQuantity(quantity);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new IncorrectInputException("Дата и время не могут быть NULL");
        }
        this.dateTime = dateTime;
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




