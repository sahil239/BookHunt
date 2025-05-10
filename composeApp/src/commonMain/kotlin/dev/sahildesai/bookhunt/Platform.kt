package dev.sahildesai.bookhunt

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform