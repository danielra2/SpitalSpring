package mycode.springspital.spital.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Stomatologie extends Spital {
    private int nrCabinete;
    private boolean areRadiografie;

    public Stomatologie(String text){
        super(text);
        String[]prop=text.split(",");
        this.nrCabinete=Integer.parseInt(prop[4]);
        this.areRadiografie=Boolean.parseBoolean(prop[5]);
    }

}
