package com.nagarro.retail.model;

import com.nagarro.retail.discount.chain.DiscountHandler;
import com.nagarro.retail.enums.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BillTest {
    @Mock
    private DiscountHandler discountHandler;

    @InjectMocks
    private Bill bill;

    private User employeeUser;
    private User affiliateUser;
    private User customerUser;
    private User regularUser;
    private Item item1;
    private Item item2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        item1 = new Item("Laptop", 500.0, false);
        item2 = new Item("Apple", 200.0, true);
    }

    @Test
    public void testEmployeeBill() {
        employeeUser = new User(1L,"John Doe", UserType.EMPLOYEE, ZonedDateTime.now());
        bill = new Bill(employeeUser, Arrays.asList(item1, item2), discountHandler);

        when(discountHandler.handleDiscount(bill, 700.0)).thenReturn(515.0);

        assertEquals(515.0, bill.getAmountPayable(), 0.01);
    }

    @Test
    public void testAffiliateBill() {
        affiliateUser = new User(2L,"Jane Doe", UserType.AFFILIATE, ZonedDateTime.now());
        bill = new Bill(affiliateUser, Arrays.asList(item1, item2), discountHandler);

        when(discountHandler.handleDiscount(bill, 700.0)).thenReturn(615.0);

        assertEquals(615.0, bill.getAmountPayable(), 0.01);
    }

    @Test
    public void testCustomerBill() {
        customerUser = new User(3L,"Jane Doe", UserType.CUSTOMER, ZonedDateTime.now());
        bill = new Bill(customerUser, Arrays.asList(item1, item2), discountHandler);

        when(discountHandler.handleDiscount(bill, 700.0)).thenReturn(665.0);

        assertEquals(665.0, bill.getAmountPayable(), 0.01);
    }

    @Test
    public void testNoDiscountBill() {
         regularUser = new User(4L,"Jane Doe", UserType.REGULAR, ZonedDateTime.now());
        bill = new Bill(regularUser, Arrays.asList(item1, item2), discountHandler);

        when(discountHandler.handleDiscount(bill, 700.0)).thenReturn(665.0);

        assertEquals(665.0, bill.getAmountPayable(), 0.01);
    }
}