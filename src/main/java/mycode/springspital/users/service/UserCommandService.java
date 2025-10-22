package mycode.springspital.users.service;

import mycode.springspital.users.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserCommandService {
    void adaugaAdmin(String username, String emailContact);
    void adaugaClient(String username, String adresa);

}