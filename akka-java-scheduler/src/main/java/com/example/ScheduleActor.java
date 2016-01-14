package com.example;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.concurrent.duration.Duration;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by anand on 1/14/16.
 */
public class ScheduleActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public static Props props() {
        return Props.create(ScheduleActor.class);
    }

    public static class Schedule {
        private final Long id;
        private final Date date;

        public Schedule(Long id, Date date) {
            this.id = id;
            this.date = date;
        }

        public Long getId() {
            return id;
        }

        public Date getDate() {
            return date;
        }
    }

    public void onReceive(Object message) throws Exception {
        if (message instanceof Schedule) {
            Schedule schedule = (Schedule) message;
            Schedule newMsg = new Schedule(schedule.getId(), new Date());
            log.info("Received message for id: {} and on: {}", schedule.getId(), schedule.getDate());
            getContext().system().scheduler().scheduleOnce(Duration.create(5, TimeUnit.SECONDS),
                    () -> {
                        getSelf().tell(newMsg, ActorRef.noSender());
                    }, getContext().system().dispatcher());
        } else {
            unhandled(message);
        }
    }
}
