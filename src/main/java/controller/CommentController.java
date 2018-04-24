package controller;

import domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Service.CommentService;

import java.util.List;

@Controller
@RequestMapping(path = "/comment")
public class CommentController {
	
    @Autowired
    private CommentService commentService;

    @RequestMapping("/toAddress")
    public @ResponseBody
    Comment addNewCommenToAddress
    					(@RequestHeader("address") String address,
                         @RequestHeader("userID") String userID,
                         @RequestHeader("text") String text){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/comment/toAddress");
        System.out.println("address: " + address + "\nuserID: " + userID + "\ntext:" + text);
        return commentService.addNewComment(address, userID, text);
    }

    @RequestMapping("/toUser")
    public @ResponseBody
    Comment addNewCommentToUser
    					(@RequestHeader("userTo") String userToId,
                         @RequestHeader("userFrom") String userFromId,
                         @RequestHeader("text") String text){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/comment/toUser");
        System.out.println("userFrom: " + userFromId + "userTo: " + userToId + "\ntext:" + text);
        return commentService.addNewComment(userToId, userFromId, text);
    }
    
    @RequestMapping("/getAllComments")
    public @ResponseBody
    List<Comment> getAllbyAddress(@RequestHeader("commented") String commented){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/comment/getAllByAddress");
        System.out.println("address: " + commented);
        return commentService.getAllComments(commented);
    }
}

