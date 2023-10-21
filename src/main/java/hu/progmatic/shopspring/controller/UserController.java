package hu.progmatic.shopspring.controller;

import hu.progmatic.shopspring.model.User;
import hu.progmatic.shopspring.service.CartService;
import hu.progmatic.shopspring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final CartService cartService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUsersById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "show-user";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("post_url", "/new");
        return "user-form";
    }
    @PostMapping("/new")
    public String newGuest(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Integer id){
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("post_url", "/edit/" + id);
        return "user-form";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/user";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteUserById(id);
        cartService.deleteCartByUserNumber(id);
        return "redirect:/reservation";
    }


}
