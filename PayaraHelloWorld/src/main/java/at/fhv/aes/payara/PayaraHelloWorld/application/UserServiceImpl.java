package at.fhv.aes.payara.PayaraHelloWorld.application;

import at.fhv.aes.payara.PayaraHelloWorld.application.api.UserService;
import at.fhv.aes.payara.PayaraHelloWorld.domain.User;
import at.fhv.aes.payara.PayaraHelloWorld.domain.api.UserRepository;
import at.fhv.aes.payara.PayaraHelloWorld.infrastructure.UserRepositoryImpl;


import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {


    private UserRepository userRepository = UserRepositoryImpl.getInstance();


    public void saveToDatabase(User user){
        userRepository.add(user);
    }

    public Optional<User> findById(String userId){
        return userRepository.findById(userId);
    }

    public boolean isPresent(String userId){

        return userRepository.isPresent(userId);
    }


}
