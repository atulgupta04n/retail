package com.nagarro.retail.discount.strategy;

import com.nagarro.retail.model.User;

import java.time.ZonedDateTime;

public class CustomerDiscount implements UserTypeDiscountI {

    @Override
    public double getDiscountedAmount(User user, double amount) {
        if (user.getJoiningDate().isBefore(ZonedDateTime.now().minusYears(2))) {
            return amount * 0.9;
        }
        else return amount;
    }

}
