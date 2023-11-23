package ZoomCar.Repos;

import ZoomCar.Models.User;

import java.util.HashMap;

public class UserRepository {
    public static HashMap<String, User> userRepository = new HashMap<>();

    public static User getUserByName(String name){
        return userRepository.get(name);
    }

    public static void addUser(String name, User user){
        userRepository.put(name, user);
    }
}
