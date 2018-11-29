package com.merapar.interviewtask.post;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostAnalyzeServiceTest {

    private PostAnalyzeService postAnalyzeService;

    @Before
    public void setUp() throws Exception {

        postAnalyzeService = new PostAnalyzeService();
    }

    @Test
    public void firstPostDate() {
        //arrange
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, LocalDateTime.parse("2015-07-14T18:39:27.757"), 5, LocalDateTime.parse("2016-07-14T18:39:27.757")));
        posts.add(new Post(2, LocalDateTime.parse("2016-07-14T18:39:27.757"), 5, LocalDateTime.parse("2017-07-14T18:39:27.757")));
        //act
        LocalDateTime result = postAnalyzeService.firstPostDate(posts);
        //asssert
        assertEquals(result, LocalDateTime.parse("2015-07-14T18:39:27.757"));
    }

    @Test
    public void avarageScore() {
        //arrange
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, LocalDateTime.parse("2015-07-14T18:39:27.757"), 5, LocalDateTime.parse("2016-07-14T18:39:27.757")));
        posts.add(new Post(2, LocalDateTime.parse("2016-07-14T18:39:27.757"), 5, LocalDateTime.parse("2017-07-14T18:39:27.757")));
        //act
        long result = postAnalyzeService.avarageScore(posts);
        //asssert
        assertEquals(result, 5);
    }
}