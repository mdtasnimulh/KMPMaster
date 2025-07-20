package org.tasnimulhasan.kmpmaster

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform