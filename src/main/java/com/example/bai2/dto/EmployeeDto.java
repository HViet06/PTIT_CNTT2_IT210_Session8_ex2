
package com.example.bai2.dto;

import jakarta.validation.constraints.*;

public class EmployeeDto {

    @Min(value = 18, message = "Tuổi phải >= 18")
    @Max(value = 60, message = "Tuổi phải <= 60")
    private int age;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;


    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}