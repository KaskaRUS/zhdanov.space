package space.zhdanov.web.backend

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import space.zhdanov.web.entities.Star

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        jackson {
        }
    }

    routing {
        get("/stars") {
            call.respond(
                Star(
                    id = 1,
                    x = 10.0,
                    y = 10.0,
                    size = 1.0,
                    color = 0xFF00FF
                )
            )
        }
    }
}

