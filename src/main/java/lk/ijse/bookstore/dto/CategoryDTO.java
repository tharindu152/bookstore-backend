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
public class CategoryDTO implements Serializable {
    @Null(message = "Category ID is auto generated")
    private Integer id;
    @NotBlank(message = "Description Should not be empty")
    @Pattern(regexp = "^[A-Za-z0-9\\s.,!?@#$%^_()-:;'\"&]+$", message = "Category Description contains invalid characters.")
    private String description;
    @NotBlank(message = "Category Should not be empty")
    @Pattern(regexp = "^[A-Za-z\\s.&]+$", message = "Category name contains invalid characters")
    private String catName;
}
