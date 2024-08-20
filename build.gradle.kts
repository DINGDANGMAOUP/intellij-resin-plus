import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.0.1"
}
val revision: String by project
val groupId: String by project

group = groupId
version = revision

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}


// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
dependencies {
    intellijPlatform {
        intellijIdeaUltimate("2024.2")
        bundledPlugins(
            listOf(
                "com.intellij.java",
                "com.intellij.javaee",
                "com.intellij.javaee.app.servers.integration"
            )
        )
        pluginVerifier()
        zipSigner()
        instrumentationTools()
        testFramework(TestFrameworkType.Platform)
    }
    testImplementation("junit:junit:4.13.2")
}

tasks.buildPlugin {
    archiveFileName.set("intellij-resin-plus.zip")
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
    withType<Jar> {
        from(sourceSets["main"].java.srcDirs) {
            include("**/*")
        }
    }

}
