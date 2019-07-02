package space.zhdanov.backend.controllers

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import space.zhdanov.web.entities.Star
import java.time.Duration
import kotlin.random.Random

@RestController
@RequestMapping("stars")
open class StarsController {

    @RequestMapping(method = [RequestMethod.GET], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun background(
        @RequestParam width: Int,
        @RequestParam height: Int,
        @RequestParam("max_size") maxSize: Double,
        @RequestParam(defaultValue = "300") count: Long
    ): Flux<Star> =
        Flux.interval(Duration.ofMillis(100))
            .take(count)
            .map {
                Star(
                    x = (Random.nextDouble() - 0.5) * 2 * width,
                    y = (Random.nextDouble() - 0.5) * 2 * height,
                    id = it,
                    size = Random.nextDouble() * maxSize,
                    color = 0xFFFFFF
                )
            }
}