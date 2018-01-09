package Service;

import domain.User;

public interface UserService {

    User register (User u);
    User getByToken(String token);

}
