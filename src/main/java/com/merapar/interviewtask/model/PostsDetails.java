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
    private int maxScore;
    private int minScore;
    private int largestNumberOfViews;

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

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public int getLargestNumberOfViews() {
        return largestNumberOfViews;
    }

    public void setLargestNumberOfViews(int largestNumberOfViews) {
        this.largestNumberOfViews = largestNumberOfViews;
    }
}
