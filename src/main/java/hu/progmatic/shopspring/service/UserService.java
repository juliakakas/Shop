package hu.progmatic.shopspring.service;

import hu.progmatic.shopspring.model.User;
import hu.progmatic.shopspring.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }

    @Transactional
    public void deleteUserById(Integer id) {
        userRepo.removeById(id);
    }
}
