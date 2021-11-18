package at.fhv.aes.payara.PayaraHelloWorld.domain;

public class Comment {
    private String message;
    private String author;
    private String email;

    public Comment(String message, String author, String email) {
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

    @Override
    public String toString() {
        return "Comment{" +
                "message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
