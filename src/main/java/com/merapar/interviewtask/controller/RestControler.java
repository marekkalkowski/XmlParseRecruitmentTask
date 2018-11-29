package com.merapar.interviewtask.controller;

import com.merapar.interviewtask.post.Post;
import com.merapar.interviewtask.post.PostAnalyzeService;
import com.merapar.interviewtask.service.SaxXmlParseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class RestControler {

    @Autowired
    private SaxXmlParseImpl xmlParse;

    @Autowired
    private PostAnalyzeService postAnalyzeService;


    @PostMapping("/analyze")
    public List<Post> home() {
        xmlParse.parseXml();
       return postAnalyzeService.getPostList();
    }

    @PostMapping("/analyze/first-post")
    public LocalDateTime fisrtPostDate() {
        xmlParse.parseXml();
        return postAnalyzeService.firstPostDate(postAnalyzeService.getPostList());
    }

    @PostMapping("/analyze/avg-score")
    public double avarageScore() {
        xmlParse.parseXml();
        return postAnalyzeService.avarageScore(postAnalyzeService.getPostList());
    }
}
