import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
    application
}

val kotlinVersion = "1.4.10"

group = "com.cqfn.degitx.degitx-simulator"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("com.google.code.gson:gson:2.8.6")

    testImplementation("org.mockito:mockito-core:2.+")
    testImplementation("org.testng:testng-6.14.3")
}

val compileKotlin: KotlinCompile by tasks
val compileTestKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions.jvmTarget = "11"
compileTestKotlin.kotlinOptions.jvmTarget = "11"

tasks.test {
    // enable TestNG support (default is JUnit)
    useTestNG()
}

application {
    mainClass.set("com.cqfn.degitx.simulator.Simulator")
}
