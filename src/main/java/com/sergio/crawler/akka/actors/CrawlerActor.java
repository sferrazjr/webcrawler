package com.sergio.crawler.akka.actors;


import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Creator;
import com.sergio.crawler.domain.Site;


public class CrawlerActor extends UntypedActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof Site) {
            Site site = (Site) message;
            log.info("Crawler received site {} ", site);

//            boolean isUrlOfNewsSite = (new CrawlerImplementation(site.getURL())).isUrlOfNewsSite();

  //          site.setSiteOfNews(isUrlOfNewsSite);

    //        log.info("isUrlOfNewsSite = {}", isUrlOfNewsSite);


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


}
