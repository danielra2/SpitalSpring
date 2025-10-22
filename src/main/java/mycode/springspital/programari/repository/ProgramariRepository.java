package mycode.springspital.programari.repository;

import mycode.springspital.programari.models.Programari;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProgramariRepository {
    void load();
    List<Programari> getAllProgramari();

    Programari save(Programari programare);
}
