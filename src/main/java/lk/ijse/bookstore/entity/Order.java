package lk.ijse.bookstore.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`order`")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updateAt;
    @Column(length = 50, nullable = false)
    private String status;

    @ManyToMany
    @JoinTable(name = "order_book",
    joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private Set<Book> bookSet;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private User user;

    public Order(LocalDateTime createdAt, LocalDateTime updateAt, String status, Set<Book> bookSet, User user) {
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.status = status;
        this.bookSet = bookSet;
        this.user = user;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updateAt = LocalDateTime.now();
    }

}
