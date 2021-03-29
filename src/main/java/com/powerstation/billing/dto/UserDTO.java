package com.powerstation.billing.dto;

import lombok.Data;

@Data
public class UserDTO {

    private int userId;
    private String username;
    private String name;
    private String Surname;
    private String cardNumber;
    private String expirationDate;
    private String CVC;

}
