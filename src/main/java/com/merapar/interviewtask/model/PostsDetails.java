package com.merapar.interviewtask.model;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class PostsDetails {

    private LocalDateTime firstPost;
    private LocalDateTime lastPost;
    private long totalPosts;
    private long totalAcceptedPosts;
    private long avgScore;

    public LocalDateTime getFirstPost() {
        return firstPost;
    }

    public void setFirstPost(LocalDateTime firstPost) {
        this.firstPost = firstPost;
    }

    public LocalDateTime getLastPost() {
        return lastPost;
    }

    public void setLastPost(LocalDateTime lastPost) {
        this.lastPost = lastPost;
    }

    public long getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(long totalPosts) {
        this.totalPosts = totalPosts;
    }

    public long getTotalAcceptedPosts() {
        return totalAcceptedPosts;
    }

    public void setTotalAcceptedPosts(long totalAcceptedPosts) {
        this.totalAcceptedPosts = totalAcceptedPosts;
    }

    public long getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(long avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostsDetails{");
        sb.append("firstPost=").append(firstPost);
        sb.append(", lastPost=").append(lastPost);
        sb.append(", totalPosts=").append(totalPosts);
        sb.append(", totalAcceptedPosts=").append(totalAcceptedPosts);
        sb.append(", avgScore=").append(avgScore);
        sb.append('}');
        return sb.toString();
    }
}
