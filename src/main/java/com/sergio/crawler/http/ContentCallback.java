package com.sergio.crawler.http;

import org.apache.http.concurrent.FutureCallback;


public final class ContentCallback implements FutureCallback<String> {

    public String content;

    @Override
    public void completed(String s) {

        content = s;

    }

    public void failed(final Exception ex) {
        // do something
    }


    public void cancelled() {
        // do something
    }
}
