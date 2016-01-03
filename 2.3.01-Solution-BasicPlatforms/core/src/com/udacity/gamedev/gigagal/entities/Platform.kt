package com.udacity.gamedev.gigagal.entities

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class Platform(left:Float, top:Float, width:Float, height:Float) {

    // TODO: Add members for the platform top, bottom, left edge, right edge, width, and height
    var left:Float
    var top:Float
    var width:Float
    var height:Float

    init {
        // TODO: Populate the member variables
        this.left = left
        this.top = top
        this.width = width
        this.height = height
    }

    fun render(renderer:ShapeRenderer) {
        // TODO: Draw a box representing the platform
        renderer.rect(left, top, width, height)
    }
}
