package mycode.springspital.users.exceptions;

import mycode.springspital.constants.UserConstants;

public class UserDoesnotExistException extends RuntimeException {
  public UserDoesnotExistException()
  {
    super(UserConstants.USER_DOESNT_EXIST);
  }
}
