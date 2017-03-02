package com.sergio;


import com.sergio.crawler.domain.Site;

import com.sergio.crawler.implementation.CrawlerImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by sergio on 3/1/17.
 */
public class CrawlerTests {

    private Site site;

    private CrawlerImplementation crawlerImplementation = new CrawlerImplementation();

    @Before
    public void setUp(){

        site = new Site("http://www.bbc.co.uk/news");

        boolean isReadable = crawlerImplementation.isUrlReadable(site.getURL());

        site.setReadable(isReadable);

    }


    @Test
    public void Site_Should_Be_Readable(){

        Assert.assertThat(site.isReadable(), is(true));

    }


}
