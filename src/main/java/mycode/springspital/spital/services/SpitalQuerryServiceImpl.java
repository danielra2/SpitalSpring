package mycode.springspital.spital.services;

import mycode.springspital.spital.models.Pediatrie;
import mycode.springspital.spital.models.Spital;
import mycode.springspital.spital.models.SpitalType;
import mycode.springspital.spital.models.Stomatologie;

import java.util.ArrayList;
import java.util.List;

public class SpitalQuerryServiceImpl implements SpitalQuerryService{
    private List<Spital> spitalList;

    public SpitalQuerryServiceImpl(){
        this.spitalList=new ArrayList<>();
    }
    public void load(){
        Pediatrie pediatrie= Pediatrie.builder().nume("Regina maria").anFondare(2001).spitalType(SpitalType.PEDIATRIE).varstaMaxima(11).build();
        Pediatrie pediatrie1=Pediatrie.builder().nume("Spital de copii").anFondare(2022).spitalType(SpitalType.PEDIATRIE).varstaMaxima(18).build();
        Stomatologie stomatologie=Stomatologie.builder().nume("Spital de dinti").anFondare(2010).spitalType(SpitalType.STOMATOLOGIE).nrCabinete(11).areRadiografie(true).build();

        spitalList.add(pediatrie);
        spitalList.add(pediatrie1);
        spitalList.add(stomatologie);
    }


    @Override
    public void afisareSpitale() {
        for(Spital spital:spitalList){
            System.out.println(spital.getNume());
        }

    }
}
