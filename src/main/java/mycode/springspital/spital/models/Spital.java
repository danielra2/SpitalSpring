package mycode.springspital.spital.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@ToString
public abstract class Spital {
    private String nume;
    private int anFondare;
    private SpitalType type;


    public Spital(String text){
        String[]prop=text.split(",");
        this.nume=prop[1];
        this.anFondare=Integer.parseInt(prop[2]);
        this.type=SpitalType.valueOf(prop[3].toUpperCase());

    }

    public static Spital FabricaSpital(SpitalType tip,String text){
        switch (tip){
            case STOMATOLOGIE -> {
                return new Stomatologie(text);
            }
            case PEDIATRIE -> {
                return new Pediatrie(text);
            }
        }
        return null;
    }

}
