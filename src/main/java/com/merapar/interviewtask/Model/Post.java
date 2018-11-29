package com.merapar.interviewtask.Model;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class Post {
    private int id;
    private LocalDateTime creationDate;
    private int score;
    private LocalDateTime lastActivityDate;
    //private int ViewCount;

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

//    public int getViewCount() {
//        return ViewCount;
//    }
//
//    public void setViewCount(int viewCount) {
//        ViewCount = viewCount;
//    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("id=").append(id);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", score=").append(score);
        sb.append(", lastActivityDate=").append(lastActivityDate);
        sb.append('}');
        return sb.toString();
    }
}
