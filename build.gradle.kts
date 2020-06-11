import com.github.jengelman.gradle.plugins.shadow.ShadowPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

plugins {
  kotlin("jvm") version "1.3.72"
  id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "me.ricky"
version = "1.0-SNAPSHOT"

allprojects {
  apply<KotlinPluginWrapper>()
  apply<ShadowPlugin>()

  repositories {
    mavenCentral()
  }

  kotlin.sourceSets["main"].kotlin.srcDir("./src/")
  sourceSets["main"].resources.srcDir("./resources/")

  tasks {
    shadowJar {
      configurations = listOf(project.configurations["shadow"])
      destinationDirectory.set(rootProject.file("./jars"))
    }

    compileKotlin {
      kotlinOptions.jvmTarget = "1.8"
    }

    compileTestKotlin {
      kotlinOptions.jvmTarget = "1.8"
    }
  }
}
