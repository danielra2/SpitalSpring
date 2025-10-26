package mycode.springspital.pacienti.repository;

import mycode.springspital.pacienti.models.Pacient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class PacientiRepositoryImpl implements PacientiRepository {

    private List<Pacient>pacientList;

    public PacientiRepositoryImpl(){
        this.pacientList=new ArrayList<>();
        load();
    }
    private int getMaxId() {
        if (pacientList.isEmpty()) {
            return 0;
        }

        return pacientList.stream()
                .mapToInt(Pacient::getId)
                .max()
                .orElse(0);
    }

    @Override
    public void load() {
        File file = new File("C:\\mycode\\spring\\SpringSpital\\src\\main\\java\\mycode\\springspital\\pacienti\\data\\pacienti.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Pacient pacient = new Pacient(line);
                pacientList.add(pacient);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pacient> getAllPacient() {
        return pacientList;
    }

    @Override
    public Pacient save(Pacient pacient) {
        int nextId = getMaxId() + 1;
        pacient.setId(nextId);
        this.pacientList.add(pacient);
        return pacient;
    }


}
