package com.nagarro.retail.discount.strategy;

import com.nagarro.retail.enums.UserType;
import com.nagarro.retail.model.Bill;
import com.nagarro.retail.model.Item;
import com.nagarro.retail.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeDiscountTest {
    private EmployeeDiscount employeeDiscount;

    @BeforeEach
    public void setUp() {
        employeeDiscount = new EmployeeDiscount();
    }

    @Test
    public void testApplyDiscount() {
        User employee = new User(1L, "John Doe", UserType.EMPLOYEE, ZonedDateTime.now());
        Item item1 = new Item("Laptop", 500.0, false);
        Item item2 = new Item("Apple", 200.0, true);
        Bill bill = new Bill(employee, Arrays.asList(item1, item2), null);
        double discountedAmount = employeeDiscount.getDiscountedAmount(employee, bill.getNonGroceryAmount());
        assertEquals(350.0, discountedAmount, 0.01);
    }
}