package at.fhv.aes.payara.PayaraHelloWorld.application;

import at.fhv.aes.payara.PayaraHelloWorld.application.api.CommentService;
import at.fhv.aes.payara.PayaraHelloWorld.application.dto.CommentDTO;
import at.fhv.aes.payara.PayaraHelloWorld.domain.Comment;
import at.fhv.aes.payara.PayaraHelloWorld.domain.api.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void saveToDatabase(Comment comment){
        commentRepository.add(comment);
    }

    public List<CommentDTO> getAllComments(){
        List<Comment> allComments = commentRepository.getAll();
        return allComments
                .stream()
                .map(comments ->
                        new CommentDTO(
                                comments.getMessage(),
                                comments.getAuthor(),
                                comments.getEmail()))
                .collect(Collectors.toList());
    }
}
