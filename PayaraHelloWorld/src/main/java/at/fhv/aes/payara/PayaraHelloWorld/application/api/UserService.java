package at.fhv.aes.payara.PayaraHelloWorld.application.api;

import at.fhv.aes.payara.PayaraHelloWorld.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveToDatabase(User user);

    Optional<User> findById(String userId);

    boolean isPresent(String userId);

}
