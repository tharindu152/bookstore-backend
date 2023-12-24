package lk.ijse.bookstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 250, nullable = false)
    private String author;
    @Column(length = 250, nullable = false)
    private String title;
    @Column(name = "cover_image", length = 1500)
    private String coverImage;
    @Column(nullable = false)
    private int qty;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(length = 1000, nullable = false)
    private String description;
    @Column(length = 50)
    private String isbn;
    @Column(columnDefinition = "boolean default false")
    private Boolean featured;

    @ManyToMany(mappedBy = "bookSet", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private Set<Order> orderSet;

    @ManyToOne
    @JoinColumn(name = "sub_cat_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private SubCategory subCategory;

    public Book(String author, String title, String coverImage, int qty, BigDecimal price, String description, String isbn, SubCategory subCategory) {
        this.author = author;
        this.title = title;
        this.coverImage = coverImage;
        this.qty = qty;
        this.price = price;
        this.description = description;
        this.isbn = isbn;
//        this.featured = featured;
        this.subCategory = subCategory;
    }
}
