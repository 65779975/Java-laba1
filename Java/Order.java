package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private List<Product> products;
    private double total;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Замовлення:\n");
        for (Product p : products) {
            sb.append(" - ").append(p).append("\n");
        }
        sb.append("Сума: ").append(total).append(" грн");
        return sb.toString();
    }
}
