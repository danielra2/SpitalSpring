package mycode.springspital.spital.services;


import mycode.springspital.spital.exceptions.SpitalTypeNotExistException;
import mycode.springspital.spital.models.Spital;
import mycode.springspital.spital.models.SpitalType;

import java.util.List;

public interface SpitalQuerryService {

    void afisareSpitale();

    List<Spital> afisareSpitaleDupaTip(String tipString) throws SpitalTypeNotExistException;
}
