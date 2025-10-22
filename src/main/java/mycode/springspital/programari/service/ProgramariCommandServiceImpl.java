package mycode.springspital.programari.service;

import mycode.springspital.programari.models.Programari;
import mycode.springspital.programari.repository.ProgramariRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProgramariCommandServiceImpl implements ProgramariCommandService {

    private ProgramariRepository programariRepository;



    public ProgramariCommandServiceImpl(ProgramariRepository programariRepository) {
        this.programariRepository=programariRepository;
    }

    @Override
    public void adaugaProgramare(int idPacient, String dataProgramare) {
        Programari programari=Programari.builder().idPacient(idPacient).dataProgramare(dataProgramare).build();
        programariRepository.save(programari);


    }

    public List<Programari> getProgramariList() {
        return programariRepository.getAllProgramari();
    }

}