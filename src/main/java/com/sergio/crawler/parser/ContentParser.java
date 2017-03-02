package com.sergio.crawler.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ContentParser {

    public boolean isContainsNewsInTheTitle(String webContent) {
        Document doc = Jsoup.parse(webContent);

        String title = doc.title();

        return title.toUpperCase().contains("NEWS") || title.toUpperCase().contains("NOTICIA");
    }


}
