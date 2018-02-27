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


@RestController
@RequestMapping("/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @RequestMapping("/getAll")
    public @ResponseBody List<Apartment> getAllApartments(){
        System.out.println("getAllApartments");
        return apartmentService.getAll();

    }

    @RequestMapping("/addNew")
    public @ResponseBody Apartment addNew(@RequestHeader("price") Integer price,@RequestHeader("floor") Integer floor,@RequestHeader("elevator") Boolean elevator,@RequestHeader("constructionYear") Integer constructionYear,@RequestHeader("wareHouse") Boolean wareHouse,@RequestHeader("description") String description,@RequestHeader("size") Double size,@RequestHeader("averageRank") Double averageRank,@RequestHeader("address") String address,@RequestHeader("parking") Boolean parking,@RequestHeader("numToilet") Integer numToilet,@RequestHeader("numRooms") Integer numRooms,@RequestHeader("landLordID") String landLordID,@RequestHeader("image") String image){
        System.out.println("add new apartment with address: "+address);
        Apartment apt=new Apartment(price,floor,elevator,constructionYear,wareHouse,description,size,averageRank,address,parking,numToilet,numRooms,landLordID,image);
        return apartmentService.addNew(apt);
    }


    @RequestMapping("/edit")
    public @ResponseBody Apartment edit(@RequestHeader("price") Integer price,@RequestHeader("floor") Integer floor,@RequestHeader("elevator") Boolean elevator,@RequestHeader("constructionYear") Integer constructionYear,@RequestHeader("wareHouse") Boolean wareHouse,@RequestHeader("description") String description,@RequestHeader("size") Double size,@RequestHeader("averageRank") Double averageRank,@RequestHeader("address") String address,@RequestHeader("parking") Boolean parking,@RequestHeader("numToilet") Integer numToilet,@RequestHeader("numRooms") Integer numRooms,@RequestHeader("landLordID") String landLordID,@RequestHeader("image") String image){
        System.out.println("edit apartment with address: "+address);
        Apartment apt=new Apartment(price,floor,elevator,constructionYear,wareHouse,description,size,averageRank,address,parking,numToilet,numRooms,landLordID,image);
        return apartmentService.edit(apt);
    }
}
