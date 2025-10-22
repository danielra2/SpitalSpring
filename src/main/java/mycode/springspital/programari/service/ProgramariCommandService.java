package mycode.springspital.programari.service;


import org.springframework.stereotype.Component;

@Component
public interface ProgramariCommandService {
    void adaugaProgramare(int idPacient, String dataProgramare);
}
