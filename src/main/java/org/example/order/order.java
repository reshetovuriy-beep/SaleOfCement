package org.example.order;

import java.time.LocalDateTime;

public class order {
    private LocalDateTime dateTime;
    private String company;
    private int quantity;

    public order(LocalDateTime dateTime, String company, int quantity) {
        this.setDateTime(dateTime);
        this.setCompany(company);
        this.setQuantity(quantity);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}




