package mycode.springspital.spital.repository;

import mycode.springspital.spital.models.Spital;
import mycode.springspital.spital.models.SpitalType;
import mycode.springspital.users.models.User;
import mycode.springspital.users.models.UserTypes;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Repository
public class SpitalRepositoryImpl implements SpitalRepository{
    private List<Spital>spitalList;

    public SpitalRepositoryImpl(){
        this.spitalList=new ArrayList<>();
        load();

    }

    @Override
    public void load() {
        File file=new File("C:\\mycode\\spring\\SpringSpital\\src\\main\\java\\mycode\\springspital\\spital\\data\\spital.txt");
        try{
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[]parti=line.split(",");
                SpitalType tip= SpitalType.valueOf(parti[0]);
                Spital spital= Spital.FabricaSpital(tip,line);
                if(spital!=null){
                    this.spitalList.add(spital);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Spital> getAllSpital() {
        return spitalList;
    }

}
