package mycode.springspital.pacienti.models;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Data
public class Pacient {
    private int id;
    private String nume;
    private int varsta;


    public Pacient(String text){
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[0]);
        this.nume=prop[1];
        this.varsta=Integer.parseInt(prop[2]);

    }

}
