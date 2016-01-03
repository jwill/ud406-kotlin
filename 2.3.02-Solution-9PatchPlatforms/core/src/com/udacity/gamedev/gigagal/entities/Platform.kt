package com.udacity.gamedev.gigagal.entities

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.udacity.gamedev.gigagal.util.Assets

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
    fun render(batch:SpriteBatch) {
        // TODO: Draw the platform using a NinePatch
        val bottom = top - height
        Assets.platformAssets.ninePatch.draw(batch, left - 1, bottom - 1 , width + 2, height + 2)
    }
}
