package DL;

import domain.Comment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository  extends CrudRepository<Comment, Integer> {
	List<Comment> findByCommented(String commented);
}
