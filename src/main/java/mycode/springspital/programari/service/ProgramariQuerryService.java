package mycode.springspital.programari.service;


import mycode.springspital.programari.models.Programari;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProgramariQuerryService {
    void afisareProramari();
    List<Programari> getAllByProgramariByPacientId(int id);
}
