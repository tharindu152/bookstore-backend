package lk.ijse.bookstore.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "cat_name", length = 250, nullable = false)
    private String catName;
    @Column(length = 750, nullable = false)
    private String description;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private Set<SubCategory> subCategorySet;

    public Category( String catName, String description) {
        this.description = description;
        this.catName = catName;
    }
}
