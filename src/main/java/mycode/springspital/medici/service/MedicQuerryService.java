package mycode.springspital.medici.service;

import mycode.springspital.medici.models.Medici;

public interface MedicQuerryService {
    Medici getMedicByName(String name);
}
