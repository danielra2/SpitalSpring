package mycode.springspital.pacienti.service;


import org.springframework.stereotype.Component;

@Component
public interface PacientCommandService {
    void adaugaPacient(String nume,int varsta);
}
