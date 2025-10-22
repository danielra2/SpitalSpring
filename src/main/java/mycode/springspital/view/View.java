package mycode.springspital.view;

import mycode.springspital.pacienti.service.PacientCommandService;
import mycode.springspital.pacienti.service.PacientQuerryService;
import mycode.springspital.programari.service.ProgramariCommandService;
import mycode.springspital.programari.service.ProgramariQuerryService;
import mycode.springspital.spital.exceptions.SpitalTypeNotExistException;
import mycode.springspital.spital.models.Spital;
import mycode.springspital.spital.models.SpitalType;
import mycode.springspital.spital.services.SpitalCommandService;
import mycode.springspital.spital.services.SpitalCommandServiceImpl;
import mycode.springspital.spital.services.SpitalQuerryService;
import mycode.springspital.users.exceptions.UserNameAlreadyExistsException;
import mycode.springspital.users.repository.UserRepositoryImpl;
import mycode.springspital.users.service.UserCommandService;
import mycode.springspital.users.service.UserQuerryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class View {
    private SpitalCommandService spitalCommandService;
    private SpitalQuerryService spitalQuerryService;

    private PacientCommandService pacientCommandService;
    private PacientQuerryService pacientQuerryService;

    private ProgramariCommandService programariCommandService;
    private ProgramariQuerryService programariQuerryService;

    private UserCommandService userCommandService;
    private UserQuerryService userQuerryService;

    private UserRepositoryImpl userRepositoryImpl;

    private Scanner scanner;


    public View(SpitalCommandService spitalCommandService,SpitalQuerryService spitalQuerryService,PacientCommandService pacientCommandService,PacientQuerryService pacientQuerryService,ProgramariCommandService programariCommandService,ProgramariQuerryService programariQuerryService,UserCommandService userCommandService,UserQuerryService userQuerryService,UserRepositoryImpl userRepositoryImpl){



        this.spitalCommandService=spitalCommandService;
        this.spitalQuerryService=spitalQuerryService;

        this.pacientQuerryService=pacientQuerryService;
        this.pacientCommandService=pacientCommandService;

        this.programariCommandService=programariCommandService;
        this.programariQuerryService=programariQuerryService;

        this.userCommandService=userCommandService;
        this.userQuerryService=userQuerryService;

        this.userRepositoryImpl=userRepositoryImpl;

        this.scanner=new Scanner(System.in);


    }

    public void menu(){
        System.out.println("1->Afisare programari");
        System.out.println("2->Afisare Spitale");
        System.out.println("3->Afisare pacienti");
        System.out.println("4->Adauga programare");
        System.out.println("5->Adauga pacient");
        System.out.println("6->Afisare useri");
        System.out.println("7-> Afisare Spitale DUPA TIP");
        System.out.println("8->Adauga admin");
        System.out.println("9->Adauga client");
        System.out.println("0->Exit");
    }

    public void play(){
        boolean isRunning=true;
        while(isRunning){
            this.menu();
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    programariQuerryService.afisareProramari();
                    break;
                case 2:
                    spitalQuerryService.afisareSpitale();
                    break;
                case 3:
                    pacientQuerryService.afisarePacienti();
                    break;
                case 4:
                    viewAdaugaProgramare();
                    break;
                case 5:
                    viewAdaugaPacient();
                    break;
                case 6:
                    userQuerryService.afisareUseri();
                    break;
                case 7:
                    viewAfisareSpitaleDupaTip();
                    break;
                case 8:
                    viewAdaugaAdmin();
                    break;
                case 9:
                    viewAdaugaClient();
                    break;

                case 0:
                    isRunning=false;
                    System.out.println("Aplicatia se inchide");
                    break;
            }
        }

    }
    public void viewAdaugaProgramare(){
        System.out.println("id-ul pacientului: ");
        int pacient=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Data programarii: ");
        String data=scanner.nextLine();
        programariCommandService.adaugaProgramare(pacient,data);
    }

    public void viewAdaugaPacient(){
        System.out.println("Introduceti numele");
        String nume= scanner.nextLine();
        scanner.nextLine();
        System.out.println("Introduceti varsta");
        int varsta= scanner.nextInt();
        pacientCommandService.adaugaPacient(nume,varsta);

    }
    public void viewAfisareSpitaleDupaTip(){
        System.out.println("--- Tipuri disponibile: PEDIATRIE, STOMATOLOGIE ---");
        System.out.print("Introduceti tipul de spital: ");
        String tipString = scanner.nextLine().toUpperCase();
        try {
            List<Spital> spitaleFiltrate = spitalQuerryService.afisareSpitaleDupaTip(tipString);

            System.out.println("\n--- Spitale de tip " + tipString + " ---");
            if(spitaleFiltrate.isEmpty()){
                System.out.println("Nu exista spitalele de genul: "+tipString);
            }
            else{
                for(Spital spital:spitaleFiltrate){
                    System.out.println(spital);
                }
            }
        } catch (SpitalTypeNotExistException e) {
            e.printStackTrace();
        }


    }

    public void viewAdaugaAdmin(){
        try{
            System.out.print("Introduceti username-ul noului Admin: ");
            String adminUsername = scanner.nextLine();
            System.out.print("Introduceti email-ul de contact: ");
            String adminEmail = scanner.nextLine();
            userCommandService.adaugaAdmin(adminUsername, adminEmail);
            System.out.println(" Administratorul " + adminUsername + " a fost adaugat cu succes.");

        }catch (UserNameAlreadyExistsException e){
            e.printStackTrace();
        }

    }

    public void viewAdaugaClient(){
        try{
            System.out.print("Introduceti username-ul noului Client: ");
            String clientUsername = scanner.nextLine();
            System.out.print("Introduceti adresa clientului: ");
            String clientAdresa = scanner.nextLine();
            userCommandService.adaugaClient(clientUsername, clientAdresa);
            System.out.println(" Clientul " + clientUsername + " a fost adaugat cu succes.");

        }catch (UserNameAlreadyExistsException e){
            e.printStackTrace();
        }

    }


}
