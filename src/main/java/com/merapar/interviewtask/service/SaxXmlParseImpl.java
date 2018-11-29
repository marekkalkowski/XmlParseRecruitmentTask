package com.merapar.interviewtask.service;

import com.merapar.interviewtask.post.SAXHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;

@Service
public class SaxXmlParseImpl implements XmlParse {

    SAXParserFactory parserFactor = SAXParserFactory.newInstance();
    SAXParser parser;

    @Autowired
    SAXHandler handler;

    public SaxXmlParseImpl(SAXHandler handler) {
        this.handler = handler;
    }

    @Override
    public void parseXml() {
        try {
            InputSource inputSource = new InputSource(new URL("https://s3-eu-west-1.amazonaws.com/merapar-assessment/arabic-posts.xml").openStream());
            parser = parserFactor.newSAXParser();
            parser.parse(inputSource, handler);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

    }
}