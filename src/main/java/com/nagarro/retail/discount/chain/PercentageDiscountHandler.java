package com.nagarro.retail.discount.chain;

import com.nagarro.retail.discount.strategy.DiscountFactory;
import com.nagarro.retail.discount.strategy.UserTypeDiscountI;
import com.nagarro.retail.model.Bill;
import com.nagarro.retail.model.User;

public class PercentageDiscountHandler implements DiscountHandler {

    private DiscountHandler nextHandler;

    @Override
    public void nextHandler(DiscountHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public double handleDiscount(Bill bill, double amount) {
        User user = bill.getUser();
        UserTypeDiscountI strategy = DiscountFactory.getDiscountStrategy(user.getUserType());
        amount = strategy.getDiscountedAmount(user, amount);

        if (nextHandler != null) {
            amount = nextHandler.handleDiscount(bill, amount);
        }

        return amount;
    }
}
