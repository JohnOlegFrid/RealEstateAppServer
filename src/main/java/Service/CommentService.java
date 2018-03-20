package Service;

import domain.Comment;
import java.util.List;

public interface CommentService {

    List<Comment> getAllByAddress(String address);
    Comment addNew(Comment comment);
}
