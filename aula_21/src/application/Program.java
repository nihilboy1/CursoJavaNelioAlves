package application;

import entities.Comment;
import entities.Post;

import java.time.LocalDateTime;

public class Program{
    public static void main(String[] args){

        Post post1 = new Post(LocalDateTime.parse("2022-07-20T22:30:26"), "Travelling to New Zeland", "i'm going to visit this wonderfull country", 12);
        post1.addComment(new Comment("Have a nice trip"));
        post1.addComment(new Comment("Wow! That is awesome!"));

        Post post2 = new Post(LocalDateTime.parse("2022-07-20T22:30:26"), "good night, guys!", "see you tomorrow...", 5);
        post2.addComment(new Comment("good night!"));
        post2.addComment(new Comment("may the force be with you!"));

        System.out.println(post1);
        System.out.println("\n");
        System.out.println(post2);
    }
}