package com.nagarro.retail.discount.chain;

import com.nagarro.retail.model.Bill;

public interface DiscountHandler {
    void nextHandler(DiscountHandler nextHandler);
    double handleDiscount(Bill bill, double amount);
}
