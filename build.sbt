
// -------------------------------------------------------------------------------------------------------------------
// Root Project
// -------------------------------------------------------------------------------------------------------------------
lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        organization := "com.techmonal",
        version := "0.0.1-SNAPSHOT",
        scalaVersion := "2.13.5"
      )
    ),
    name := "akka-scheduler"
  )
  .aggregate(akkaScala, akkaJava)

// --------------------------------------------------------------------------------
// Akka Java 8
// --------------------------------------------------------------------------------
lazy val akkaJava = Project("akka-java", file("akka-java"))
  .settings(libraryDependencies ++= dependencies)

// --------------------------------------------------------------------------------
// Akka Scala
// --------------------------------------------------------------------------------
lazy val akkaScala = Project("akka-scala", file("akka-scala"))
  .settings(libraryDependencies ++= dependencies)

lazy val dependencies = Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.6.15",
  "com.typesafe.akka" %% "akka-testkit" % "2.6.15" % "test",
  "org.scalatest" %% "scalatest" % "3.2.9" % "test",
  "junit" % "junit" % "4.13.2" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)

addCommandAlias("validate", "; clean; compile; test;")
