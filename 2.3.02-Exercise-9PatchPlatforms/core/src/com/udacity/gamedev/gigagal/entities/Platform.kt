package com.udacity.gamedev.gigagal.entities

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class Platform(left:Float, top:Float, width:Float, height:Float) {

    var left:Float
    var top:Float
    var width:Float
    var height:Float

    init {
        this.left = left
        this.top = top
        this.width = width
        this.height = height
    }

    // TODO: Change this to use a SpriteBatch now that we are using NinePatches
    fun render(renderer:ShapeRenderer) {
        // TODO: Draw the platform using a NinePatch
        renderer.rect(left, top, width, height)
    }
}
