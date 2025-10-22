package mycode.springspital.users.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor

@SuperBuilder
@Data
@ToString(callSuper=true)
public class Admin extends User {
    private String emailContact;

    public Admin(String text){
        super(text);
        String[]prop=text.split(",");
        this.emailContact=prop[3];
    }
}