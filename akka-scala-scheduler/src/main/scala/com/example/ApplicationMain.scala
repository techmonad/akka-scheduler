package com.example

import java.util.Date

import akka.actor.ActorSystem

object ApplicationMain extends App {
  val system = ActorSystem("SchedulerActorSystem")
  val scheduleActor = system.actorOf(ScheduleActor.props, "ScheduleActor")
  1 to 1000 foreach { id => scheduleActor ! ScheduleActor.Schedule(id, new Date)}

  system.awaitTermination()
}