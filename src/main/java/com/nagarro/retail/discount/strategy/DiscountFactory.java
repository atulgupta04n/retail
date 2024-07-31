package com.nagarro.retail.discount.strategy;

import com.nagarro.retail.enums.UserType;

import java.util.HashMap;
import java.util.Map;

public class DiscountFactory {

    private static  final Map<UserType, UserTypeDiscountI> map = new HashMap<>();

    static {
        map.put(UserType.EMPLOYEE, new EmployeeDiscount());
        map.put(UserType.CUSTOMER, new CustomerDiscount());
        map.put(UserType.AFFILIATE, new AffiliateDiscount());
        map.put(UserType.REGULAR, new NoDiscount());
    }

    public static UserTypeDiscountI getDiscountStrategy(UserType userType) {
        return map.getOrDefault(userType,new NoDiscount());
    }
}
