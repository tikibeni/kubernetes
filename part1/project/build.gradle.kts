import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"

    application
}

group = "project"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-server-core:2.0.2")
    implementation("io.ktor:ktor-server-netty:2.0.2")
    implementation("ch.qos.logback:logback-classic:1.2.11")
}

application {
    mainClass.set("project.MainKt")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.named<ShadowJar>("shadowJar").configure {
    minimize()
}

tasks {
    build {
        dependsOn(shadowJar)

    }
}

tasks.withType<Test> {
    environment("PORT", "8080")
}
