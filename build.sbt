name := "AkkaClassicWithTyped"

version := "0.1"

scalaVersion := "2.13.5"

val akkaVersion = "2.6.14"
libraryDependencies +="com.typesafe.akka" %% "akka-actor" % akkaVersion
libraryDependencies +="com.typesafe.akka" %% "akka-actor-typed" % akkaVersion
libraryDependencies +="com.typesafe.akka" %% "akka-testkit" % akkaVersion
libraryDependencies +="com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion

libraryDependencies +="ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies +="org.scalatest" %% "scalatest" % "3.2.2" % Test

parallelExecution in Test := false
