package controller;

//import domain.Apartment;
import domain.Role;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public void addApartmentToFavorite(@RequestHeader ("token") String token,
    		@RequestHeader ("address") String address){
    	userService.addApartmentToFavorite(token, address);

    }
    @ResponseBody
    @RequestMapping("/isExist")
    public Boolean isExist(@RequestHeader ("token") String token){
    	return userService.isExist(token);
}

//    @RequestMapping("/wishList")
//    public @ResponseBody List<Apartment> getUserWishList(@RequestHeader ("token") String token) {
//    	return userService.getUserWishList(token);
//    }

}





//@RequestMapping("/forTest")
//public @ResponseBody String forTest(){
//  //System.out.println("get by token : "+token);
//  return "s";
//}
