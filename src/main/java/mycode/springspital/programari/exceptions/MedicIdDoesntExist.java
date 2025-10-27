package mycode.springspital.programari.exceptions;

import mycode.springspital.constants.MedicConstants;

public class MedicIdDoesntExist extends RuntimeException {
    public MedicIdDoesntExist() {
        super(MedicConstants.MEDIC_ID_NOT_FOUND);
    }
}
