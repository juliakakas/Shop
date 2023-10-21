package hu.progmatic.shopspring.service;

import hu.progmatic.shopspring.model.Cart;
import hu.progmatic.shopspring.repository.CartRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<Cart> findAllCart(String shop, String order, Integer price){
        return cartRepo.findAllCart(shop, order, price);
    }

    @Transactional
    public void deleteCartByUserId(Integer id) {
        cartRepo.removeByUserId(id);
    }



}
