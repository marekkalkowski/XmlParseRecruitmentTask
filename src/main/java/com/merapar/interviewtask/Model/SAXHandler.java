package com.merapar.interviewtask.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class SAXHandler extends DefaultHandler {

    @Autowired
    private PostAnalyzeService postAnalyzeService;
    private Post post;
    private String sb;



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {


        switch(qName){
            case "posts":
                postAnalyzeService.getPostList().clear();
                break;
            case "row":
            post = new Post();
            String id = attributes.getValue("Id");
            String score = attributes.getValue("Score");
            String creationDate = attributes.getValue("CreationDate");
            String lastActivityDate = attributes.getValue("LastActivityDate");
            //String viewCount = attributes.getValue("ViewCount");
            post.setId(Integer.parseInt(id));
            post.setScore(Integer.parseInt(score));
            post.setCreationDate(LocalDateTime.parse(creationDate));
            post.setLastActivityDate(LocalDateTime.parse(lastActivityDate));
            //post.setViewCount(Integer.parseInt(viewCount));
                postAnalyzeService.addPostToList(post);
            break;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb = String.copyValueOf(ch, start, length).trim();
    }
}
