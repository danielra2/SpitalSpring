package mycode.springspital.users.service;

import mycode.springspital.users.exceptions.UserNameAlreadyExistsException;
import mycode.springspital.users.models.Admin;
import mycode.springspital.users.models.Client;
import mycode.springspital.users.models.User;
import mycode.springspital.users.repository.UserRepository;
import mycode.springspital.users.repository.UserRepositoryImpl;
import mycode.springspital.users.service.UserCommandService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class UserCommandServiceImpl implements UserCommandService {


    private UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }


    @Override
    public void adaugaAdmin(String username, String emailContact) throws UserNameAlreadyExistsException {
        User user=userRepository.findUserByName(username);
        if(user!=null){
            throw new UserNameAlreadyExistsException();
        }
        Admin adminNou = Admin.builder()
                .username(username)
                .emailContact(emailContact)
                .build();
        userRepository.save(adminNou);
    }

    @Override
    public void adaugaClient(String username, String adresa) {

        for (User existingUser : userRepository.getAllUsers()) {
            if (existingUser.getUsername().equalsIgnoreCase(username)) {
                throw new UserNameAlreadyExistsException();
            }
        }
        Client clientNou = Client.builder()
                .username(username)
                .adresa(adresa)
                .build();
        userRepository.save(clientNou);
    }

    //todo:implement adaugare de user



}