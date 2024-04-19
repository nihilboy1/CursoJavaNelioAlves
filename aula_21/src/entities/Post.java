package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post{
    private static final DateTimeFormatter CUSTOMFORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm:ss");
    String title;
    String content;
    Integer likes;
    List<Comment> comments = new ArrayList<>();
    private LocalDateTime date;

    public Post(LocalDateTime date, String title, String content, Integer likes){
        this.date = date;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    @Override
    public String toString(){
        StringBuilder comments = new StringBuilder();
        for(Comment comment : this.comments){
            comments.append(comment.getText()).append("\n");
        }
        return this.title + "\n" + this.likes + " Likes - " + this.date.format(CUSTOMFORMAT) + "\n" + this.content + "\n" + "Comments: \n" + comments;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void removeComment(Comment comment){
        this.comments.remove(comment);
    }
}
