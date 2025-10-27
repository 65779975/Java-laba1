package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
    private String category; // нове поле

    @Override
    public String toString() {
        return id + ". " + name + " - " + price + " грн (Категорія: " + category + ")";
    }
}
