package mycode.springspital.programari.service;

import mycode.springspital.programari.models.Programari;
import mycode.springspital.programari.repository.ProgramariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProgramariQuerryServiceImpl implements ProgramariQuerryService {

    private ProgramariRepository programariRepository;


    public ProgramariQuerryServiceImpl(ProgramariRepository programariRepository) {
        this.programariRepository=programariRepository;
    }
    @Override
    public void afisareProramari() {
        List<Programari> programariList = programariRepository.getAllProgramari();
        for(Programari programari:programariList){
            System.out.println(programari);
        }
    }

    @Override
    public List<Programari> getAllByProgramariByPacientId(int id) {
        List<Programari>programarilePacientului=new ArrayList<>();
        List<Programari>programariList=programariRepository.getAllProgramari();
        for(Programari programare:programariList){
            if(programare.getIdPacient()==id){
                programarilePacientului.add(programare);
            }
        }
        return programarilePacientului;
    }
}