package com.udacity.gamedev.gigagal.entities

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
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
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft(delta)
        }

        // TODO: Do the same with the right arrow key
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight(delta)
        }
    }

    private fun moveLeft(delta:Float) {
        // TODO: Move GigaGal left by delta * movement speed
        position.x -= delta * Constants.GIGAGAL_MOVEMENT_SPEED
    }

    private fun moveRight(delta: Float) {
        // TODO: Save for moving GigaGal right
        position.x += delta * Constants.GIGAGAL_MOVEMENT_SPEED
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