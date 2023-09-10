package lk.ijse.bookstore.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreateDTO {
    private MultipartFile coverImage;
    private String title;
    private String author;
    private String ISBN10;
    private String description;
    private Double price;
    private int quantity;
    // private boolean featured;
    // private SubCategory subCategory;
}
