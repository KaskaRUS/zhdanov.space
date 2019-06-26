package space.zhdanov.web.frontend

import PIXI.Container
import kotlin.browser.document
import kotlin.js.json

class App {

    var size = getSizeCanvas()
    val pixi = PIXI.Application(
        size.width, size.height, json(
            "backgroundColor" to 0x0
        )
    )

    init {
        document.body!!.appendChild(pixi.view)
        val container = Container().apply {
            x = size.width / 2
            y = size.height / 2
        }

        val background = Background(count = 300, width = size.width, height = size.height)
        container.addChild(background.getObject())
        pixi.stage.addChild(container)
    }

    fun getSizeCanvas(): Size {
        val width = document.defaultView!!.innerWidth
        val height = document.defaultView!!.innerHeight

        return if (width < height)
            Size(1000 * (width / height.toDouble()), 1000.0)
        else
            Size(1000.0, 1000 * (height / width.toDouble()))
    }
}

data class Size(val width: Double, val height: Double)