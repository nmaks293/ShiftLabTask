package com.company;

import java.util.*;

public class ItemsList {
    private static Map<String, Double> itemsList;

    public ItemsList() {
        this.itemsList = new TreeMap<String, Double>();
        Item agava = new Item("Агава", 55.6d);
        Item banana = new Item("Банан", 19.2d);
        Item bumaga = new Item("Бумага", 17.1d);
        Item pen = new Item("Ручка", 10.9d);
        Item pencil = new Item("Карандаш", 7.0d);
        addItem(agava);
        addItem(banana);
        addItem(bumaga);
        addItem(pen);
        addItem(pencil);
    }

    public void addItem(Item item) {
        itemsList.put(item.getName(), item.getCost());
    }

    public static Double getItemCost(String name) {
        return itemsList.get(name);
    }

    public static Map<String, Double> getItemsList() {
        return itemsList;
    }

    public boolean isItemExist(String name){
        return itemsList.containsKey(name);
    }

}
