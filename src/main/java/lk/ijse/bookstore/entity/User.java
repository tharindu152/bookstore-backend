package lk.ijse.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 250, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String country;
    @Column(length = 50, nullable = false)
    private String street;
    @Column(length = 50, nullable = false)
    private String city;
    @Column(length = 50, nullable = false)
    private String state;
    @Column(name = "zip_code", length = 50, nullable = false)
    private String zipCode;
    @Column(name= "mobile_number", length = 50, nullable = false)
    private String mobileNumber;
    @Column(length = 50, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private Set<Order> orderSet;

    public User(String name, String country, String street, String city, String state, String zipCode, String mobileNumber, String email) {
        this.name = name;
        this.country = country;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
}

