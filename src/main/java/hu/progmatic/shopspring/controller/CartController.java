package hu.progmatic.shopspring.controller;

import hu.progmatic.shopspring.model.Cart;
import hu.progmatic.shopspring.service.CartService;
import hu.progmatic.shopspring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;
    private final UserService userService;

    @GetMapping
    public String getAllCarts(Model model) {
        model.addAttribute("carts", cartService.getAllCarts());
        return "carts";
    }


    @GetMapping("/new")
    public String createCart(Model model, @ModelAttribute("cart") Cart cart){
        System.out.println(cart);
        model.addAttribute("cart", cart);
        model.addAttribute("user", userService.getAllUsers());
        return "new-cart";
    }

    @PostMapping("/new")
    public String createCart(@ModelAttribute("cart") Cart cart){
        cartService.save(cart);
        return "redirect:/cart";
    }
}
