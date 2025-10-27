package mycode.springspital.view;

import mycode.springspital.medici.exceptions.MedicNotFoundException;
import mycode.springspital.medici.models.Medici;
import mycode.springspital.medici.service.MedicQuerryService;
import mycode.springspital.pacienti.exceptions.PacientNotFoundException;
import mycode.springspital.pacienti.models.Pacient;
import mycode.springspital.pacienti.service.PacientCommandService;
import mycode.springspital.pacienti.service.PacientQuerryService;
import mycode.springspital.programari.models.Programari;
import mycode.springspital.programari.service.ProgramariCommandService;
import mycode.springspital.programari.service.ProgramariQuerryService;
import mycode.springspital.spital.services.SpitalCommandService;
import mycode.springspital.spital.services.SpitalQuerryService;
import mycode.springspital.users.models.Client;
import mycode.springspital.users.models.User;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class ClientView implements ViewInterface {

    private final SpitalQuerryService spitalQuerryService;
    private final PacientCommandService pacientCommandService;
    private final PacientQuerryService pacientQuerryService;
    private final ProgramariCommandService programariCommandService;
    private final ProgramariQuerryService programariQuerryService;
    private final MedicQuerryService medicQuerryService;
    private final Scanner scanner;
    private int currentPacientId=-1;
    private String currentPacientName="Necunoscut";


    public ClientView(SpitalCommandService spitalCommandService, SpitalQuerryService spitalQuerryService, PacientCommandService pacientCommandService, PacientQuerryService pacientQuerryService, ProgramariCommandService programariCommandService, ProgramariQuerryService programariQuerryService, MedicQuerryService medicQuerryService, Client client) {

        this.spitalQuerryService = spitalQuerryService;
        this.pacientQuerryService = pacientQuerryService;
        this.pacientCommandService = pacientCommandService;
        this.programariCommandService = programariCommandService;
        this.programariQuerryService = programariQuerryService;
        this.medicQuerryService = medicQuerryService;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public User login() {
        return null;
    }
    public void setCurrentUser(Client client){
        this.currentPacientId= client.getId();
        this.currentPacientName=client.getUsername();

    }

    @Override
    public void menu() {
        System.out.println("\n--- Meniu Client ---");;
        System.out.println("1->Afisare Spitale");
        System.out.println("2->Afisare pacienti");
        System.out.println("3->Adauga programare");
        System.out.println("4->Programarile mele");
        System.out.println("0->Logout");
    }
    @Override
    public void play() {

        boolean isRunning = true;
        while (isRunning){
            this.menu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        spitalQuerryService.afisareSpitale();
                        break;
                    case 2:
                        pacientQuerryService.afisarePacienti();
                        break;
                    case 3:
                        viewAdaugaProgramare();
                        break;
                    case 4:
                        viewProgramarileClientuluiAutentificat();
                        break;
                    case 0:
                        isRunning = false;
                        System.out.println("Clientul s-a delogat.");
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
        } catch (PacientNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void viewProgramarileClientuluiAutentificat() {
        System.out.println("Programarile clientului: " + this.currentPacientName + " User: " + this.currentPacientId);

        List<Programari> programariList = programariQuerryService.getAllByProgramariByPacientId(this.currentPacientId);
        if (programariList.isEmpty()) {
            System.out.println("Nu aveti programari inregistrate.");
        } else {
            for (Programari programare : programariList) {
                Medici medic = medicQuerryService.findMediciById(programare.getIdMedic());
                String numeMedic=(medic != null) ? medic.getNume():"Medic Necunoscut";
                System.out.printf("[ID: %d] cu %s (ID Medic: %d) la data: %s\n", programare.getIdProgramare(), numeMedic, programare.getIdMedic(), programare.getDataProgramare());
            }
        }
    }
}