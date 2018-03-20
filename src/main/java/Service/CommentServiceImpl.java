package Service;


import DL.CommentRepository;
import domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllByAddress(String address) {
        Iterable<Comment> l= commentRepository.findAll();
        List<Comment> ans= new ArrayList<>();
        for (Comment i : l) {
            ans.add(i);
        }
        return ans;
    }

    @Override
    public Comment addNew(Comment comment){return commentRepository.save(comment);}
}
