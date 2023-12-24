package lk.ijse.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    @Null(message = "User ID is auto generated")
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z\\s.&]+$", message = "User name contains invalid characters")
    private String name;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z\\s.&]+$", message = "Country contains invalid characters")
    private String country;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9\\s.,!?@#$%^_()-:;'\"&]+$", message = "Street contains invalid characters")
    private String street;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z\\s.&]+$", message = "City contains invalid characters")
    private String city;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z\\s.&]+$", message = "State contains invalid characters")
    private String state;
    @NotBlank
    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "State contains invalid characters") //12345 and 12345-6789
    private String zipCode;
    @NotBlank
    @Pattern(regexp = "^[0-9]{3}-[0-9]{7}$", message = "State contains invalid characters")
    private String mobileNumber;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Invalid email address")
    private String email;
}
