package chiarafais.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("non c'è un evento con: " + id + " <-- questo id");
    }
}
