plugins {
    `java-library`
    id("io.papermc.paperweight.userdev") version "1.7.7"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "xyz.solbangul.blockhostname"
version = "1.0"

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    paperweight.paperDevBundle("1.21-R0.1-SNAPSHOT")
}

tasks {
    withType<JavaCompile>().configureEach {
        options.release.set(21)
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }

    shadowJar {
        archiveFileName.set("AllowHostname.jar")
        destinationDirectory.set(File("경로"))
    }

    build {
        dependsOn(shadowJar)
    }
}
