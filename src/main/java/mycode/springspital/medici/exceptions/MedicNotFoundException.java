package mycode.springspital.medici.exceptions;

import mycode.springspital.constants.MedicConstants;

public class MedicNotFoundException extends RuntimeException {
  public MedicNotFoundException() {
    super(MedicConstants.MEDIC_NOT_FOUND);
  }
  }
