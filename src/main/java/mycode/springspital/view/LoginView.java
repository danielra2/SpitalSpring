package mycode.springspital.view;

import mycode.springspital.users.exceptions.UserDoesnotExistException;
import mycode.springspital.users.models.Client;
import mycode.springspital.users.models.User;
import mycode.springspital.users.service.UserCommandService;
import mycode.springspital.users.service.UserQuerryService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LoginView implements ViewInterface{
    private UserQuerryService userQuerryService;
    private UserCommandService userCommandService;
    private Scanner scanner;
    protected User user;
    private View view;

    public LoginView(UserQuerryService userQuerryService,UserCommandService userCommandService){
        this.userCommandService=userCommandService;
        this.userQuerryService=userQuerryService;
        scanner=new Scanner(System.in);
    }

    @Override
    public User login() {
        System.out.println("Buna ziua, introduceti numele userului cu care vreti sa va logati");
        String nume=scanner.nextLine();
        try{
            user=userQuerryService.getUserByUserName(nume);
            System.out.println("Bun venit, "+nume);

            if(user instanceof Client){
                view=new ClientView();

            }


        }catch (UserDoesnotExistException e){
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public void play() {
        boolean merge=true;
        while (merge){
            this.menu();
            int choice= scanner.nextInt();
            switch (choice){
                case 1:
                    login();
                    break;
                case 0:
                    merge=false;
                    break;
            }
        }

    }

    @Override
    public void menu() {
        System.out.println("1->Login");
        System.out.println("0->Iesi");

    }
}
