package hu.progmatic.shopspring.repository;

import hu.progmatic.shopspring.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
    void removeByUserId(Integer id);
}
