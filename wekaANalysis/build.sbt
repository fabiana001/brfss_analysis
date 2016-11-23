name := "wekaANalysis"

version := "1.0"

scalaVersion := "2.12.0"

libraryDependencies += ("nz.ac.waikato.cms.weka" % "weka-stable" % "3.8.0").exclude("nz.ac.waikato.cms.weka.thirdparty","java-cup-11b-runtime")

resolvers += "weka repo" at "https://mvnrepository.com/artifact/nz.ac.waikato.cms.weka/weka-stable"
