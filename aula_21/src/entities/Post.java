package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post{

    private LocalDateTime date;
    String title;
    String content;
    Integer likes;
    List<Comment> comment = new ArrayList<>();
}
