package at.fhv.aes.payara.PayaraHelloWorld.application.api;

import at.fhv.aes.payara.PayaraHelloWorld.application.dto.CommentDTO;
import at.fhv.aes.payara.PayaraHelloWorld.domain.Comment;

import java.util.List;

public interface CommentService {
    public void saveToDatabase(Comment comment);
    public List<CommentDTO> getAllComments();
}
