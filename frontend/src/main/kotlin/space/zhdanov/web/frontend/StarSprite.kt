package space.zhdanov.web.frontend

import PIXI.BLEND_MODES
import PIXI.DisplayObject
import space.zhdanov.web.entities.Star

class StarSprite(val star: Star, val speed: Double = 0.001, val coff: Double = 1.3) {

    val texture = PIXI.Texture.fromImage("img/star.png")
    val displayObject: DisplayObject = getObject()
    private var size = star.size
    private val maxSize = size * coff
    private var dir = 1

    private fun getObject(): DisplayObject =
        PIXI.Sprite(texture).apply {
            x = star.x
            y = star.y
            tint = star.color
            scale.set(star.size, star.size)
            blendMode = BLEND_MODES.SCREEN
        }

    fun update(dt: Double) {
        if (size < star.size)
            dir = 1
        if (size > maxSize)
            dir = -1

        size += dir * dt * speed

        displayObject.scale.set(size)
    }
}