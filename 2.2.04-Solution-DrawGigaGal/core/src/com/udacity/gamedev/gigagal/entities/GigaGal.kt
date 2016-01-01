package com.udacity.gamedev.gigagal.entities

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.udacity.gamedev.gigagal.util.Assets
import com.udacity.gamedev.gigagal.util.Constants

class GigaGal {
    companion object {
        val TAG = GigaGal::class.java.toString()
    }

    // TODO: Add a position
    var position:Vector2

    init {
        // TODO: Initialize GigaGal's position with height = GIGAGAL_EYE_HEIGHT
        position = Vector2(20f, Constants.GIGAGAL_EYE_HEIGHT)
    }

    fun update(delta:Float) {}

    fun render(batch:SpriteBatch) {

        // TODO: Draw GigaGal's standing right sprite at position - GIGAGAL_EYE_POSITION
        val region = Assets.gigaGalAssets.standingRight

        batch.draw(
                region.getTexture(),
                position.x - Constants.GIGAGAL_EYE_POSITION.x,
                position.y - Constants.GIGAGAL_EYE_POSITION.y,
                0f,
                0f,
                region.regionWidth.toFloat(),
                region.regionHeight.toFloat(),
                1f,
                1f,
                0f,
                region.regionX,
                region.regionY,
                region.regionWidth,
                region.regionHeight,
                false,
                false)
    }

}