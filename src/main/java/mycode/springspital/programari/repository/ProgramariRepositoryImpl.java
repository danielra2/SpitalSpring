package mycode.springspital.programari.repository;

import mycode.springspital.programari.models.Programari;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Repository
public class ProgramariRepositoryImpl implements ProgramariRepository{

    private List<Programari>programariList;

    public ProgramariRepositoryImpl(){
        this.programariList=new ArrayList<>();
        load();
    }

    @Override
    public void load() {
        File file=new File("C:\\mycode\\spring\\SpringSpital\\src\\main\\java\\mycode\\springspital\\programari\\data\\programari.txt");
        try{
            Scanner scanner=new Scanner(file);
            while(scanner.hasNext()){
                String line=scanner.nextLine();
                Programari programare=new Programari(line);
                this.programariList.add(programare);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Programari> getAllProgramari() {
        return programariList;
    }
    private int getMaxId() {
        if (programariList.isEmpty()) {
            return 0;
        }

        return programariList.stream()
                .mapToInt(Programari::getIdProgramare)
                .max()
                .orElse(0);
    }

@Override
public Programari save(Programari programare) {
        int nextId = getMaxId() + 1;
        programare.setIdProgramare(nextId);
        this.programariList.add(programare);
        return programare;
    }
}
