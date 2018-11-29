package com.merapar.interviewtask.controller;

import com.merapar.interviewtask.Model.Post;
import com.merapar.interviewtask.Model.PostAnalyzeService;
import com.merapar.interviewtask.Model.SAXHandler;
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
        return postAnalyzeService.firstPostDate();
    }

    @PostMapping("/analyze/avg-score")
    public double avarageScore() {
        xmlParse.parseXml();
        return postAnalyzeService.avarageScore();
    }
}
