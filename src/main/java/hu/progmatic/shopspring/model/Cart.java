package hu.progmatic.shopspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String shop;
    private String product;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
