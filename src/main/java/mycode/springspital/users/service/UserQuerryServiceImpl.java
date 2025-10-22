package mycode.springspital.users.service;

import mycode.springspital.users.models.User;
import mycode.springspital.users.models.Admin;
import mycode.springspital.users.models.Client;
import mycode.springspital.users.repository.UserRepositoryImpl;
import mycode.springspital.users.service.UserQuerryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuerryServiceImpl implements UserQuerryService {

    private UserRepositoryImpl userRepositoryImpl;

    @Autowired
    public UserQuerryServiceImpl(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl=userRepositoryImpl;
    }

    @Override
    public void afisareUseri(){
        List<User> userList = userRepositoryImpl.getAllUsers();
        System.out.println(" Lista Utilizatori ");
        if (userList.isEmpty()) {
            System.out.println("Nu exista utilizatori inregistrati.");
            return;
        }
        for(User user:userList){
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                System.out.println("ADMIN "+admin);
            } else if (user instanceof Client) {
                Client client = (Client) user;
                System.out.println( "CLIENT" + client);
            } else {
                System.out.println("USER " + user);
            }
        }
    }
}