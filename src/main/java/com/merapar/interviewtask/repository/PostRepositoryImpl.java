package com.merapar.interviewtask.repository;

import com.merapar.interviewtask.model.Post;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequestScope
public class PostRepositoryImpl implements PostRepository {

    private List<Post> postList = new ArrayList<>();

    public List<Post> getPostList() {
        return postList;
    }

    public void addPostToList(Post post) {
        this.postList.add(post);
    }
}
