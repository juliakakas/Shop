package hu.progmatic.shopspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String shop;
    private String oder;
    private Integer price;
    private Integer userNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
