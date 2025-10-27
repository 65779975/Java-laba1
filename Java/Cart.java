package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();
    private List<Order> orderHistory = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " додано в кошик.");
    }

    public void viewCart() {
        if (products.isEmpty()) {
            System.out.println("Кошик порожній.");
        } else {
            System.out.println("Ваш кошик:");
            double total = 0;
            for (Product p : products) {
                System.out.println(p);
                total += p.getPrice();
            }
            System.out.println("Сума до сплати: " + total + " грн");
        }
    }

    public void checkout() {
        if (products.isEmpty()) {
            System.out.println("Кошик порожній. Додайте товари перед замовленням.");
        } else {
            double total = 0;
            for (Product p : products) {
                total += p.getPrice();
            }
            Order order = new Order(new ArrayList<>(products), total);
            orderHistory.add(order);

            System.out.println("Замовлення оформлено! Дякуємо за покупку.");
            products.clear();
        }
    }

    public void delete(int productId) {
        if (products.isEmpty()) {
            System.out.println("Кошик порожній, видалити товар неможливо.");
            return;
        }

        Product toRemove = null;
        for (Product p : products) {
            if (p.getId() == productId) {
                toRemove = p;
                break;
            }
        }

        if (toRemove != null) {
            products.remove(toRemove);
            System.out.println(toRemove.getName() + " видалено з кошика.");
        } else {
            System.out.println("Товар з таким ID у кошику не знайдено.");
        }
    }

    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("Історія замовлень порожня.");
        } else {
            System.out.println("=== Історія замовлень ===");
            for (int i = 0; i < orderHistory.size(); i++) {
                System.out.println("Замовлення #" + (i + 1));
                System.out.println(orderHistory.get(i));
                System.out.println("-------------------");
            }
        }
    }
}
