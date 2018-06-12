package controller;

import domain.ApartmentTransfor;
//import domain.Apartment;
import domain.Role;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Service.UserService;

import java.util.List;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public @ResponseBody User registerUser(@RequestHeader("token") String token,
                        @RequestHeader("firstName") String firstName,
                        @RequestHeader("lastName") String lastName,
                        @RequestHeader("email") String email,
                        @RequestHeader("gender") String gender,
                        @RequestHeader("image") String image) {
        System .out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System .out.println("token: "+token+"\nfirstName: "+firstName+"\nlastName:"+lastName);
        return userService.register(token, firstName, lastName, gender, email, image, Role.Root);
    }

    @RequestMapping("/getByToken")
    public @ResponseBody User findByToken(@RequestHeader ("token") String token){
        System.out.println("get by token : "+token);
        return userService.getByToken(token);
    }

    @RequestMapping("/getAll")
    public @ResponseBody List<User> getAllApartments(){
        System.out.println("getAllUsers");
        return userService.getAll();

    }

    @RequestMapping("/addApartmentToFavorite")
    public @ResponseBody boolean addApartmentToFavorite(@RequestHeader ("token") String token,
    		@RequestHeader ("address") String address){
    	return userService.addApartmentToFavorite(token, address);

    }
    
    @ResponseBody
    @RequestMapping("/isExist")
    public boolean isExist(@RequestHeader ("token") String token){
    	return userService.isExist(token);
}

    @RequestMapping("/wishList")
    public @ResponseBody List<ApartmentTransfor> getUserWishList(@RequestHeader ("token") String token) {
    	return userService.getUserWishList(token);
    }
    
    @RequestMapping("/blockChatUser")
    public @ResponseBody boolean addToBlockChat(@RequestHeader ("myToken") String myToken,
    											@RequestHeader ("blockToken") String blokToken) {
    	return userService.blockUserChat(myToken,blokToken);
    }
    @RequestMapping("/blockApartmentUser")
    public @ResponseBody boolean addToBlockApartment(@RequestHeader ("myToken") String myToken,
    											@RequestHeader ("blockToken") String blokToken) {
    	return userService.blockUserApartment(myToken,blokToken);
    }
    @RequestMapping("/isBlockForChat")
    public @ResponseBody boolean isBlockForChat(@RequestHeader ("myToken") String myToken,
    											@RequestHeader ("blockToken") String blokToken) {
    	return userService.isBlockForChat(myToken,blokToken);
    }
    
    @RequestMapping("/getTokenByUserName")
    public @ResponseBody String getTokenByUserName(@RequestHeader ("userName") String name) {
    	return userService.getTokenByUserName(name);
    }

}
