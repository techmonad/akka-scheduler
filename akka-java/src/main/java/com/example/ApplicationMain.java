package com.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.util.Date;

public class ApplicationMain {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("AkkaJavaActorSystem");
        ActorRef scheduleActor = system.actorOf(ScheduleActor.props(), "ScheduleActor");
        for (Long id = 1L; id <= 1000L; id++) {
            scheduleActor.tell(new ScheduleActor.Schedule(id, new Date()), null);
        }

        // This example app will ping pong 3 times and thereafter terminate the ActorSystem -
        // see counter logic in PingActor
        system.awaitTermination();
    }

}