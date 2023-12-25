package lk.ijse.bookstore.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sub_category")
public class SubCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "sub_cat_name", length = 250, nullable = false)
    private String subCatName;
    @Column(length = 750, nullable = false)
    private String description;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private Set<Book> bookSet;

    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Category category;

    public SubCategory(String subCatName, String description,  Category category) {
        this.description = description;
        this.subCatName = subCatName;
        this.category = category;
    }
}
