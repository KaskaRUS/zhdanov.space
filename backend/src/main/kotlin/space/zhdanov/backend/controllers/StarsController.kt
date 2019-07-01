package space.zhdanov.backend.controllers

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import space.zhdanov.web.entities.Star
import java.time.Duration
import kotlin.random.Random

@RestController
@RequestMapping("stars")
open class StarsController {

    @RequestMapping(method = [RequestMethod.GET], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun background(): Flux<Star> =
        Flux.interval(Duration.ofMillis(1000))
            .take(10)
            .map {
                Star(
                    x = Random.nextDouble(),
                    y = Random.nextDouble(),
                    id = it,
                    size = Random.nextDouble(),
                    color = Random.nextInt()
                )
            }
}