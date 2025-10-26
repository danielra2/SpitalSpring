package mycode.springspital.users.service;

import mycode.springspital.users.models.Admin;
import mycode.springspital.users.models.Client;
import mycode.springspital.users.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserCommandService {
    Admin adaugaAdmin(String username, String emailContact);
    Client adaugaClient(String username, String adresa);
    Admin stergeAdmin(int id);
    Client stergeClient(int id);

}