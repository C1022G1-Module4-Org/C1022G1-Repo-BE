//package com.example.applemanagement.dto.login;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class LoginDTO {
//    private String usernameOrEmail;
//    private String password;
//
//    public LoginDTO() {
//    }
//
//    public String getUsernameOrEmail() {
//        return usernameOrEmail;
//    }
//
//    public void setUsernameOrEmail(String usernameOrEmail) {
//        this.usernameOrEmail = usernameOrEmail;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public static void main(String[] args) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println(passwordEncoder.encode("admin"));
//        System.out.println(passwordEncoder.encode("user"));
//    }
//}
