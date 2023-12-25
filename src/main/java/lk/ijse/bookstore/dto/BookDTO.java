package lk.ijse.bookstore.dto;

import jakarta.validation.constraints.*;
import lk.ijse.bookstore.util.BookCoverImage;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.stream.events.Characters;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO implements Serializable {
    @Null(message = "Book ID is auto generated")
    private Integer id;
    @NotBlank(message = "Author Should not be empty")
    @Pattern(regexp = "^[A-Za-z0-9\\s.&]+$", message = "Author name contains invalid characters")
    private String author;
    @NotBlank(message = "Title Should not be empty")
    @Pattern(regexp = "^[A-Za-z0-9\\s.,!?()-:;'\"&]+$", message = "Book title contains invalid characters. Such as @, #, $, %, ^, _")
    private String title;
    @BookCoverImage
    private MultipartFile coverImage;
    @NotNull
    @Min(value = 0)
    @Max(value = 25)
    private Integer quantity;
    @NotNull
    @Min(value = 0)
    private BigDecimal price;
    @NotBlank(message = "Description Should not be empty")
    @Pattern(regexp = "^[A-Za-z0-9\\s.,!?@#$%^_()-:;'\"&]+$", message = "Book Description contains invalid Characters.")
    private String description;
    @Null
    private Boolean featured;
    @NotBlank
    @Pattern(regexp = "^(?:\\d{9}[\\d|X]|\\d{13})$", message = "ISBN is invalid")
    private String isbn;
    @NotNull
    private Integer subCategoryId;
}
