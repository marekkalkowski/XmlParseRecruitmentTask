package com.merapar.interviewtask.service;

import com.merapar.interviewtask.model.Post;
import com.merapar.interviewtask.repository.PostRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class SAXHandler extends DefaultHandler {

    @Autowired
    private PostAnalyseService postAnalyseService;

    @Autowired
    private PostRepositoryImpl postRepositoryImpl;

    @Autowired
    private Post post;

    private String stringValueIfParamIsNull = "brak";
    private String dateValueIfParamIsNull = "0000-01-01T00:00:00.000";
    private String intValueIfParamIsNull = "-2000";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName) {
            case "row":
                post = new Post();

                String id = Optional.ofNullable(attributes.getValue("Id")).orElse(intValueIfParamIsNull);
                String score = Optional.ofNullable(attributes.getValue("Score")).orElse(intValueIfParamIsNull);
                String creationDate = Optional.ofNullable(attributes.getValue("CreationDate")).orElse(dateValueIfParamIsNull);
                String lastActivityDate = (Optional.ofNullable(attributes.getValue("LastActivityDate")).orElse(dateValueIfParamIsNull));
                String acceptedAnswer = Optional.ofNullable(attributes.getValue("AcceptedAnswerId")).orElse(stringValueIfParamIsNull);
                String viewCount = Optional.ofNullable(attributes.getValue("ViewCount")).orElse(intValueIfParamIsNull);

                post.setId(Integer.parseInt(id));
                post.setScore(Integer.parseInt(score));
                post.setCreationDate(LocalDateTime.parse(creationDate));
                post.setLastActivityDate(LocalDateTime.parse(lastActivityDate));
                post.setAcceptedAnswerId(acceptedAnswer);
                post.setViewCount(Integer.parseInt(viewCount));

                postRepositoryImpl.addPostToList(post);
                break;
        }
    }
}


