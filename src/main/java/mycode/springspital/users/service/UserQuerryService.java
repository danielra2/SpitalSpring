package mycode.springspital.users.service;

import mycode.springspital.users.models.User;
import org.springframework.stereotype.Component;
@Component
public interface UserQuerryService {
    void afisareUseri();
    User getUserByUserName(String name);
}