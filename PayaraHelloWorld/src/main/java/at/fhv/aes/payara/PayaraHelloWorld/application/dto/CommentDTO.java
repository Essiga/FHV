package at.fhv.aes.payara.PayaraHelloWorld.application.dto;

public class CommentDTO {

    private String message;
    private String author;
    private String email;

    public CommentDTO(String message, String author, String email) {
        this.message = message;
        this.author = author;
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }

    public String getEmail() {
        return email;
    }
}
