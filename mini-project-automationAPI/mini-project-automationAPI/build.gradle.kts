plugins {
    id("java")
}


version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}


dependencies {
    implementation("org.json:json:20240303")
    implementation("org.apache.poi:poi-ooxml:5.2.5")
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    testImplementation("org.testng:testng:7.9.0")

}


tasks.test {
    useTestNG()
}

