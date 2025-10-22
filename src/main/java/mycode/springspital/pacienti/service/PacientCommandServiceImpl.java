package mycode.springspital.pacienti.service;


import mycode.springspital.pacienti.models.Pacient;
import mycode.springspital.pacienti.repository.PacientiRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacientCommandServiceImpl implements PacientCommandService {
    private PacientiRepository pacientiRepository;

    public PacientCommandServiceImpl(PacientiRepository pacientiRepository){
        this.pacientiRepository=pacientiRepository;
    }


    @Override
    public void adaugaPacient(String nume, int varsta) {
        Pacient pacient=Pacient.builder().nume(nume).varsta(varsta).build();
        pacientiRepository.save(pacient);

    }

}
