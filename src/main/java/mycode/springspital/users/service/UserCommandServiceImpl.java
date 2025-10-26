package mycode.springspital.users.service;

import mycode.springspital.users.exceptions.UserNameAlreadyExistsException;
import mycode.springspital.users.models.Admin;
import mycode.springspital.users.models.Client;
import mycode.springspital.users.models.User;
import mycode.springspital.users.repository.UserRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserCommandServiceImpl implements UserCommandService {


    private UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }


    @Override
    public Admin adaugaAdmin(String username, String emailContact) throws UserNameAlreadyExistsException {
        User user=userRepository.findUserByName(username);
        if(user!=null){
            throw new UserNameAlreadyExistsException();
        }
        Admin adminNou = Admin.builder()
                .username(username)
                .emailContact(emailContact)
                .build();
       return (Admin) userRepository.save(adminNou);
    }

    @Override
    public Client adaugaClient(String username, String adresa) {

        for (User existingUser : userRepository.getAllUsers()) {
            if (existingUser.getUsername().equalsIgnoreCase(username)) {
                throw new UserNameAlreadyExistsException();
            }
        }
        Client clientNou = Client.builder()
                .username(username)
                .adresa(adresa)
                .build();
         return (Client) userRepository.save(clientNou);
    }

    @Override
    public Admin stergeAdmin(int id) {
        User user=userRepository.findUserById(id);
        if(user!=null&&user instanceof Admin){
            userRepository.deleteUserById(id);
            return (Admin) user;
        }
        return null;


    }

    @Override
    public Client stergeClient(int id) {
        User user=userRepository.findUserById(id);
        if(user!=null&&user instanceof Client){
            userRepository.deleteUserById(id);
            return (Client) user;
        }
        return null;
    }


    //todo:implement adaugare de user



}