package Service;

import domain.Comment;
import java.util.List;

public interface CommentService {

	List<Comment> getAllComments(String commented);
	Comment addNewComment(String to, String from, String text);
}
