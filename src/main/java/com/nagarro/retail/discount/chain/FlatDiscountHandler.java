package com.nagarro.retail.discount.chain;

import com.nagarro.retail.model.Bill;

public class FlatDiscountHandler implements DiscountHandler {
    private DiscountHandler nextHandler;

    @Override
    public void nextHandler(DiscountHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public double handleDiscount(Bill bill, double amount) {
        double totalAmount = bill.getTotalAmount();
        double flatDiscount = (int)(totalAmount / 100) * 5;
        amount -= flatDiscount;

        if (nextHandler != null) {
            amount = nextHandler.handleDiscount(bill, amount);
        }

        return amount;
    }
}
