package Service;

import domain.User;

import java.util.List;

public interface UserService {

    User register (User u);
    User getByToken(String token);
    List<User> getAll();
}
