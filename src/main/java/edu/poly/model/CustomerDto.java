package edu.poly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private int customerId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String photo;
    private boolean isActivated;
    private boolean isAdmin;
}
