package me.devjian.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();

    private static int USER_COUNT = 0;

    static {
        userList.add(new User(++USER_COUNT, "Adam", LocalDate.now()));
        userList.add(new User(++USER_COUNT, "Eve", LocalDate.now()));
    }

    public List<User> findAll() {
        return userList;
    }

    public User findById(int id) {
        return userList.stream()
                .filter((user) -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User addUser(User newUser) {
        newUser.setId(++USER_COUNT);
        userList.add(newUser);
        return newUser;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> id == user.getId();
        userList.removeIf(predicate);
    }
}
