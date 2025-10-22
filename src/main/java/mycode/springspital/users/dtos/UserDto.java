package mycode.springspital.users.dtos;

import mycode.springspital.users.models.UserTypes;

public record UserDto(UserTypes userType, String username, String emailContact, String adresa) {

}
