package mycode.springspital.pacienti.service;

import mycode.springspital.pacienti.models.Pacient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacientQuerryServiceImpl implements PacientQuerryService{

    private List<Pacient> pacientList;

    public PacientQuerryServiceImpl(){
        this.pacientList=new ArrayList<>();

    }
    public void load(){
        Pacient pacient1=new Pacient("Ion",21,1);
        Pacient pacient2=new Pacient("Marria",12,2);

        pacientList.add(pacient1);
        pacientList.add(pacient2);
    }

    @Override
    public void afisarePacienti() {
        for (Pacient pacient:pacientList){
            System.out.println(pacient.getNume());
        }

    }
}
