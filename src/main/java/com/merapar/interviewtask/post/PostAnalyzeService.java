package com.merapar.interviewtask.post;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostAnalyzeService {

    private List<Post> postList = new ArrayList<>();

    public List<Post> getPostList() {
        return postList;
    }

    public void addPostToList(Post post) {
        this.postList.add(post);
    }

    public LocalDateTime firstPostDate(List<Post> posts) {

        LocalDateTime date = posts.stream().map(post -> post.getCreationDate()).min(LocalDateTime::compareTo).get();

        return date;
    }

    public long avarageScore(List<Post> posts) {
        double avgScore = posts.stream().mapToInt(Post::getScore).average().getAsDouble();

        return Math.round(avgScore);
    }
}
