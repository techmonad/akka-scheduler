# [akka-scheduler](http://www.typesafe.com/activator/template/akka-scheduler) [![Scala CI](https://github.com/techmonad/akka-scheduler/actions/workflows/scala.yml/badge.svg?branch=master)](https://github.com/techmonad/akka-scheduler/actions/workflows/scala.yml)

Schedule sending of messages to actors and execution of tasks

The approach using schedule is one good approach, although there is a potential for the messages to queue up if the work done on schedule is so great that it might take longer than the scheduled interval. If you want the interval to occur between the end of one iteration and the beginning of the next, then use scheduleOnce.

#### Create project using activator command

If you have Typesafe Activator, use its command line mode to create a new project from this template.

Type `activator new PROJECTNAME akka-scheduler` on the command line. 

#### Execute Scala Scheduler
```
$ ./activator "project akka-scala" run
```

#### Execute Java Scheduler
```
$ ./activator "project akka-java" run
```

