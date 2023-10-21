package hu.progmatic.shopspring.service;

import hu.progmatic.shopspring.model.Cart;
import hu.progmatic.shopspring.model.User;
import hu.progmatic.shopspring.repository.CartRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepo cartRepo;

    public void save(Cart cart) {
        cartRepo.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepo.findAll();
    }

    public List<Cart> findAllCart(String shop, String order, Integer price, Integer userNumber){
        return cartRepo.findAllCart(shop, order, price, userNumber);
    }

    @Transactional
    public void deleteCartByUserNumber(Integer userNumber) {
        cartRepo.removeByUserNumber(userNumber);
    }



}
