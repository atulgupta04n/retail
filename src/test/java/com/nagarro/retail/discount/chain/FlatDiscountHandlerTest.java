package com.nagarro.retail.discount.chain;

import com.nagarro.retail.discount.strategy.DiscountFactory;
import com.nagarro.retail.discount.strategy.UserTypeDiscountI;
import com.nagarro.retail.enums.UserType;
import com.nagarro.retail.model.Bill;
import com.nagarro.retail.model.Item;
import com.nagarro.retail.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

class FlatDiscountHandlerTest {

    private final FlatDiscountHandler flatDiscountHandler = new FlatDiscountHandler();


    private Bill bill;
    private User employeeUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeUser = new User(1L, "John Doe", UserType.EMPLOYEE, ZonedDateTime.now());
        Item item1 = new Item("Laptop", 500.0, false);
        Item item2 = new Item("Apple", 200.0, true);
        bill = new Bill(employeeUser, Arrays.asList(item1, item2),  null);
    }

    @Test
    public void testApplyDiscountOnEmployee() {
        double totalAmount = bill.getTotalAmount();
        double discountedAmount = flatDiscountHandler.handleDiscount(bill, totalAmount);

        assertEquals(665.0, discountedAmount, 0.01);
    }
}