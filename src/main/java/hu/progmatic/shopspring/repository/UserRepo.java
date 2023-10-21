package hu.progmatic.shopspring.repository;

import hu.progmatic.shopspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findAllUser(String name,String birthPlace, LocalDate birthDate, String email);
    void removeById(Integer id);
}
