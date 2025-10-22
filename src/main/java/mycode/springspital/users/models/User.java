package mycode.springspital.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@ToString
public abstract class User {
    private int id;
    private String username;

    public User(String text){
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[1]);
        this.username=prop[2];
    }
    public static User fabricaUser(UserTypes tip, String text){
  switch (tip){
    case CLIENT -> {
        return new Client(text);
    }
    case ADMIN -> {
        return new Admin(text);
    }

}
return null;

    }

}