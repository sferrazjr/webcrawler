package com.sergio.crawler;

import org.springframework.stereotype.Component;

@Component
public interface Crawler<T> {

    T parser(String url);

}
