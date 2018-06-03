package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Service.ApartmentService;
import Service.UserService;
import domain.Comment;

@Controller
@RequestMapping(path = "/rank")
public class RankController {
	
	 @Autowired
	 UserService userService;
	 @Autowired
	 ApartmentService apartmentService;
	 
	 @ResponseBody
	@RequestMapping("/address")
	public void rankAddress(@RequestHeader("address") String address,
                         @RequestHeader("rank") double rank){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/rank/address");
        System.out.println("address: " + address + "\ntext:" + rank);
        apartmentService.rank(address, rank);
    }

	 @ResponseBody
	@RequestMapping("/user")
    public void rankUser(@RequestHeader("userId") String userId,
                         @RequestHeader("rank") double rank){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/rank/user");
        System.out.println("userId: " + userId + "\ntext:" + rank);
        userService.rank(userId, rank);
    }
	
}
