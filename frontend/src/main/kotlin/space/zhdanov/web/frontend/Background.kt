package space.zhdanov.web.frontend

import PIXI.BLEND_MODES
import PIXI.DisplayObject
import space.zhdanov.web.entities.Star
import kotlin.random.Random

class Background(
    val count: Int,
    val width: Double,
    val height: Double
) {
    val stars = generateListOfStars(count)
    val texture = PIXI.Texture.fromImage("img/star.png")

    fun getObject(): DisplayObject {
        val container = PIXI.Container()
        for (star in stars) {
            container.addChild(
                PIXI.Sprite(texture).apply {
                    x = star.x
                    y = star.y
                    scale.set(star.size, star.size)
                    blendMode = BLEND_MODES.SCREEN
                }
            )
        }
        return container
    }

    private fun generateListOfStars(count: Int): List<Star> =
        (1..count).map {
            Star(
                id = it.toLong(),
                x = (Random.nextDouble() - 0.5) * width,
                y = (Random.nextDouble() - 0.5) * height,
                size = Random.nextDouble(),
                color = 0xFFFFFF
            )
        }
}