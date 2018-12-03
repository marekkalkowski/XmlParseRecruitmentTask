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
                .filter(p -> !p.equals(LocalDateTime.parse("0000-01-01T00:00:00.000")))
                .min(LocalDateTime::compareTo)
                .get();
        return date;
    }

    public long avarageScore(List<Post> posts) {
        double avgScore = posts.stream()
                .mapToInt(Post::getScore)
                .filter(i -> i != -2000)
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
                .filter(p -> !p.equals(LocalDateTime.parse("0000-01-01T00:00:00.000")))
                .max(LocalDateTime::compareTo)
                .get();
        return date;
    }

    public int largestNumberOfViews(List<Post> posts) {
        int largestNumberOfViews = posts.stream()
                .map(Post::getViewCount)
                .filter(i -> i != -2000)
                .max(Integer::compareTo)
                .get();
        return largestNumberOfViews;
    }

    public int maxScore(List<Post> posts) {
        int maxScore = posts.stream()
                .map(Post::getScore)
                .filter(i -> i != -2000)
                .max(Integer::compareTo)
                .get();
        return maxScore;
    }

    public int minScore(List<Post> posts) {
        int minScore = posts.stream()
                .map(Post::getScore)
                .filter(i -> i != -2000)
                .min(Integer::compareTo)
                .get();
        return minScore;
    }
}
