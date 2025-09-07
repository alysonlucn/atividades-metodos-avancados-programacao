package repository;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();
    private int seq = 1;

    public User add(String name, String type) {
        User u = new User(seq++, name, type);
        users.add(u);
        return u;
    }

    public List<User> getAll() {
        return users;
    }

    public User findById(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}