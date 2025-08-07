plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

kotlin{
    jvmToolchain(17)
}

dependencies{
    testImplementation(libs.junit)
}