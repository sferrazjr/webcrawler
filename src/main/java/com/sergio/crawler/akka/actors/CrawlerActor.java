package com.sergio.crawler.akka.actors;


import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Creator;
import com.sergio.crawler.domain.Site;
import com.sergio.crawler.implementation.CrawlerImplementation;

public class CrawlerActor extends UntypedActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private CrawlerImplementation crawlerImplementation;

    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof Site) {
            Site site = (Site) message;
            log.info("Crawler received site {} ", site);

            boolean isUrlOfNewsSite = crawlerImplementation.isUrlOfNewsSite(site.getURL());
            site.setSiteOfNews(isUrlOfNewsSite);

            log.info("isUrlOfNewsSite = {}", isUrlOfNewsSite);

            log.info("getSender {} ", getSender());

            getSender().tell(site, getSelf());

        } else {
            unhandled(message);
        }
    }

    public static Props props(){
        return Props.create(new Creator<CrawlerActor>() {
            private static final long serialVersionUID = 1L;

            @Override
            public CrawlerActor create() throws Exception {
                return new CrawlerActor();
            }
        });
    }


    private CrawlerActor() {
        crawlerImplementation = new CrawlerImplementation();
    }
}
