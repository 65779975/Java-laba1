package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product(1, "Ноутбук", 25000, "Електроніка"));
        catalog.add(new Product(2, "Смартфон", 15000, "Електроніка"));
        catalog.add(new Product(3, "Навушники", 2000, "Аксесуари"));
        catalog.add(new Product(4, "Клавіатура", 1200, "Аксесуари"));

        Cart cart = new Cart();
        int choice;

        do {
            System.out.println("\n=== МЕНЮ ІНТЕРНЕТ-МАГАЗИНУ ===");
            System.out.println("1. Переглянути каталог товарів");
            System.out.println("2. Додати товар у кошик");
            System.out.println("3. Переглянути кошик");
            System.out.println("4. Оформити замовлення");
            System.out.println("5. Видалити товар з кошику");
            System.out.println("6. Переглянути історію замовлень");
            System.out.println("7. Пошук товарів");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // споживаємо \n після числа

            switch (choice) {
                case 1:
                    System.out.println("Каталог товарів:");
                    for (Product p : catalog) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Введіть ID товару для додавання: ");
                    int idAdd = scanner.nextInt();
                    Product selected = catalog.stream()
                            .filter(p -> p.getId() == idAdd)
                            .findFirst()
                            .orElse(null);
                    if (selected != null) {
                        cart.addProduct(selected);
                    } else {
                        System.out.println("Товар з таким ID не знайдено.");
                    }
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    cart.checkout();
                    break;

                case 5:
                    System.out.print("Введіть ID товару для видалення: ");
                    int idDelete = scanner.nextInt();
                    cart.delete(idDelete);
                    break;

                case 6:
                    cart.viewOrderHistory();
                    break;

                case 7:
                    System.out.print("Введіть назву або категорію для пошуку: ");
                    String query = scanner.nextLine().toLowerCase();
                    List<Product> results = catalog.stream()
                            .filter(p -> p.getName().toLowerCase().contains(query)
                                    || p.getCategory().toLowerCase().contains(query))
                            .toList();

                    if (results.isEmpty()) {
                        System.out.println("Нічого не знайдено.");
                    } else {
                        System.out.println("Результати пошуку:");
                        for (Product p : results) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Дякуємо за відвідування магазину!");
                    break;

                default:
                    System.out.println("Невірний вибір, спробуйте ще раз.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
