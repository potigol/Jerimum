name := "jerimum"

version := "1.0.0"

scalaVersion := "2.12.12"

// opções de compilação
Compile / javacOptions ++= Seq("-source", "11", "-target", "11", "-Xlint")
Compile / scalacOptions ++= Seq("-deprecation")

// sbt-assembly
assembly / assemblyOutputPath := file("./jerimum.jar")

// dependências
libraryDependencies ++= Seq(
  "potigol" % "potigol_2.12" % "1.0-RC1" // % "provided"
)

// sbteclipse
//ThisBuild / EclipseKeys.withSource  := true
//ThisBuild / EclipseKeys.withJavadoc := true
//ThisBuild / EclipseKeys.createSrc   := EclipseCreateSrc.Default + EclipseCreateSrc.ManagedClasses
