package com.merapar.interviewtask.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PostDetailsInstanceGenerator {

    @Autowired
    private PostsDetails postsDetails;

    @Autowired
    private PostAnalyseService postAnalyseService;

    public PostsDetails generatePostDetailsInstance() {
        List<Post> posts = postAnalyseService.getPostList();

        postsDetails = new PostsDetails();
        postsDetails.setFirstPost(postAnalyseService.firstPostDate(posts));
        postsDetails.setAvgScore(postAnalyseService.avarageScore(posts));
        postsDetails.setTotalPosts(postAnalyseService.postsNumber(posts));
        postsDetails.setTotalAcceptedPosts(postAnalyseService.acceptedPostsNumber(posts));
        postsDetails.setLastPost(postAnalyseService.lastActivityDate(posts));

        return postsDetails;
    }
}
