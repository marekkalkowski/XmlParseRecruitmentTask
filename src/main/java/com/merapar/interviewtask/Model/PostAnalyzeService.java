package com.merapar.interviewtask.Model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostAnalyzeService {

    private List<Post> postList = new ArrayList<>();

    public  List<Post> getPostList() {
        return postList;
    }

    public  void addPostToList(Post post) {
        this.postList.add(post);
    }

    public LocalDateTime firstPostDate (){

        LocalDateTime date = getPostList().stream().map(post->post.getCreationDate()).min(LocalDateTime::compareTo).get();

        return date;
    }

    public long avarageScore () {
        double avgScore = getPostList().stream().mapToInt(Post::getId).average().getAsDouble();

        return Math.round(avgScore);
    }
}
