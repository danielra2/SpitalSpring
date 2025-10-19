package mycode.springspital.spital.models;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@ToString
public class Pediatrie extends Spital{
    private int varstaMaxima;

}
