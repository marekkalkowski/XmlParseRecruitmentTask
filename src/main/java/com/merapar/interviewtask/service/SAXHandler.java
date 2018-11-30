package com.merapar.interviewtask.service;


import com.merapar.interviewtask.post.Post;
import com.merapar.interviewtask.post.PostAnalyseService;
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
    private Post post;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName) {
            case "posts":
                postAnalyseService.getPostList().clear();
                break;
            case "row":
                post = new Post();

                String id = checkIfAtrributIsNull(Optional.ofNullable(attributes.getValue("Id")));
                String score = checkIfAtrributIsNull(Optional.ofNullable(attributes.getValue("Score")));
                String creationDate = checkIfAtrributIsNull(Optional.ofNullable(attributes.getValue("CreationDate")));
                String lastActivityDate = checkIfAtrributIsNull(Optional.ofNullable(attributes.getValue("LastActivityDate")));
                String acceptedAnswer = checkIfAtrributIsNull(Optional.ofNullable(attributes.getValue("AcceptedAnswerId")));

                post.setId(Integer.parseInt(id));
                post.setScore(Integer.parseInt(score));
                post.setCreationDate(LocalDateTime.parse(creationDate));
                post.setLastActivityDate(LocalDateTime.parse(lastActivityDate));
                post.setAcceptedAnswerId(acceptedAnswer);

                postAnalyseService.addPostToList(post);
                break;
        }
    }

    private String checkIfAtrributIsNull(Optional<String> attribut) {
        String result;
        if (!attribut.isPresent()) {
            result = "brak";
        } else {
            result = attribut.get();
        }
        return result;
    }
}


