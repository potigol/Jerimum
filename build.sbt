name := "jerimum"

version := "0.9.16"

scalaVersion := "2.12.8"

javacOptions in Compile ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
scalacOptions in Compile ++= Seq("-deprecation")

assemblyOutputPath in assembly := file("./jerimum.jar")

libraryDependencies ++= Seq(
  "potigol" % "potigol_2.12" % "0.9.16" % "provided"
)

EclipseKeys.withSource in ThisBuild := true
EclipseKeys.withJavadoc in ThisBuild := true
EclipseKeys.createSrc in ThisBuild := EclipseCreateSrc.Default + EclipseCreateSrc.ManagedClasses