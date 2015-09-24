import sbt.Keys._
import sbt._

object Build {
    def module(id: String): Project = Project(id, file(id))
        .settings(
            name := id,
            organization := "org.cosmin",
            organizationName := "Open Source",
            scalaVersion := "2.11.7",
            scalacOptions ++= Seq("-feature", "-deprecation")
        )
}