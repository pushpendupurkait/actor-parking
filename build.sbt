name := "actor-parking"

version := "0.1"

scalaVersion := "2.12.4"

logLevel := Level.Info

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.8",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.8" % Test
)
