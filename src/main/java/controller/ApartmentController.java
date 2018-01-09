package controller;

import Service.ApartmentService;
import domain.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

@RestController
@RequestMapping("/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @RequestMapping("/getAll")
    public @ResponseBody List<Apartment> getAllApartment(){
        out.println("getAllApartment");
        return apartmentService.getAll();

    }
}
