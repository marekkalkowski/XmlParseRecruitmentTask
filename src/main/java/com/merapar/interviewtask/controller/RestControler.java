package com.merapar.interviewtask.controller;

import com.merapar.interviewtask.post.*;
import com.merapar.interviewtask.service.SaxXmlParseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class RestControler {

    @Autowired
    private PostDetailsInstanceGenerator postDetailsInstanceGenerator;
    @Autowired
    private PostAnalyseResult postAnalyseResult;
    @Autowired
    private SaxXmlParseImpl xmlParse;
    @Autowired
    private PostAnalyseService postAnalyseService;

    @PostMapping("/analyze")
    public PostAnalyseResult home(@RequestBody PostsUrl postsUrl) {
        xmlParse.parseXml(postsUrl);
        postAnalyseResult = new PostAnalyseResult();
        postAnalyseResult.setAnalyseDate(LocalDateTime.now());
        postAnalyseResult.setPostsDetails(postDetailsInstanceGenerator.generatePostDetailsInstance());
        return postAnalyseResult;
    }

    @PostMapping("/analyze/posts-list")
    public List<Post> posts(@RequestBody PostsUrl postsUrl) {
        xmlParse.parseXml(postsUrl);
        return postAnalyseService.getPostList();
    }
}