package Service;

import domain.User;

import java.util.List;

import domain.Apartment;
import domain.ApartmentTransfor;
//import domain.Apartment;
import domain.Role;

public interface UserService {

    User getByToken(String token);
    List<User> getAll();
	void rank(String token, double rank);
	void addApartmentToFavorite(String token, String address);
	List<ApartmentTransfor> getUserWishList(String token);
	User register(String token, String firstName, String lastName, String gender, String email, String image,
			Role root);
	Boolean isExist(String token);
}
