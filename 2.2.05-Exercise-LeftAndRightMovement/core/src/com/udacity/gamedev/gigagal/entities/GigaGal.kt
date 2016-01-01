package com.udacity.gamedev.gigagal.entities

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.udacity.gamedev.gigagal.util.Assets
import com.udacity.gamedev.gigagal.util.Constants

class GigaGal {
    companion object {
        val TAG = GigaGal::class.java.toString()
    }

    var position:Vector2

    init {
        position = Vector2(20f, Constants.GIGAGAL_EYE_HEIGHT)
    }

    fun update(delta:Float) {
        // TODO: Use Gdx.input.isKeyPressed to check if the left arrow key is pressed
        // TODO: If so, call moveLeft()

        // TODO: Do the same with the right arrow key
    }

    private fun moveLeft(delta:Float) {
        // TODO: Move GigaGal left by delta * movement speed
    }

    private fun moveRight(delta: Float) {
        // TODO: Save for moving GigaGal right
    }

    fun render(batch:SpriteBatch) {

        // TODO: Draw GigaGal's standing right sprite at position - GIGAGAL_EYE_POSITION
        val region = Assets.gigaGalAssets.standingRight

        batch.draw(
                region.texture,
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