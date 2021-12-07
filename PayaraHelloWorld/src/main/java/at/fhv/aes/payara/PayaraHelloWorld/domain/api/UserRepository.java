package at.fhv.aes.payara.PayaraHelloWorld.domain.api;

import at.fhv.aes.payara.PayaraHelloWorld.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void add(User user);
    Optional<User> findById(String userId);
    boolean isPresent(String userId);
}
