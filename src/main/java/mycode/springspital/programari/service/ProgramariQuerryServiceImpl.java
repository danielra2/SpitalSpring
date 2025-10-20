package mycode.springspital.programari.service;

import mycode.springspital.programari.models.Programari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProgramariQuerryServiceImpl implements ProgramariQuerryService {

    private ProgramariCommandServiceImpl programariCommandService;

    @Autowired
    public ProgramariQuerryServiceImpl(ProgramariCommandServiceImpl programariCommandService) {
        this.programariCommandService=programariCommandService;
    }
    @Override
    public void afisareProramari() {
        List<Programari> programariList = programariCommandService.getProgramariList();
        for(Programari programari:programariList){
            System.out.println(programari);
        }
    }
}