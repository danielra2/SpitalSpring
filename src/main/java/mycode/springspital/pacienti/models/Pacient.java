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
    private String nume;
    private int varsta;
    private int id;

}
