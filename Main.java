package org.example;

import reataurant.Admin;
import reataurant.Client;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> menu = new ArrayList<>();
        menu.add("курица запеченная");
        menu.add("медовый лосось");
        menu.add("мексиканский чили");
        menu.add("тыквенная лазанья");
        menu.add("манго-курри");
        menu.add("шафрановый ризотто");
        menu.add("тайский авокадо-кокосовый суп");
        menu.add("греческий салат с оливками и фетой");
        menu.add("хинкали");
        menu.add("хачапури");
        Admin admin = new Admin();
        Client client = new Client(menu);

        System.out.println("Добро пожаловать!");

        String role = "";
        do {
            System.out.print("Выберите роль (администратор/клиент/выход): ");
            role = scanner.nextLine();

            if (role.equalsIgnoreCase("администратор")) {
                System.out.print("Введите логин: ");
                String adminLogin = scanner.nextLine();
                System.out.print("Введите пароль: ");
                String adminPassword = scanner.nextLine();

                if (admin.authenticate(adminLogin, adminPassword)) {
                    admin.viewMenu();
                    String choice = "";
                    do {
                        System.out.println("\n1. Добавить блюдо в меню");
                        System.out.println("2. Удалить блюдо из меню");
                        System.out.println("3. Посмотреть заказы");
                        System.out.println("4. Выход");
                        System.out.print("Выберите действие: ");
                        choice = scanner.nextLine();
                        switch (choice) {
                            case "1":
                                System.out.print("Введите название блюда: ");
                                String newItem = scanner.nextLine();
                                admin.addItemToMenu(newItem);
                                break;
                            case "2":
                                System.out.print("Введите номер блюда для удаления: ");
                                int itemNumber = Integer.parseInt(scanner.nextLine());
                                admin.removeItemFromMenu(itemNumber);
                                break;
                            case "3":
                                admin.viewOrders();
                                break;
                            case "4":
                                admin.logout();
                                break;
                            default:
                                System.out.println("Некорректный выбор.");
                                break;
                        }
                    } while (!choice.equals("4"));
                } else {
                    System.out.println("Неверный логин или пароль.");
                }
            } else if (role.equalsIgnoreCase("клиент")) {
                System.out.print("Введите логин: ");
                String clientLogin = scanner.nextLine();
                System.out.print("Введите пароль: ");
                String clientPassword = scanner.nextLine();

                if (client.authenticate(clientLogin, clientPassword)) {
                    client.viewMenu();
                    String choice = "";
                    do {
                        System.out.println("\n1. Составить заказ");
                        System.out.println("2. Посмотреть корзину");
                        System.out.println("3. Выход");
                        System.out.print("Выберите действие: ");
                        choice = scanner.nextLine();
                        switch (choice) {
                            case "1":
                                client.placeOrder(menu);
                                break;
                            case "2":
                                client.viewCart();
                                break;
                            case "3":
                                client.logout();
                                break;
                            default:
                                System.out.println("Некорректный выбор.");
                                break;
                        }
                    } while (!choice.equals("3"));
                } else {
                    System.out.println("Неверный логин или пароль.");
                }
            } else if (!role.equalsIgnoreCase("выход")) {
                System.out.println("Некорректный выбор роли.");
            }
        } while (!role.equalsIgnoreCase("выход"));

        System.out.println("До свидания!");
    }
}
