plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.github.mrf1n"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(libs.kotest)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}