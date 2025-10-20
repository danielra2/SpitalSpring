package mycode.springspital.users;


import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@ToString
public class Client extends User {
    private String isPremiumMember;
}
