buildscript {
    repositories {
        mavenCentral()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-frontend-plugin:${Versions.kotlinFrontend}")
    }
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://dl.bintray.com/kotlin/kotlin-js-wrappers")
        maven("https://kotlin.bintray.com/kotlinx")
    }
}