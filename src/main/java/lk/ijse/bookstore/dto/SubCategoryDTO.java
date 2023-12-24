package lk.ijse.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDTO implements Serializable {
    @Null(message = "SubCategory ID is auto generated")
    private Integer id;
    @NotBlank(message = "Description Should not be empty")
    @Pattern(regexp = "^[A-Za-z0-9\\s.,!?@#$%^_()-:;'\"&]+$", message = "Sub Category Description contains invalid characters.")
    private String description;
    @NotBlank(message = "Sub category name Should not be empty")
    @Pattern(regexp = "^[A-Za-z\\s.&]+$", message = "Sub category name contains invalid characters")
    private String subCatName;
    @NotNull
    private Integer categoryId;
}
