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
public class Spital {
    private String nume;
    private int anFondare;
    protected SpitalType spitalType;

}
