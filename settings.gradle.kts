pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Đã sửa lỗi: Cú pháp Kotlin DSL cho custom Maven repository
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "Image Viewer App"
include(":app")