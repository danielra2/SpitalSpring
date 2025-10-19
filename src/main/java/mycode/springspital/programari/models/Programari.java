package mycode.springspital.programari.models;

import lombok.*;
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

}
