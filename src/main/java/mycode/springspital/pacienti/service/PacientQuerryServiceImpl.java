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
}
