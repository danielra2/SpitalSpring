package mycode.springspital.users;


import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@ToString
public class Admin extends User {
    private String lastLogin;
}
