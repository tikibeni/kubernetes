package project

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    val port = when (System.getenv("PORT")) {
        null -> 1234
        else -> System.getenv("PORT").toInt()
    }

    println(port)

    embeddedServer(Netty, port) {
        println("Server started in port $port")
        routing {
            get("/") {
                call.respondText("Hello, world")
            }
        }
    }.start(wait = true)
}