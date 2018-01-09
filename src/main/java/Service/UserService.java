package Service;

import domain.User;

public interface UserService {

    public User register (User u);
    public User getUserByID(String ID);

}
