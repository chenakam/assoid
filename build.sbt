enablePlugins(AndroidLib)

name := baseDirectory.value.getName // 意为android assists

organization := "hobby.chenai.nakam"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.7"

// 等同于两句：targetSdkVersion, compileSdkVersion
platformTarget in Android := "android-27"

buildToolsVersion in Android := Some("27.0.3")

minSdkVersion in Android := "21"

//lazy val root = (project in file(".")).dependsOn(project in file("../lang"))

// plugin.sbt 里面的设置已注释掉，官方文档没有那一句，从 Scaloid 里面拿来的。
proguardVersion := "5.2.1" // 必须高于 5.1，见 https://github.com/scala-android/sbt-android。

offline := true

// 解决生成文档报错导致 jitpack.io 出错的问题。
publishArtifact in packageDoc := false

resolvers += "google" at "https://maven.google.com"
// 如果要用 jitpack 打包的话就加上，打完了再注掉。
//resolvers += "jitpack" at "https://jitpack.io"

libraryDependencies ++= Seq(
  // 如果要用 jitpack 打包的话就加上，打完了再注掉。
  // TODO: 独立使用本库的话，应该启用本依赖。
  //  "com.github.dedge-space" % "annoguard" % "1.0.3-beta",
  //  "com.github.dedge-space" % "annoid" % "ac8b616eec",
  //  "com.github.dedge-space" % "scala-lang" % "4db02cf2fd",
  //  "com.github.dedge-space" % "reflow" % "7d1eac2937",

  "com.android.support" % "appcompat-v7" % "27.1.1" excludeAll (
    ExclusionRule(organization = "android.arch.core") /*,
    // `Fragment`里面用到一些组件。
    ExclusionRule(organization = "android.arch.lifecycle")*/
    ),
  "com.android.support" % "recyclerview-v7" % "27.1.1",
  "com.j256.ormlite" % "ormlite-android" % "[5.1,)",

  "io.getquill" %% "quill-jdbc" % "[2.5.4,)",
  // 我们不用这个驱动（不过还是得导入，如果不导入的话，会自动导入一个低版本的）。
  "org.xerial" % "sqlite-jdbc" % "[3.23.1,)",
  // 这是基于 android SQLiteDatabase 开发的一个 jdbc 驱动。
  "com.fortysevendeg" %% "mvessel-android" % "[0.1,)"
)
