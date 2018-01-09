package controller;

//import DL.UserRepository;
//import DL.User_DL;
import Service.UserService;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
        User u = new User(token, firstName, lastName, email, gender, 0.0, 0.0, image);
        return userService.register(u);
    }

}
