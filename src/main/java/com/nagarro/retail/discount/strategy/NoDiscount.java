package com.nagarro.retail.discount.strategy;

import com.nagarro.retail.model.User;

public class NoDiscount implements UserTypeDiscountI {

    @Override
    public double getDiscountedAmount(User user, double amount) {
        return amount;
    }

}
