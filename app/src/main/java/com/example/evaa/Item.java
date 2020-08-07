package com.example.evaa;

public class Item {
    private String itemName;
    private String itemDate;

    public Item(String iName, String iDate) {
        itemName = iName;
        itemDate = iDate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDate() {
        return itemDate;
    }
}
