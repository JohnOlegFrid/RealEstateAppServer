package controller;

import java.sql.Timestamp;
import Service.CommentService;
import Service.UserService;
import domain.Comment;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping("/addNew")
    public @ResponseBody
    Comment addNew(@RequestHeader("address") String address,
                         @RequestHeader("userID") String userID,
                         @RequestHeader("text") String text){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/comment/addNew");
        System.out.println("address: " + address + "\nuserID: " + userID + "\ntext:" + text);
        User user=userService.getByToken(userID);
        String userPictureUrl=user.getImage();
        String userName=user.getFirstName()+user.getLastName();
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        Comment comment = new Comment(address, userID, text, timeStamp,userPictureUrl,userName);
        return commentService.addNew(comment);
    }


    @RequestMapping("/getAllByAddress")
    public @ResponseBody
    List<Comment> getAllbyAddress(@RequestHeader("address") String address){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/comment/getAllByAddress");
        System.out.println("address: " + address);
        return commentService.getAllByAddress(address);
    }
}

