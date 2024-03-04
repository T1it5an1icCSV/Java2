package reataurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Client {
    private ArrayList<String> menu;
    private ArrayList<String> cart;
    private HashMap<String, String> registeredUsers;

    public Client(ArrayList<String> menu) {
        this.menu = menu;
        this.cart = new ArrayList<>();
        this.registeredUsers = new HashMap<>();
        this.registeredUsers.put("a", "a");
        this.registeredUsers.put("client1", "client1");
    }

    public void viewMenu() {
        System.out.println("Меню:");
        for (int i = 0; i < this.menu.size(); i++) {
            System.out.println((i+1) + ". " + this.menu.get(i));
        }
    }

    public void placeOrder(ArrayList<String> menu) {
        System.out.println("Составление заказа:");
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        do {
            System.out.print("Введите номер блюда для добавления в заказ (0 для завершения): ");
            choice = scanner.nextLine();
            if (!choice.equals("0")) {
                int itemNumber = Integer.parseInt(choice);
                if (itemNumber > 0 && itemNumber <= menu.size()) {
                    this.cart.add(menu.get(itemNumber - 1));
                    System.out.println("Блюдо добавлено в заказ: " + menu.get(itemNumber - 1));
                } else {
                    System.out.println("Блюдо под номером " + itemNumber + " не найдено в меню.");
                }
            }
        } while (!choice.equals("0"));
        System.out.println("Заказ сохранен.");
    }

    public void viewCart() {
        System.out.println("Ваш заказ:");
        if (this.cart.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            for (int i = 0; i < this.cart.size(); i++) {
                System.out.println("Блюдо " + (i+1) + ": " + this.cart.get(i));
            }
        }
    }

    public void logout() {
        System.out.println("Выход из режима клиента.");
    }

    public boolean authenticate(String clientLogin, String clientPassword) {
        if (registeredUsers.containsKey(clientLogin)) {
            if (registeredUsers.get(clientLogin).equals(clientPassword)) {
                System.out.println("Вход выполнен как клиент.");
                return true;
            } else {
                System.out.println("Неправильный пароль.");
            }
        } else {
            System.out.println("Пользователь с логином " + clientLogin + " не найден.");
        }
        return false;
    }
}
