package controller;

import Exceptions.NotAuthorizedUser;
import Service.ApartmentService;
import domain.ApartmentTransfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import Service.UserService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;


@Controller
public class WebController {
    Password mainPassword;

    @Autowired
    private UserService userService;

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/")
    public String getStartPage(Model model) {
        model.addAttribute("Password",new Password());
        return "askPassword";
    }

    @PostMapping("/checkPassword")
    public String webLoginPost(@ModelAttribute Password Password) {
        System.out.println(">>>>>>>>>>>> "+Password.getPassword());
        if (Password.getPassword().equals("123456")){
            mainPassword=new Password(Password.getPassword());
            //redirectAttributes.addFlashAttribute("Password", Password);
            return "redirect:/addApartmentWeb";
        }

        return "redirect:/";
    }

    @GetMapping("/addApartmentWeb")
    public String apartmentForm(Model model) {
        model.addAttribute("apartment", new ApartmentTransfor());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>send addApartmentWeb html");

        model.addAttribute("Password",mainPassword);
        return "addApartmentWeb";
    }

    @PostMapping("/addApartmentWeb")
    public String apartmentSubmit(@ModelAttribute ApartmentTransfor apartment)throws NotAuthorizedUser, IOException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>apartmentPost "+ apartment.getAddress()+" "+apartment.getDescription());
        apartment.setLandLordID("10214871526956185");
        System.out.println (apartmentService.addNewWithUserPermissions(apartment));
        return "result";
    }

}
class Password{
    public String password="";
    public Password(){

    }

    public Password(String pass){
        password=pass;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
