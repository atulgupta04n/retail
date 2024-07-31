package com.nagarro.retail.model;

import com.nagarro.retail.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class User {
    private Long userId;
    private String userName;
    private UserType userType;
    private ZonedDateTime joiningDate;
}
