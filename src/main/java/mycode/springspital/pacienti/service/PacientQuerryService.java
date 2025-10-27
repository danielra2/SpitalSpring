package mycode.springspital.pacienti.service;


import mycode.springspital.pacienti.models.Pacient;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PacientQuerryService {
    void afisarePacienti();
    Pacient getPacientById(int id);
    Pacient getPacientByNume(String nume);
    List<Pacient>getPacientiByPacientiIdList(int medicId);



}
