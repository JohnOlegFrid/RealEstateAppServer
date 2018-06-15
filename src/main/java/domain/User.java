package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Id;

import org.hibernate.jpa.criteria.expression.function.AggregationFunction.AVG;
import org.yaml.snakeyaml.tokens.BlockEndToken;

@javax.persistence.Entity
public class User {

    @Id
    private String token;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private Double averageRank;
    private Integer numOfRankers;
    private String image;
    private Role role;
    @ElementCollection private Set<String> wishList;
    @ElementCollection private Set<String> blockChat;
    @ElementCollection private Set<String> blockApartment;
    

    public User(){}

    public User(String token, String firstName, String lastName, String gender, String email, String image,Role role) {
        this.setImage(image);
        this.setToken(token);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setEmail(email);
        averageRank = 0.0;
        numOfRankers = 0;
        wishList = new HashSet();
        this.role = role;
        blockChat = new HashSet();
        blockApartment = new HashSet();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Double getAvgRankRanker() {
        return averageRank;
    }

    public void setAvgRankRanker(double rank) {
    	numOfRankers++;
    	averageRank = ((numOfRankers - 1) * averageRank + rank) / numOfRankers;    
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public boolean addApartmentToWishList(String address) {
    	return wishList.add(address);
    }

	public Set<String> getWishList() {
		return wishList;
	}
	
	public boolean addUserChaTBlock(String token) {
    	return blockChat.add(token);
    }

	public Set<String> getBlockChat() {
		return blockChat;
	}
	
	public boolean addUserApartmentBlock(String token) {
    	return blockApartment.add(token);
    }

	public Set<String> getBlockApartment() {
		return blockApartment;
	}
	
	public Role getRole() {
		return role;
	}

	public boolean isRoot() {
		return role == Role.Root;
	}

	public boolean isBlockForChat(String blokToken) {
		return blockChat.contains(blokToken);
	}

	public boolean deleteFromWishList(String address) {
		return wishList.remove(address);
	}

	public boolean deleteFromBlockChat(String blokToken) {
		return blockChat.remove(blokToken);
	}

	public boolean deleteFromBlockApartment(String blokToken) {
		return blockApartment.remove(blokToken);
	}
	
	
}

