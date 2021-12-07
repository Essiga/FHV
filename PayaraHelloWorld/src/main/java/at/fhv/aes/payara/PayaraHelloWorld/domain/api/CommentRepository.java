package at.fhv.aes.payara.PayaraHelloWorld.domain.api;

import at.fhv.aes.payara.PayaraHelloWorld.domain.Comment;

import java.util.List;

public interface CommentRepository {

    void add(Comment comment);
    List<Comment> getAll();
}