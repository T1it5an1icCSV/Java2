package reataurant;

import java.util.ArrayList;
import java.util.HashMap;

public class Admin {
    private ArrayList<String> menu;
    private ArrayList<String> orders;
    private HashMap<String, String> registeredUsers;

    public Admin() {
        this.menu = new ArrayList<>();
        this.menu.add("медовый лосось");
        this.menu.add("мексиканский чили");
        this.menu.add("мексиканский чили");
        this.menu.add("тыквенная лазанья");
        this.menu.add("манго-курри");
        this.menu.add("шафрановый ризотто");
        this.menu.add("тайский авокадо-кокосовый суп");
        this.menu.add("греческий салат с оливками и фетой");
        this.menu.add("хинкали");
        this.menu.add("хачапури");
        this.orders = new ArrayList<>();
        this.registeredUsers = new HashMap<>();
        this.registeredUsers.put("admin", "admin");
        this.registeredUsers.put("admin1", "admin1");
    }

    public void viewMenu() {
        System.out.println("Меню:");
        for (int i = 0; i < this.menu.size(); i++) {
            System.out.println((i+1) + ". " + this.menu.get(i));
        }
    }

    public void addItemToMenu(String item) {
        this.menu.add(item);
        System.out.println("Блюдо добавлено в меню: " + item);
    }

    public void removeItemFromMenu(int itemNumber) {
        if (itemNumber > 0 && itemNumber <= this.menu.size()) {
            String removedItem = this.menu.remove(itemNumber - 1);
            System.out.println("Блюдо удалено из меню: " + removedItem);
        } else {
            System.out.println("Блюдо под номером " + itemNumber + " не найдено в меню.");
        }
    }

    public void viewOrders() {
        System.out.println("Заказы:");
        if (this.orders.isEmpty()) {
            System.out.println("Нет активных заказов.");
        } else {
            for (int i = 0; i < this.orders.size(); i++) {
                System.out.println("Заказ " + (i+1) + ": " + this.orders.get(i));
            }
        }
    }

    public void logout() {
        System.out.println("Выход из режима администратора.");
    }

    public boolean authenticate(String adminLogin, String adminPassword) {
        if (registeredUsers.containsKey(adminLogin)) {
            if (registeredUsers.get(adminLogin).equals(adminPassword)) {
                System.out.println("Вход выполнен как администратор.");
                return true;
            } else {
                System.out.println("Неправильный пароль.");
            }
        } else {
            System.out.println("Пользователь с логином " + adminLogin + " не найден.");
        }
        return false;
    }
}
