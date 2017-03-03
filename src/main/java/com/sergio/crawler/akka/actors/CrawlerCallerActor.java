package com.sergio.crawler.akka.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Creator;
import com.sergio.crawler.domain.Site;

public class CrawlerCallerActor extends UntypedActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    private final ActorRef crawlerActorRef;
    private final Site site;

    @Override
    public void preStart() throws Exception {
        log.info("checking {} ", site);
        crawlerActorRef.tell(site, getSelf());
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        Site site = (Site) message;
        log.info("Caller got back site {} ", site);

    }

    public static Props props(ActorRef crawlerActorRef, Site site){
        return Props.create(new Creator<CrawlerCallerActor>() {
            private static final long serialVersionUID = 1L;

            @Override
            public CrawlerCallerActor create() throws Exception {
                return new CrawlerCallerActor(crawlerActorRef, site);
            }
        });
    }


    private CrawlerCallerActor(ActorRef crawlerActorRef, Site site) {

        this.crawlerActorRef = crawlerActorRef;
        this.site = site;


    }
}
