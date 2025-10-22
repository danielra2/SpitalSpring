package mycode.springspital.users.exceptions;

import mycode.springspital.constants.UserConstants;

public class UserNameAlreadyExistsException extends RuntimeException {
    public UserNameAlreadyExistsException() {
        super(UserConstants.USER_NAME_ALREADY_EXISTS);
    }
}
