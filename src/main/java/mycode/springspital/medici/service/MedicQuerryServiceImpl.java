package mycode.springspital.medici.service;

import mycode.springspital.medici.models.Medici;
import mycode.springspital.medici.repository.MediciRepository;
import mycode.springspital.medici.repository.MediciRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MedicQuerryServiceImpl implements MedicQuerryService{

    private MediciRepository mediciRepository;

    public MedicQuerryServiceImpl(MediciRepository mediciRepository){
        this.mediciRepository=mediciRepository;
    }

    @Override
    public Medici getMedicByName(String name) {
        List<Medici> mediciList=mediciRepository.getAllMedici();
        for(int i=0;i<mediciList.size();i++){
            if(mediciList.get(i).getNume().equalsIgnoreCase(name)){
                return mediciList.get(i);
            }
        }
        return null;
    }
}
