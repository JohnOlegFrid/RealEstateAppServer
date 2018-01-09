package Service;
import DL.UserRepository;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public User register(User u){
        return userRepository.save(u);

    }

    @Transactional
    @Override
    public User getUserByID(String ID) {
        return null;
    }
}
