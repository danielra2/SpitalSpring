package mycode.springspital.spital.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Spital {
    private String nume;
    private int anFondare;
    protected SpitalType spitalType;

}
