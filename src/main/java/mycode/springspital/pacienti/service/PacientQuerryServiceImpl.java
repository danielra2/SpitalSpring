package mycode.springspital.pacienti.service;

import mycode.springspital.pacienti.exceptions.PacientNotFoundException;
import mycode.springspital.pacienti.models.Pacient;
import mycode.springspital.pacienti.repository.PacientiRepository;
import mycode.springspital.programari.service.ProgramariQuerryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacientQuerryServiceImpl implements PacientQuerryService{
    private PacientiRepository pacientiRepository;
    private ProgramariQuerryService programariQuerryService;
    public PacientQuerryServiceImpl(PacientiRepository pacientiRepository,ProgramariQuerryService programariQuerryService){
        this.pacientiRepository=pacientiRepository;
        this.programariQuerryService=programariQuerryService;

    }

    @Override
    public void afisarePacienti() {
        List<Pacient>pacientList=pacientiRepository.getAllPacient();
        for (Pacient pacient:pacientList){
            System.out.println(pacient.getNume());
        }

    }

    @Override
    public Pacient getPacientById(int id) throws PacientNotFoundException {
        List<Pacient>pacientList=pacientiRepository.getAllPacient();
        return pacientList.stream().filter(pacient -> pacient.getId()==id).findFirst().orElseThrow(PacientNotFoundException::new);
    }

    @Override
    public Pacient getPacientByNume(String nume) throws PacientNotFoundException {
        List<Pacient>pacientList=pacientiRepository.getAllPacient();
        return pacientList.stream().filter(pacient -> pacient.getNume().equalsIgnoreCase(nume)).findFirst().orElseThrow(PacientNotFoundException::new);
    }

    @Override
    public List<Pacient> getPacientiByPacientiIdList(int medicId) {
        List<Integer>pacientiIdList=programariQuerryService.toateIdurilePacientilorCareAuUnAnumitMedicIdInProgramareaLor(medicId);
        List<Pacient>pacientListBuni=new ArrayList<>();
        List<Pacient>pacientList=pacientiRepository.getAllPacient();
        for(Pacient pacient:pacientList){
            if(pacientiIdList.contains(pacient.getId())){
                pacientListBuni.add(pacient);
            }
        }
        return pacientListBuni;
    }


}
