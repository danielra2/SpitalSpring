package mycode.springspital.pacienti.repository;

import mycode.springspital.pacienti.models.Pacient;
import mycode.springspital.users.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PacientiRepository {
     void load();
     List<Pacient> getAllPacient();
    Pacient save(Pacient pacient);

}
