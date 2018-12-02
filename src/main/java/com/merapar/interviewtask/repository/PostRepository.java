package com.merapar.interviewtask.repository;

import com.merapar.interviewtask.model.Post;

import java.util.ArrayList;
import java.util.List;

public interface PostRepository {

    List<Post> postList = new ArrayList<>();

    List<Post> getPostList();

    void addPostToList(Post post);
}
