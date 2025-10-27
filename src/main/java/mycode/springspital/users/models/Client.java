package mycode.springspital.users.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@SuperBuilder
@Data
@ToString(callSuper=true)
@Component
public class Client extends User {
    private String adresa;


    public Client(String text){
        super(text);
        String[]prop=text.split(",");
        this.adresa=prop[3];

    }
}