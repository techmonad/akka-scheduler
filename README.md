# akka-scheduler
Schedule sending of messages to actors and execution of tasks

The approach using schedule is one good approach, although there is a potential for the messages to queue up if the work done on schedule is so great that it might take longer than the scheduled interval. If you want the interval to occur between the end of one iteration and the beginning of the next, then use scheduleOnce.
#### Execute Scala Scheduler
```
$ ./activator "project akka-scala" run
```

#### Execute Java Scheduler
```
$ ./activator "project akka-java" run
```

