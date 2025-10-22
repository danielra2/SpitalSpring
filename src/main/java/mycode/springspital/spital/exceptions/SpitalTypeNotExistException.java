package mycode.springspital.spital.exceptions;

import mycode.springspital.constants.SpitalConstants;

public class SpitalTypeNotExistException extends RuntimeException {
    public SpitalTypeNotExistException(){
        super(SpitalConstants.SPITAL_TYPE_DOESNOT_EXIST);
    }
}
