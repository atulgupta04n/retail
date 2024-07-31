package com.nagarro.retail.discount.strategy;

import com.nagarro.retail.model.User;

public interface UserTypeDiscountI {

    public double getDiscountedAmount(User user, double amount);
}
