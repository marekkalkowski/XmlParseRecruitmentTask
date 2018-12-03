package com.merapar.interviewtask.model;

import com.merapar.interviewtask.service.PostAnalyseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostAnalyseServiceTest {

    private List<Post> posts = new ArrayList<>();
    private PostAnalyseService postAnalyseService;

    @BeforeEach
    public void setUp() {

        postAnalyseService = new PostAnalyseService();

        posts.add(new Post(1, LocalDateTime.parse("2015-07-14T18:39:27.757"), 5,
                LocalDateTime.parse("2016-07-14T18:39:27.757"), "brak", 120));
        posts.add(new Post(2, LocalDateTime.parse("2016-07-14T18:39:27.757"), -1,
                LocalDateTime.parse("2017-07-14T18:39:27.757"), "AcceptedAnswerId", 15));
        posts.add(new Post(-2000, LocalDateTime.parse("0000-01-01T00:00:00.000"), -2000,
                LocalDateTime.parse("0000-01-01T00:00:00.000"), "AcceptedAnswerId", -2000));
    }

    @Test
    @DisplayName("Should pick up first post date")
    public void returnFirstPostDate() {
        //GIVEN
        LocalDateTime expected = LocalDateTime.parse("2015-07-14T18:39:27.757");
        //WHEN
        LocalDateTime result = postAnalyseService.firstPostDate(posts);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return last date of post")
    public void returnLastPostDate() {
        //GIVEN
        LocalDateTime expected = LocalDateTime.parse("2017-07-14T18:39:27.757");
        //WHEN
        LocalDateTime result = postAnalyseService.lastActivityDate(posts);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should count avarage Score for all posts")
    public void sholudReturnAvarageScore() {
        //GIVEN
        long expected = 2;
        //WHEN
        long result = postAnalyseService.avarageScore(posts);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Shuld return number of posts")
    public void returnPostsNumber() {
        //GIVEN
        long expected = 3;
        //WHEN
        long result = postAnalyseService.postsNumber(posts);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return number of posts with accepted answers")
    public void returnAcceptedPostsNumber() {
        //GIVEN
        long expected = 2;
        //WHEN
        long result = postAnalyseService.acceptedPostsNumber(posts);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return number of max view count of posts")
    void largestNumberOfViews() {
        //GIVEN
        int expected = 120;
        //WHEN
        int result = postAnalyseService.largestNumberOfViews(posts);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return number of maxScore")
    void maxScore() {
        //GIVEN
        int expected = 5;
        //WHEN
        int result = postAnalyseService.maxScore(posts);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return number of min Score")
    void minScore() {
        //GIVEN
        int expected = -1;
        //WHEN
        int result = postAnalyseService.minScore(posts);
        //THEN
        assertEquals(expected, result);
    }
}