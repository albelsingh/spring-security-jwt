package com.javatechnophile.jwt.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class EmployeeRequest {
    @NotNull(message = "Name shouldn't be null")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$",message = "Invalid mobile number")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
