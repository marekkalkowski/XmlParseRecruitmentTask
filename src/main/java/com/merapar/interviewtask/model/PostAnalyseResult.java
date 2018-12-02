package com.merapar.interviewtask.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostAnalyseResult {

    private LocalDateTime analyseDate;

    @Autowired
    private PostsDetails postsDetails;

    public LocalDateTime getAnalyseDate() {
        return analyseDate;
    }

    public void setAnalyseDate(LocalDateTime analyseDate) {
        this.analyseDate = analyseDate;
    }

    public PostsDetails getPostsDetails() {
        return postsDetails;
    }

    public void setPostsDetails(PostsDetails postsDetails) {
        this.postsDetails = postsDetails;
    }


}
