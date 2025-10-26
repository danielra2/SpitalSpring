package mycode.springspital.medici.models;

import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Data
public class Medici {
    private int id;
    private String nume;
    private String specializare;

    public Medici(String text){
        String[] prop = text.split(",");
        this.id = Integer.parseInt(prop[0]);
        this.nume = prop[1];
        this.specializare = prop[2];
    }
}