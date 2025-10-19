package mycode.springspital.programari.service;

import mycode.springspital.programari.models.Programari;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProgramariQuerryServiceImpl implements ProgramariQuerryService {


    private List<Programari> programariList;

    public ProgramariQuerryServiceImpl(){
        this.programariList=new ArrayList<>();
        load();

    }

    public void load(){
        Programari programare=new Programari(1,1,"17-07-2005");
        Programari programare2=new Programari(2,2,"12-09-2022");

        programariList.add(programare);
        programariList.add(programare2);
    }

    @Override
    public void afisareProramari() {
        for(Programari programari:programariList){
            System.out.println(programari.getIdProgramare());
        }


    }
}
