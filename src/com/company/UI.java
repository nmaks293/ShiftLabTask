package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class UI {
    private String name;
    private Cart cart;
    private ItemsList itemsList;

    public UI(String name) {
        this.name = name;
        this.cart = new Cart();
        this.itemsList = new ItemsList();
        showInfo();
    }

    public void start() {
        boolean is_End = false;
        while (!is_End) {
            Scanner answer = new Scanner(System.in);
            String result = answer.next();
            switch (result) {
                case "Заказ":
                    writeOrder();
                    break;
                case "Добавить":
                    readOrder();
                    break;
                case "Товары":
                    showItems();
                    break;
                case "Инфо":
                    showInfo();
                    break;
                case "Готово":
                    is_End = true;
                    writeOrder();
                    break;
                default:
                    System.out.println("Некорректный запрос, попробуйте снова.");
                    break;
            }
        }
        System.out.println("Заказ сделан.");
    }

    public void showInfo() {
        System.out.println("Напишите \"Заказ\",чтобы увидеть свой заказ на текущий момент.");
        System.out.println("Напишите \"Добавить\",чтобы добавить в свой заказ нужные товары.");
        System.out.println("Напишите \"Товары\",чтобы посмотреть каталог имеющихся товаров.");
        System.out.println("Напишите \"Готово\",чтобы сделать заказ.");
        System.out.println("Напишите \"Инфо\",чтобы увидеть справку.");
    }

    public void showItems() {
        System.out.println("Название Цена");
        for (Map.Entry<String, Double> pair : ItemsList.getItemsList().entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public void readOrder() {
        Integer count;
        String product = "";
        System.out.println("Введите названия товаров и их количество, по окончании введите \"Стоп\".");

        while (!product.equals("Стоп")) {
            Scanner answer = new Scanner(System.in);
            product = answer.next();
            if (product.equals("Стоп")) {
                break;
            }
            count = answer.nextInt();

            if (!itemsList.isItemExist(product)) {
                System.out.println("Такого товара у нас, к сожалению, нету.");
            } else {
                cart.addItem(product, count);
            }
        }
        System.out.println("Товары добавлены, если вы ввели их верно.");
    }

    public void writeOrder() {
        String timeStamp = new SimpleDateFormat(" dd.MM.yyyy HH:mm").format(Calendar.getInstance().getTime());
        System.out.println("Заказ #12312 " + this.name + timeStamp + "\n");
        System.out.println("Название Цена Количество Сумма");
        for (Map.Entry<Item, Integer> pair : cart.getItemsCount().entrySet()) {
            Double cost = pair.getKey().getCost();
            Integer count = pair.getValue();
            System.out.print(pair.getKey().getName() + " " + cost + " " + count + " ");
            System.out.format("%.2f\n", count * cost);
        }
        System.out.format("\nИтого: %.2f\n", cart.getSummaryCost());
    }
}
