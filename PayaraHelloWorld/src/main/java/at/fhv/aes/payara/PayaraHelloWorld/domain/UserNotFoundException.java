package at.fhv.aes.payara.PayaraHelloWorld.domain;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
