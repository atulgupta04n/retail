package com.nagarro.retail.model;

import com.nagarro.retail.discount.chain.DiscountHandler;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
public class Bill {
    User user;
    List<Item> items;
    DiscountHandler discountHandler;

    @Autowired
    public Bill(User user, List<Item> items, DiscountHandler discountHandler) {
        this.user = user;
        this.items = items;
        this.discountHandler = discountHandler;
    }

    public Double getTotalAmount() {
        return items.stream().mapToDouble(i -> i.price).sum();
    }

    public Double getGroceryAmount() {
        return items.stream().filter(Item::isGrocery)
                .mapToDouble(i -> i.price).sum();
    }

    public Double getNonGroceryAmount() {
        return items.stream().filter(i-> !i.isGrocery())
                .mapToDouble(i -> i.price).sum();
    }

    public Double getAmountPayable() {
        return discountHandler.handleDiscount(this, getTotalAmount());
    }

}
