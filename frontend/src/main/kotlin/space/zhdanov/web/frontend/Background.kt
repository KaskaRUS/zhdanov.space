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
    val displayObject: DisplayObject = getObject()

    private fun getObject(): DisplayObject {
        val container = PIXI.Container()
        for (star in stars) {
            container.addChild(star.displayObject)
        }
        return container
    }

    fun update(dt: Double) {
        for (star in stars) {
            star.update(dt)
        }
    }

    private fun generateListOfStars(count: Int): List<StarSprite> =
        (1..count).map {
            StarSprite(
                star = Star(
                    id = it.toLong(),
                    x = (Random.nextDouble() - 0.5) * width,
                    y = (Random.nextDouble() - 0.5) * height,
                    size = Random.nextDouble() * 0.1 + 0.01,
                    color = 0xFFFFFF
                ),
                speed = Random.nextDouble(0.0005, 0.001),
                coff = Random.nextDouble(1.0, 1.4)
            )
        }
}