package mycode.springspital.programari.exceptions;

public class MedicIdDoesntExist extends RuntimeException {
  public MedicIdDoesntExist(String message) {
    super(message);
  }
}
