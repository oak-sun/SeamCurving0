package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.sqrt

fun main(args: Array<String>) {
    var img = ImageIO.read(File(args[1]))
    repeat(args[5].toInt()) { img = clearSeam(img) }
    img = turn(img)
    repeat(args[7].toInt()) { img = clearSeam(img) }
    img = turn(img)
    ImageIO.write(img, "png", File(args[3]))
}

fun clearSeam(img: BufferedImage): BufferedImage {
    val (w, h) = listOf(img.width, img.height)
    val arrE = Array(h) { DoubleArray(w) }
    val arrCost = Array(h) { DoubleArray(w) { Double.POSITIVE_INFINITY } }
    val arrPrev = Array(h) { IntArray(w) }

    for (x in 0 until w) {
        for (y in 0 until h) {
            arrE[y][x] = sqrt((gradient(
                Color(img.getRGB(energy(x, w) - 1, y)),
                Color(img.getRGB(energy(x, w) + 1, y)))
                .plus(gradient(
                    Color(img.getRGB(x, energy(y, h) - 1)),
                    Color(img.getRGB(x, energy(y, h) + 1)))).toDouble()))
        }
    }
    arrE[0].forEachIndexed { x, e -> arrCost[0][x] = e }
    for (y in 1 until h) {
        for (x in 0 until w) {
            val left = if (x > 0) arrCost[y - 1][x - 1] else Double.POSITIVE_INFINITY
            val middle = arrCost[y - 1][x]
            val right = if (x < w - 1) arrCost[y - 1][x + 1] else Double.POSITIVE_INFINITY
            val mapCost = mapOf(x - 1 to left, x to middle, x + 1 to right)
            arrPrev[y][x] = mapCost.minByOrNull { it.value }?.key!!
            arrCost[y][x] = arrE[y][x] + mapCost.entries.minOf { it.value }
        }
    }
    var currentX = arrCost.last()
        .withIndex()
        .minByOrNull { it.value }?.index!!
    val seam = MutableList(h) { currentX }
    ((h-1) downTo 0)
        .forEach { y -> seam[y] = currentX; currentX =arrPrev[y][currentX] }

    return BufferedImage(w - 1, h, img.type)
        .apply { (0 until h).forEach { y -> (0 until seam[y]).forEach { x -> setRGB(x, y, img.getRGB(x, y)) }
            (seam[y] + 1 until w)
                .forEach { x -> setRGB(x - 1, y, img.getRGB(x, y)) } }
    }
}

fun energy(one: Int, two: Int) = when (one) {
    0 -> 1
    two - 1 -> two - 2
    else -> one
}

fun gradient(c1: Color, c2: Color): Int {
    val r = c1.red.minus(c2.red)
    val g = c1.green.minus(c2.green)
    val b = c1.blue.minus(c2.blue)
    return (r * r).plus(g * g).plus(b * b)
}

fun turn(img: BufferedImage) = BufferedImage(img.height, img.width, img.type)
    .apply {
        (0 until img.width)
            .forEach { x -> (0 until img.height)
            .forEach { y -> setRGB(y, x, img.getRGB(x, y)) }
            }
}

