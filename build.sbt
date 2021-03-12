name := """akka-scheduler"""

version := "1.0"

scalaVersion := "2.11.12"

lazy val dependencies = Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.11" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test")

// --------------------------------------------------------------------------------
// Root Project
// --------------------------------------------------------------------------------
lazy val root = Project("akka-scheduler", file(".")).aggregate(akkaScala, akkaJava)

// --------------------------------------------------------------------------------
// Akka Java
// --------------------------------------------------------------------------------
lazy val akkaJava = Project("akka-java", file("akka-java"))
  .settings(libraryDependencies ++= dependencies)

// --------------------------------------------------------------------------------
// Akka Scala
// --------------------------------------------------------------------------------
lazy val akkaScala = Project("akka-scala", file("akka-scala"))
  .settings(libraryDependencies ++= dependencies)

