package Service;
import DL.UserRepository;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public User getByToken(String token) {
        return userRepository.findOne(token);
    }

    @Transactional
    @Override
    public List<User> getAll() {
        Iterable<User> l= userRepository.findAll();
        List<User> ans= new ArrayList<>();
        for (User i : l){
            ans.add(i);

        }
        return ans;
    }
}
