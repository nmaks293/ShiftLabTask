package com.company;

public class Item implements Comparable<Item> {
    private String name;
    private Double cost;


    public Item(String name, Double cost) {
        this.name = name;
        this.cost = cost;
    }

    public Item(String name) {
        this.name = name;
        this.cost = ItemsList.getItemCost(name);
    }

    public Double getCost() {
        return this.cost;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Item item) {
        return this.name.compareTo(item.name);
    }
}
