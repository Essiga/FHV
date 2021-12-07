package at.fhv.aes.payara.PayaraHelloWorld.infrastructure;

import at.fhv.aes.payara.PayaraHelloWorld.domain.User;
import at.fhv.aes.payara.PayaraHelloWorld.domain.api.UserRepository;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class UserRepositoryImpl implements UserRepository {
    private static UserRepository instance;

    public static UserRepositoryImpl getInstance(){
        if(null == UserRepositoryImpl.instance){
            new UserRepositoryImpl();
        }
        return (UserRepositoryImpl) UserRepositoryImpl.instance;
    }

    private UserRepositoryImpl(){

        UserRepositoryImpl.instance = this;
        userDatabase.add(new User("test", "test", "user", "pass"));
    }

    private List<User> userDatabase = new LinkedList();


    public void add(User user){
        userDatabase.add(user);
    }

    public Optional<User> findById(String userId){
         Optional<User> userOpt = Optional.ofNullable(userDatabase.stream().filter(u -> u.getUserID().equals(userId)).collect(Collectors.toList()).get(0));
         return userOpt;
    }

    public boolean isPresent(String userId){

        for (User user : userDatabase) {
            if(user.getUserID().equals(userId)){
                return true;
            }
        }
        return false;

       // return !userDatabase.stream().filter(u -> u.getUserID().equals(userId)).collect(Collectors.toList()).isEmpty();
    }
}
