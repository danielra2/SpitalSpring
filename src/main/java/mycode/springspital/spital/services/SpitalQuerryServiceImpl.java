package mycode.springspital.spital.services;

import mycode.springspital.spital.exceptions.SpitalTypeNotExistException;
import mycode.springspital.spital.models.Pediatrie;
import mycode.springspital.spital.models.Spital;
import mycode.springspital.spital.models.SpitalType;
import mycode.springspital.spital.models.Stomatologie;
import mycode.springspital.spital.repository.SpitalRepository;
import mycode.springspital.spital.repository.SpitalRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class SpitalQuerryServiceImpl implements SpitalQuerryService{
    private SpitalRepository spitalRepository;


    public SpitalQuerryServiceImpl(SpitalRepository spitalRepository){
       this.spitalRepository=spitalRepository;

    }
    @Override
    public void afisareSpitale() {
        List<Spital>spitals=spitalRepository.getAllSpital();
        for(Spital spital:spitals){
            System.out.println(spital.getNume());
        }

    }

    @Override
    public List<Spital> afisareSpitaleDupaTip(String tipString) throws SpitalTypeNotExistException {
        SpitalType tip;
        try {
            tip = SpitalType.valueOf(tipString);
        } catch (IllegalArgumentException e) {
            throw new SpitalTypeNotExistException();
        }
        return spitalRepository.getAllSpital().stream()
                .filter(spital -> spital.getType() == tip)
                .collect(Collectors.toList());
    }
}
