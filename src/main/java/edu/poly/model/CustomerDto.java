package edu.poly.model;

import org.springframework.web.multipart.MultipartFile;

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
    private String confirmPassword;
    private String name;
    private String email;
    private String phoneNumber;
    private String photo;
    private MultipartFile imgFile;
    private boolean isActivated;
    private boolean isAdmin;
}
