import Build._

lazy val root = sbt.project.in(file("."))
    .settings(
      name := "hashcash-app",
      organization := "org.cosmin",
      organizationName := "Open Source",
      scalaVersion := "2.11.7",
      scalacOptions ++= Seq("-feature", "-deprecation")
    )
    .dependsOn(hashcash)

lazy val hashcash = module("hashcash")