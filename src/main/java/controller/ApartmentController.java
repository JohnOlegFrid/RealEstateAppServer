package controller;

import Service.ApartmentService;
import domain.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
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

    @RequestMapping("/addNew")
    public @ResponseBody Apartment addNew(@RequestHeader("price") Integer price,@RequestHeader("floor") Integer floor,@RequestHeader("elevator") Boolean elevator,@RequestHeader("constructionYear") Integer constructionYear,@RequestHeader("wareHouse") Boolean wareHouse,@RequestHeader("description") String description,@RequestHeader("size") Double size,@RequestHeader("averageRank") Double averageRank,@RequestHeader("address") String address,@RequestHeader("parking") Boolean parking,@RequestHeader("numToilet") Integer numToilet,@RequestHeader("numRooms") Integer numRooms,@RequestHeader("landLordID") String landLordID,@RequestHeader("image") String image){
        out.println("add new apartment with address: "+address);
        Apartment apt=new Apartment(price,floor,elevator,constructionYear,wareHouse,description,size,averageRank,address,parking,numToilet,numRooms,landLordID,image);
        return apartmentService.addNew(apt);
    }
}
