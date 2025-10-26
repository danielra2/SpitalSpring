package mycode.springspital.medici.repository;

import mycode.springspital.medici.models.Medici;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Repository
public class MediciRepositoryImpl implements MediciRepository {

    private List<Medici>mediciList;

    public MediciRepositoryImpl(){
        this.mediciList=new ArrayList<>();
        load();
    }


    @Override
    public void load() {
        File file=new File("C:\\mycode\\spring\\SpringSpital\\src\\main\\java\\mycode\\springspital\\medici\\data\\medici.txt");
        try{
            Scanner scanner=new Scanner(file);
            while (scanner.hasNext()){
                String line=scanner.nextLine();
                Medici medici=new Medici(line);
                mediciList.add(medici);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Medici> getAllMedici() {
        return mediciList;
    }
}
