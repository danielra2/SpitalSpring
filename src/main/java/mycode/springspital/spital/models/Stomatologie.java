package mycode.springspital.spital.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Stomatologie extends Spital {
    private int nrCabinete;
    private boolean areRadiografie;

}
