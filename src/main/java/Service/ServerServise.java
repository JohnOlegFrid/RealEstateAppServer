//package hello.Service;
//
//import Exceptions.UserDoesntExistException;
//import domain.Apartment;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class ServerServise {
//
//
//    @RequestMapping("/register")
//    public void registerUser(@RequestHeader("token") String token, @RequestHeader("firstName") String firstName,
//                             @RequestHeader("lastName") String lastName,
//                             @RequestHeader("email") String email,
//                             @RequestHeader("gender") String gender,
//                             @RequestHeader("image") String image){
//         Manager.registerUser(token, firstName, lastName, email, gender, image);
//    }
//
//    @RequestMapping("/getAllApartments")
//    public Response<List<Apartment>> getAllApartment(@RequestHeader("token") String token) throws UserDoesntExistException {
//        System.out.println("getAllApartment");
//        try{ return new Response<>(Manager.getAllApartment(token), "");}
//        catch (UserDoesntExistException e){return new Response<>(null, "user doesnt exists");}
//    }
//
//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        System.out.println("greeting");
//        return new Greeting(1, "bla");
//    }
//
//
//}
