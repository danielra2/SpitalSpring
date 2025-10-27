package mycode.springspital.view;

import mycode.springspital.medici.exceptions.MedicNotFoundException;
import mycode.springspital.medici.models.Medici;
import mycode.springspital.medici.service.MedicCommandService;
import mycode.springspital.medici.service.MedicQuerryService;
import mycode.springspital.pacienti.exceptions.PacientNotFoundException;
import mycode.springspital.pacienti.models.Pacient;
import mycode.springspital.pacienti.service.PacientCommandService;
import mycode.springspital.pacienti.service.PacientQuerryService;
import mycode.springspital.programari.exceptions.MedicIdDoesntExist;
import mycode.springspital.programari.models.Programari;
import mycode.springspital.programari.service.ProgramariCommandService;
import mycode.springspital.programari.service.ProgramariQuerryService;
import mycode.springspital.spital.exceptions.SpitalTypeNotExistException;
import mycode.springspital.spital.models.Spital;
import mycode.springspital.spital.services.SpitalCommandService;
import mycode.springspital.spital.services.SpitalQuerryService;
import mycode.springspital.users.exceptions.UserNameAlreadyExistsException;
import mycode.springspital.users.models.User;
import mycode.springspital.users.repository.UserRepositoryImpl;
import mycode.springspital.users.service.UserCommandService;
import mycode.springspital.users.service.UserQuerryService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class AdminView implements ViewInterface {
    private final SpitalCommandService spitalCommandService;
    private final SpitalQuerryService spitalQuerryService;
    private final PacientCommandService pacientCommandService;
    private final PacientQuerryService pacientQuerryService;
    private final ProgramariCommandService programariCommandService;
    private final ProgramariQuerryService programariQuerryService;
    private final UserCommandService userCommandService;
    private final UserQuerryService userQuerryService;
    private final MedicQuerryService medicQuerryService;
    private final Scanner scanner;


    public AdminView(SpitalCommandService spitalCommandService, SpitalQuerryService spitalQuerryService, PacientCommandService pacientCommandService, PacientQuerryService pacientQuerryService, ProgramariCommandService programariCommandService, ProgramariQuerryService programariQuerryService, UserCommandService userCommandService, UserQuerryService userQuerryService, UserRepositoryImpl userRepositoryImpl, MedicQuerryService medicQuerryService, MedicCommandService medicCommandService) {
        this.spitalCommandService = spitalCommandService;
        this.spitalQuerryService = spitalQuerryService;
        this.pacientQuerryService = pacientQuerryService;
        this.pacientCommandService = pacientCommandService;
        this.programariCommandService = programariCommandService;
        this.programariQuerryService = programariQuerryService;
        this.userCommandService = userCommandService;
        this.userQuerryService = userQuerryService;
        this.medicQuerryService = medicQuerryService;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public User login() {
        return null;
    }

    @Override
    public void menu() {
        System.out.println("\n--- Meniu Admin ---");
        System.out.println("1->Afisare programari");
        System.out.println("2->Afisare Spitale");
        System.out.println("3->Afisare pacienti");
        System.out.println("4->Adauga programare");
        System.out.println("5->Adauga pacient");
        System.out.println("6->Afisare useri");
        System.out.println("7-> Afisare Spitale DUPA TIP");
        System.out.println("8->Adauga admin");
        System.out.println("9->Adauga client");
        System.out.println("10->Programarile unui pacient in functie de nume");
        System.out.println("11->Tori pacientii programati la un anumit medic");
        System.out.println("0->Logout");
    }

    @Override
    public void play() {
        boolean isRunning = true;
        while (isRunning) {
            this.menu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
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
                    case 10:
                        viewProgramarileUnuiPacientInFunctieDeNume();
                        break;
                    case 11:
                        viewTotiPacientiiProgramatiLaUnAnumitMedic();
                    case 0:
                        isRunning = false;
                        System.out.println("Admin-ul s-a delogat.");
                        break;
                    default:
                        System.out.println("Optiune invalida. Va rugam incercati din nou.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input invalid. Va rugam introduceti un numar.");
                scanner.nextLine();
            }
        }
    }

    public void viewAdaugaProgramare() {
        try {
            System.out.println("Numele pacientului: ");
            String nume = scanner.nextLine();
            Pacient pacient=pacientQuerryService.getPacientByNume(nume);
            System.out.println("Numele medicului: ");
            String numeMedic = scanner.nextLine();
            Medici medic = medicQuerryService.getMedicByName(numeMedic);
            int idMedic = medic.getId();
            int idPacient=pacient.getId();
            System.out.println("Data programarii: ");
            String data = scanner.nextLine();
            programariCommandService.adaugaProgramare(idPacient, idMedic, data);
            System.out.println("Programare adaugata cu succes la medicul " + numeMedic + ".");
        } catch (InputMismatchException e) {
            System.out.println("Eroare la citirea ID-ului: Va rugam introduceti un numar valid.");
            scanner.nextLine();
        } catch (MedicNotFoundException | PacientNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void viewAdaugaPacient() {
        System.out.println("Introduceti numele");
        String nume = scanner.nextLine();
        int varsta = 0;
        try {
            System.out.println("Introduceti varsta");
            varsta = scanner.nextInt();
            scanner.nextLine();
            pacientCommandService.adaugaPacient(nume, varsta);
            System.out.println("Pacientul cu numele "+ nume +" a fost adaugata cu succes");
        } catch (InputMismatchException e) {
            System.out.println("Eroare la citirea varstei: Va rugam introduceti un numar valid.");
            scanner.nextLine();
        }
    }
    public void viewAfisareSpitaleDupaTip() {
        System.out.println("--- Tipuri disponibile: PEDIATRIE, STOMATOLOGIE ---");
        System.out.print("Introduceti tipul de spital: ");
        String tipString = scanner.nextLine().toUpperCase();
        try {
            List<Spital> spitaleFiltrate=spitalQuerryService.afisareSpitaleDupaTip(tipString);

            System.out.println("Spitale de tip " + tipString);
            if (spitaleFiltrate.isEmpty()) {
                System.out.println("Nu exista spitalele de genul: " + tipString);
            } else {
                for (Spital spital : spitaleFiltrate) {
                    System.out.println(spital);
                }
            }
        } catch (SpitalTypeNotExistException e) {
            e.printStackTrace();
        }
    }
    public void viewAdaugaAdmin() {
        try {
            System.out.print("Introduceti username-ul noului Admin: ");
            String adminUsername = scanner.nextLine();
            System.out.print("Introduceti email-ul de contact: ");
            String adminEmail = scanner.nextLine();
            userCommandService.adaugaAdmin(adminUsername, adminEmail);
            System.out.println(" Administratorul "+adminUsername+" a fost adaugat cu succes.");

        } catch (UserNameAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
    public void viewAdaugaClient() {
        try {
            System.out.print("Introduceti username-ul noului Client: ");
            String clientUsername = scanner.nextLine();
            System.out.print("Introduceti adresa clientului: ");
            String clientAdresa = scanner.nextLine();
            userCommandService.adaugaClient(clientUsername, clientAdresa);
            System.out.println(" Clientul " + clientUsername + " a fost adaugat cu succes.");

        } catch (UserNameAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
    public void viewProgramarileUnuiPacientInFunctieDeNume() {
        System.out.println("Introduceti numele pacientului:");
        String numePacient = scanner.nextLine();
        try {
            Pacient pacient = pacientQuerryService.getPacientByNume(numePacient);
            if (pacient == null) {
                System.out.println("Eroare,pacientul nu a fost gasit");
            }
            int idPacient = pacient.getId();
            List<Programari> programariList = programariQuerryService.getAllByProgramariByPacientId(idPacient);
            System.out.println("Programarile pacientului: " + numePacient);
            if (programariList.isEmpty()) {
                System.out.println("Pacientul " + numePacient + " nu are programari");
            } else {
                for (Programari programare : programariList) {
                    Medici medic = medicQuerryService.findMediciById(programare.getIdMedic());
                    String numeMedic = (medic != null) ? medic.getNume() : "Medic Necunoscut";
                    System.out.printf("[ID: %d] cu %s (ID Medic: %d) la data: %s\n", programare.getIdProgramare(), numeMedic, programare.getIdMedic(), programare.getDataProgramare());
                }
            }
        }catch (PacientNotFoundException e){
            e.printStackTrace();
        }
    }
    public void viewTotiPacientiiProgramatiLaUnAnumitMedic(){
        System.out.println("Introduceti numele medicului la care vreti sa vedeti pacientii programati");
        String nume= scanner.nextLine();
        try {
            Medici medic = medicQuerryService.getMedicByName(nume);
            int id = medic.getId();
            List<Pacient> pacientList = pacientQuerryService.getPacientiByPacientiIdList(id);
            for (Pacient pacient : pacientList) {
                System.out.println(pacient);
            }
        }catch (MedicNotFoundException e){
            e.printStackTrace();
        }
    }
}