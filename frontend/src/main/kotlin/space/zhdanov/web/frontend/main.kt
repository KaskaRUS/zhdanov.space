package space.zhdanov.web.frontend

import kotlin.browser.document
import kotlin.js.json

fun main() {

    val size = getSizeCanvas(
        width = document.defaultView!!.innerWidth,
        height = document.defaultView!!.innerHeight
    )

    val app = PIXI.Application(size.width, size.height, json(
        "backgroundColor" to 0x0
    ))
    document.body!!.appendChild(app.view)
}

fun getSizeCanvas(width: Int, height: Int) =
    if (width < height)
        Size(1000 * (width / height.toFloat()), 1000f)
    else
        Size(1000f, 1000 * (height / width.toFloat()))

data class Size(val width: Float, val height: Float)
