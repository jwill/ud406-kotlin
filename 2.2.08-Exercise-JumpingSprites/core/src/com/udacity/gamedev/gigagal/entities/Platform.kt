package com.udacity.gamedev.gigagal.entities

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class Platform(left:Float, top:Float, width:Float, height:Float) {

    private var top: Float
    private var bottom: Float
    private var left: Float
    private var right:Float

    init {
        this.top = top
        this.bottom = top - height
        this.left = left
        this.right = left + width
    }

    fun render(renderer:ShapeRenderer) {
        val width = right - left
        val height = top - bottom

        renderer.color = Color.BLUE
        renderer.rect(left, bottom, width, height)
    }
}
