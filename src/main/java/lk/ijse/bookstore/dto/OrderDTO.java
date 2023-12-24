package lk.ijse.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lk.ijse.bookstore.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {
    @Null(message = "Order ID is auto generated")
    private Integer id;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updateAt;
    @NotBlank
    @Pattern(regexp = "^(completed|pending)", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid order status")
    private String status;
    @NotNull
    private Set<Book> bookSet;
    @NotNull
    private Integer userId;
}
