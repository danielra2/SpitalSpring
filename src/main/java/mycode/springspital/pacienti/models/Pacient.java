package mycode.springspital.pacienti.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Builder
@AllArgsConstructor

@Data
public class Pacient {
    private String nume;
    private int varsta;
    private int id;

}
