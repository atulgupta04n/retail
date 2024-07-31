package com.nagarro.retail.discount.strategy;

import com.nagarro.retail.model.User;

public class AffiliateDiscount implements UserTypeDiscountI {

    @Override
    public double getDiscountedAmount(User user, double amount) {
        return amount * 0.9;
    }

}
