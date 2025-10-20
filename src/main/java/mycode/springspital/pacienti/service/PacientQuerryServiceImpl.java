package mycode.springspital.pacienti.service;

import mycode.springspital.pacienti.models.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacientQuerryServiceImpl implements PacientQuerryService{
    private PacientCommandServiceImpl pacientCommandService;



    @Autowired
    public PacientQuerryServiceImpl(PacientCommandServiceImpl pacientCommandService){
        this.pacientCommandService=pacientCommandService;

    }

    @Override
    public void afisarePacienti() {
        List<Pacient>pacientList=pacientCommandService.getPacientiList();
        for (Pacient pacient:pacientList){
            System.out.println(pacient.getNume());
        }

    }
}
