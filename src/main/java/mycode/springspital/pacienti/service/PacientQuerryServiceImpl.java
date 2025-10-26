package mycode.springspital.pacienti.service;

import mycode.springspital.pacienti.models.Pacient;
import mycode.springspital.pacienti.repository.PacientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacientQuerryServiceImpl implements PacientQuerryService{
    private PacientiRepository pacientiRepository;
    public PacientQuerryServiceImpl(PacientiRepository pacientiRepository){
        this.pacientiRepository=pacientiRepository;

    }

    @Override
    public void afisarePacienti() {
        List<Pacient>pacientList=pacientiRepository.getAllPacient();
        for (Pacient pacient:pacientList){
            System.out.println(pacient.getNume());
        }

    }

    @Override
    public Pacient getPacientById(int id) {
        List<Pacient>pacientList=pacientiRepository.getAllPacient();
        return pacientList.stream().filter(pacient -> pacient.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Pacient getPacientByNume(String nume) {
        List<Pacient>pacientList=pacientiRepository.getAllPacient();
        return pacientList.stream().filter(pacient -> pacient.getNume().equalsIgnoreCase(nume)).findFirst().orElse(null);
    }


}
