package Service;


import DL.CommentRepository;
import domain.Comment;
import domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

	private int counterId = 0;
	
	@Autowired
    private UserService userService;
	
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments(String commented) {
    	List<Comment> l= commentRepository.findByCommented(commented);
        return l;
    }

	@Override
	public Comment addNewComment(String to, String from, String text) {
		User user=userService.getByToken(from);
        String userPictureUrl=user.getImage();
        String userName=user.getFirstName() + " " + user.getLastName();
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        Comment comment = new Comment(counterId++,to, from, text, timeStamp,userPictureUrl,userName);
        return commentRepository.save(comment);
	} 
}
