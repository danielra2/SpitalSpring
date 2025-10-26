package mycode.springspital.pacienti.service;


import mycode.springspital.pacienti.models.Pacient;
import org.springframework.stereotype.Component;

public interface PacientQuerryService {
    void afisarePacienti();
    Pacient getPacientById(int id);
    Pacient getPacientByNume(String nume);

}
