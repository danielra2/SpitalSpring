package mycode.springspital.programari.service;

import mycode.springspital.programari.models.Programari;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProgramariCommandServiceImpl implements ProgramariCommandService {

    // Mutam datele aici (Mutarea logica)
    private List<Programari> programariList;
    private int nextId;

    public ProgramariCommandServiceImpl() {
        this.programariList = new ArrayList<>();
        load();
        this.nextId=programariList.size() + 1;
    }
    public void load() {
        Programari programare = Programari.builder().idProgramare(1).idPacient(1).dataProgramare("17-07-2005").build();
        Programari programare2 = Programari.builder().idProgramare(2).idPacient(2).dataProgramare("12-09-2022").build();

        programariList.add(programare);
        programariList.add(programare2);
    }

    @Override
    public void adaugaProgramare(int idPacient, String dataProgramare) {
        Programari programareNoua = Programari.builder()
                .idProgramare(nextId++)
                .idPacient(idPacient)
                .dataProgramare(dataProgramare)
                .build();
        programariList.add(programareNoua);
        System.out.println("Programare adaugata cu succes: "+programareNoua);
    }

    public List<Programari> getProgramariList() {
        return programariList;
    }
}