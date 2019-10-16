package com.company;

import java.util.*;

public class Cart {
    private Map<Item, Integer> itemsCount;
    private Date lastUpdate;
    private Double summaryCost;

    public Cart() {
        this.summaryCost = 0d;
        this.itemsCount = new TreeMap<Item, Integer>();
        this.lastUpdate = new Date();
    }

    public Double getSummaryCost() {
        return summaryCost;
    }

    public void addItem(String name, Integer count) {
        Item newItem = new Item(name);
        lastUpdate = new Date();
        if (itemsCount.containsKey(newItem)) {
            itemsCount.put(newItem, itemsCount.get(newItem) + count);
        } else {
            itemsCount.put(newItem, count);
        }
        summaryCost += newItem.getCost() * count;
    }

    public Map<Item, Integer> getItemsCount() {
        return itemsCount;
    }
}
