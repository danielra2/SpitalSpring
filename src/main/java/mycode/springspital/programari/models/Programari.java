package mycode.springspital.programari.models;

import lombok.*;
import mycode.springspital.programari.repository.ProgramariRepository;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@ToString
public class Programari {
    private int idProgramare;
    private int idPacient;
    private String dataProgramare;

    public Programari(String text){
        String[]prop=text.split(",");
        this.idProgramare=Integer.parseInt(prop[0]);
        this.idPacient=Integer.parseInt(prop[1]);
        this.dataProgramare=prop[2];

    }

}
