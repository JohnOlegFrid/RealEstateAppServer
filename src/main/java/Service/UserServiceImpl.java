package Service;
import DL.UserRepository;
import domain.Apartment;
//import domain.Apartment;
import domain.Role;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

   
	@Autowired private UserRepository userRepository;
	@Autowired private ApartmentService apartmentService;

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
    
    @Override
    public void rank(String token, int rank) {
    	User user = getByToken(token);
    	user.setAvgRankRanker((double) rank);
    }

	@Override
	public void addApartmentToFavorite(String token, String address) {
		User user = getByToken(token);
		user.addApartmentToWishList(address);
	}

	@Override
	public List<Apartment> getUserWishList(String token) {
		List<Apartment> ans = new ArrayList<>();
		User user = getByToken(token);
		List<String> addresses = user.getWishList();
		for (String address : addresses) {
			ans.add(apartmentService.getByAddress(address));
		}
		return ans;
	}

	@Override
	@Transactional
	public User register(String token, String firstName, String lastName, String gender, String email, String image,
			Role root) {
		User user = new User(token, firstName, lastName, gender, email, image, Role.Root);
		return userRepository.save(user);
	}

	@Override
	public boolean isExist(String token) {
		return userRepository.exists(token);
		
	}
}
