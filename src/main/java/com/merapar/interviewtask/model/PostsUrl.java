package com.merapar.interviewtask.model;

import org.springframework.stereotype.Component;

@Component
public class PostsUrl {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
