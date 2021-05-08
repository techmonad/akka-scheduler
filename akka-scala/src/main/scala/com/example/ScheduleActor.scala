package com.example

import akka.actor.{Actor, ActorLogging, Props}

import java.util.Date
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

/**
  * Created by anand on 1/14/16.
  */
class ScheduleActor extends Actor with ActorLogging {
  import ScheduleActor._

  def receive = {
    case Schedule(id, date) =>
      log.info("Received message for id: {} and on: {}", id, date)
      context.system.scheduler.scheduleOnce(5 seconds, self, Schedule(id, new Date))
  }

}

object ScheduleActor {
  val props = Props[ScheduleActor]
  case class Schedule(id: Long, time: Date)
}