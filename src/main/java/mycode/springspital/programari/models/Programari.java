package mycode.springspital.programari.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Programari {
    private int idProgramare;
    private int idPacient;
    private String dataProgramare;

}
