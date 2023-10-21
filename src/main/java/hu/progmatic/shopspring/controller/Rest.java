package hu.progmatic.shopspring.controller;

import hu.progmatic.shopspring.model.Cart;
import hu.progmatic.shopspring.model.User;
import hu.progmatic.shopspring.service.CartService;
import hu.progmatic.shopspring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class Rest {
    private final UserService userService;
    private final CartService cartService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

}