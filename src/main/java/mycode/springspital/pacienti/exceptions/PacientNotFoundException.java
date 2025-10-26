package mycode.springspital.pacienti.exceptions;

import mycode.springspital.constants.PacientConstants;

public class PacientNotFoundException extends RuntimeException {
  public PacientNotFoundException() {
    super(PacientConstants.PACIENT_NOT_FOUND);
  }
}
