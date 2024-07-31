package com.nagarro.retail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {
    String itemName;
    double price;
    boolean isGrocery;
}
