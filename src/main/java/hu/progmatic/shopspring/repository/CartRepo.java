package hu.progmatic.shopspring.repository;

import hu.progmatic.shopspring.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
    List<Cart> findAllCart(String shop, String order, Integer price, Integer userNumber);

    void removeByUserNumber(Integer userNumber);
}
