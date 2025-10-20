package mycode.springspital.view;

import mycode.springspital.pacienti.service.PacientCommandService;
import mycode.springspital.pacienti.service.PacientQuerryService;
import mycode.springspital.programari.service.ProgramariCommandService;
import mycode.springspital.programari.service.ProgramariQuerryService;
import mycode.springspital.spital.services.SpitalCommandService;
import mycode.springspital.spital.services.SpitalCommandServiceImpl;
import mycode.springspital.spital.services.SpitalQuerryService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class View {
    private SpitalCommandService spitalCommandService;
    private SpitalQuerryService spitalQuerryService;

    private PacientCommandService pacientCommandService;
    private PacientQuerryService pacientQuerryService;

    private ProgramariCommandService programariCommandService;
    private ProgramariQuerryService programariQuerryService;

    private Scanner scanner;


    public View(SpitalCommandService spitalCommandService,SpitalQuerryService spitalQuerryService,PacientCommandService pacientCommandService,PacientQuerryService pacientQuerryService,ProgramariCommandService programariCommandService,ProgramariQuerryService programariQuerryService){



        this.spitalCommandService=spitalCommandService;
        this.spitalQuerryService=spitalQuerryService;

        this.pacientQuerryService=pacientQuerryService;
        this.pacientCommandService=pacientCommandService;

        this.programariCommandService=programariCommandService;
        this.programariQuerryService=programariQuerryService;

        this.scanner=new Scanner(System.in);
    }

    public void menu(){
        System.out.println("1->Afisare programari");
        System.out.println("2->Afisare Spitale");
        System.out.println("3->Afisare pacienti");
        System.out.println("4->Adauga programare");
        System.out.println("5->Adauga pacient");
        System.out.println("0->Exit");
    }

    public void play(){
        boolean isRunning=true;
        while(isRunning){
            this.menu();
            int choice=scanner.nextInt();
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

    }


}
