plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.dependencyAnalysis)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
