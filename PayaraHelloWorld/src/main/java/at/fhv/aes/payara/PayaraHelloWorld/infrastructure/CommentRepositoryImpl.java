package at.fhv.aes.payara.PayaraHelloWorld.infrastructure;

import at.fhv.aes.payara.PayaraHelloWorld.domain.Comment;
import at.fhv.aes.payara.PayaraHelloWorld.domain.api.CommentRepository;

import java.util.LinkedList;
import java.util.List;


public class CommentRepositoryImpl implements CommentRepository {
    private List<Comment> database = new LinkedList();

    public void add(Comment comment){
        database.add(comment);
    }

    public List<Comment> getAll(){
        return database;
    }

}
