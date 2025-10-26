package mycode.springspital.medici.repository;

import mycode.springspital.medici.models.Medici;

import java.util.List;

public interface MediciRepository {
    void load();
    List<Medici> getAllMedici();

}
