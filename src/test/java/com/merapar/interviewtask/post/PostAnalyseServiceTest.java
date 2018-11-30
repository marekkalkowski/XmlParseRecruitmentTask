package com.merapar.interviewtask.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PostAnalyseServiceTest {

    private List<Post> posts = new ArrayList<>();
    private PostAnalyseService postAnalyseService;

    @Before
    public void setUp() throws Exception {

        postAnalyseService = new PostAnalyseService();

        posts.add(new Post(1, LocalDateTime.parse("2015-07-14T18:39:27.757"), 5,
                LocalDateTime.parse("2016-07-14T18:39:27.757"), "brak"));
        posts.add(new Post(2, LocalDateTime.parse("2016-07-14T18:39:27.757"), 3,
                LocalDateTime.parse("2017-07-14T18:39:27.757"), "AcceptedAnswerId"));
    }

    @Test
    @DisplayName("Should pick up first post date")
    public void returnFirstPostDate() {
        //act
        LocalDateTime result = postAnalyseService.firstPostDate(posts);
        //asssert
        assertEquals(result, LocalDateTime.parse("2015-07-14T18:39:27.757"));
    }

    @Test
    @DisplayName("Should pick up last date of post d")
    public void returnLastPostDate() {
        //act
        LocalDateTime result = postAnalyseService.lastActivityDate(posts);
        //asssert
        assertEquals(result, LocalDateTime.parse("2017-07-14T18:39:27.757"));
    }

    @Test
    @DisplayName("Should count avarage Score for all posts")
    public void returnAvarageScore() {
        //act
        long result = postAnalyseService.avarageScore(posts);
        //asssert
        assertEquals(result, 4);
    }

    @Test
    @DisplayName("Shuld return number of posts")
    public void returnPostsNumber() {
        //act
        long result = postAnalyseService.postsNumber(posts);
        //asssert
        assertEquals(result, 2);
    }

    @Test
    @DisplayName("Should return number of posts with accepted answers")
    public void returnAcceptedPostsNumber() {
        //act
        long result = postAnalyseService.acceptedPostsNumber(posts);
        //asssert
        assertEquals(result, 1);
    }
}