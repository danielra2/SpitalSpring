package mycode.springspital.users.repository;

import mycode.springspital.users.models.UserTypes;
import mycode.springspital.users.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
@Component
public class UserRepositoryImpl implements UserRepository{
    private List<User> userList;

    public UserRepositoryImpl(){
        this.userList=new ArrayList<>();
        load();
    }
    private int getMaxId() {
        if (userList.isEmpty()) {
            return 0;
        }

        return userList.stream()
                .mapToInt(User::getId)
                .max()
                .orElse(0);
    }

    @Override
    public void load() {
        File file=new File("C:\\mycode\\spring\\SpringSpital\\src\\main\\java\\mycode\\springspital\\users\\data\\users.txt");
        try{
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[]parti=line.split(",");
                UserTypes tip= UserTypes.valueOf(parti[0]);
                // Presupunem ca exista User.fabricaUser in clasa User
                User user= User.fabricaUser(tip,line);
                if(user!=null){
                    this.userList.add(user);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> getAllUsers() {
        return this.userList;
    }

    @Override
    public User findUserByName(String name) {
        for(User user:userList){
            if(user.getUsername().equals(name)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User save(User user) {
        int nextId = getMaxId() + 1;
        user.setId(nextId);
        this.userList.add(user);
        return user;
    }
}