package com.merapar.interviewtask.service;

import com.merapar.interviewtask.model.PostsUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;

@Component
public class SaxXmlParseImpl implements XmlParse {

    private SAXParserFactory parserFactor = SAXParserFactory.newInstance();
    private SAXParser parser;
    private InputSource inputSource;

    @Autowired
    private SAXHandler handler;

    @Override
    public void parseXml(PostsUrl postsUrl) {
        try {
            inputSource = new InputSource(new URL(postsUrl.getUrl()).openStream());
            parser = parserFactor.newSAXParser();
            parser.parse(inputSource, handler);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}