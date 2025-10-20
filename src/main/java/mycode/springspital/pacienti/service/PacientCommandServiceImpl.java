package mycode.springspital.pacienti.service;


import mycode.springspital.pacienti.models.Pacient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacientCommandServiceImpl implements PacientCommandService {
    private List<Pacient>pacientList;
    private int nextId;

    public PacientCommandServiceImpl(){
        this.pacientList=new ArrayList<>();
        load();
        this.nextId=pacientList.size()+1;

    }
    public void load(){
        Pacient pacient1=new Pacient("Ion",21,1);
        Pacient pacient2=new Pacient("Marria",12,2);

        pacientList.add(pacient1);
        pacientList.add(pacient2);
    }

    @Override
    public void adaugaPacient(String nume, int varsta) {
        Pacient pacient=Pacient.builder().nume(nume).varsta(varsta).id(nextId).build();
        pacientList.add(pacient);
        System.out.println("Pacient adaugat cu succes: "+pacient);
    }
    public List<Pacient> getPacientiList(){
        return this.pacientList;
    }
}
