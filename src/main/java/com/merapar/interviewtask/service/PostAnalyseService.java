package com.merapar.interviewtask.service;

import com.merapar.interviewtask.model.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PostAnalyseService {


    public LocalDateTime firstPostDate(List<Post> posts) {

        LocalDateTime date = posts.stream()
                .map(post -> post.getCreationDate())
                .filter(p->!p.equals(LocalDateTime.parse("0000-01-01T00:00:00.000")))
                .min(LocalDateTime::compareTo)
                .get();
        return date;
    }

    public long avarageScore(List<Post> posts) {
        double avgScore = posts.stream()
                .mapToInt(Post::getScore)
                .filter(i->i != -2000)
                .average()
                .getAsDouble();
        return Math.round(avgScore);
    }

    public long postsNumber(List<Post> posts) {

        long postsNumber = posts.stream()
                .count();
        return postsNumber;
    }

    public long acceptedPostsNumber(List<Post> posts) {

        long acceptedPostsNumber = posts.stream()
                .filter(p -> !p.getAcceptedAnswerId().equalsIgnoreCase("brak"))
                .count();
        return acceptedPostsNumber;
    }

    public LocalDateTime lastActivityDate(List<Post> posts) {
        LocalDateTime date = posts.stream()
                .map(post -> post.getLastActivityDate())
                .filter(p->!p.equals(LocalDateTime.parse("0000-01-01T00:00:00.000")))
                .max(LocalDateTime::compareTo)
                .get();
        return date;
    }
}
