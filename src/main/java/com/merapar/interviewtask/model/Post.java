package com.merapar.interviewtask.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Post {
    private int id;
    private LocalDateTime creationDate;
    private int score;
    private LocalDateTime lastActivityDate;
    private String AcceptedAnswerId;

    public Post() {
    }

    public Post(int id, LocalDateTime creationDate, int score, LocalDateTime lastActivityDate, String acceptedAnswerId) {
        this.id = id;
        this.creationDate = creationDate;
        this.score = score;
        this.lastActivityDate = lastActivityDate;
        AcceptedAnswerId = acceptedAnswerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(LocalDateTime lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getAcceptedAnswerId() {
        return AcceptedAnswerId;
    }

    public void setAcceptedAnswerId(String acceptedAnswerId) {
        AcceptedAnswerId = acceptedAnswerId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("id=").append(id);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", score=").append(score);
        sb.append(", lastActivityDate=").append(lastActivityDate);
        sb.append(", AcceptedAnswerId='").append(AcceptedAnswerId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}



