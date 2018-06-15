package Service;
import DL.UserRepository;
import domain.Apartment;
import domain.ApartmentTransfor;
//import domain.Apartment;
import domain.Role;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public void rank(String token, double rank) {
    	User user = getByToken(token);
    	user.setAvgRankRanker((double) rank);
    	userRepository.save(user);
    }

	@Override
	public boolean addApartmentToFavorite(String token, String address) {
		User user = getByToken(token);
		boolean ans = user.addApartmentToWishList(address);
		userRepository.save(user);
		return ans;
	}

	@Override
	public List<ApartmentTransfor> getUserWishList(String token) {
		List<ApartmentTransfor> ans = new ArrayList<>();
		User user = getByToken(token);
		Set<String> addresses = user.getWishList();
		for (String address : addresses) {
			ans.add(new ApartmentTransfor(apartmentService.getByAddress(address)));
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
	public Boolean isExist(String token) {
		return userRepository.exists(token);
	}

	@Override
	public boolean blockUserChat(String myToken, String blokToken) {
		User user = userRepository.findOne(myToken);
		boolean ans = user.addUserChaTBlock(blokToken);
		userRepository.save(user);
		return ans;
	}

	@Override
	public boolean blockUserApartment(String myToken, String blokToken) {
		User user = userRepository.findOne(myToken);
		boolean ans = user.addUserApartmentBlock(blokToken);
		userRepository.save(user);
		return ans;
	}

	@Override
	public boolean isBlockForChat(String myToken, String blokToken) {
		User user = getByToken(myToken);
		return user.isBlockForChat(blokToken);
	}

	@Override
	public String getTokenByUserName(String name) {
		List<User> users = getAll();
		for (User user : users) {
			String userName = user.getFirstName() + " " + user.getLastName();
			if(userName.equals(name))
				return user.getToken();
		}
		return "";
	}

	@Override
	public Boolean deleteFromWishList(String token, String address) {
		User user = getByToken(token);
		boolean ans = user.deleteFromWishList(address);
		userRepository.save(user);
		return ans;
	}

	@Override
	public boolean deleteFromBlockChat(String myToken, String blokToken) {
		User user = getByToken(myToken);
		boolean ans = user.deleteFromBlockChat(blokToken);
		userRepository.save(user);
		return ans;
	}

	@Override
	public boolean deleteFromBlockApartment(String myToken, String blokToken) {
		User user = getByToken(myToken);
		boolean ans = user.deleteFromBlockApartment(blokToken);
		userRepository.save(user);
		return ans;
	}
}
