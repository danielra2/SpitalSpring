package mycode.springspital.users.repository;

import mycode.springspital.users.dtos.UserDto;
import mycode.springspital.users.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository {
    void load();
    List<User> getAllUsers();
    User findUserByName( String name);
    User save(User user);
    User findUserById(int id);
    void deleteUserById(int id);

}
