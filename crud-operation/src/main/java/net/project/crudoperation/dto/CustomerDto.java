package net.project.crudoperation.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long id;

    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name should contain only alphabetic characters")
    @Size(max = 250, message = "length of the name is too large")
    private String firstName;
    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name should contain only alphabetic characters")
    @Size(max = 250, message = "length of the name is too large")
    private String lastName;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 250, message = "length of the email is too large")
    private String email;
    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must be at least 8 characters long and contain at least one letter and one digit")
    @Size(max = 250, message = "length of the password is too large")
    private String password;
}
