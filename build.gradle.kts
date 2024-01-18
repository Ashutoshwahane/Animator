import org.jetbrains.dokka.gradle.DokkaTask


// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.gradle)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.gradle.maven.publish.plugin)
        classpath(libs.dokka.gradle.plugin)
        classpath(libs.spotless.plugin.gradle)
    }
}

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    id("com.diffplug.spotless") version "6.24.0"
}

apply(from = "${rootProject.projectDir}/spotless.gradle")



