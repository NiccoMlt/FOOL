plugins {
    java
    application
    antlr
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    // Use ANTLR version 4
    antlr("org.antlr:antlr4:4.7.2")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

sourceSets {
  main {
    resources {
      srcDir("src/main/fool")
    }
  }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    val test by getting(Test::class) {
        // Use junit platform for unit tests
        useJUnitPlatform()
        testLogging {
            events(org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED, org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED, org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED)
            showStandardStreams = true
        }
    }
}
