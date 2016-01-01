package com.udacity.gamedev.gigagal.entities

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2
import com.udacity.gamedev.gigagal.util.Assets
import com.udacity.gamedev.gigagal.util.Constants

class GigaGal {
    companion object {
        val TAG = GigaGal::class.java.toString()
    }

    var position:Vector2

    // TODO: Add a Facing member variable (defined below)
    var facing:Facing

    init {
        position = Vector2(20f, Constants.GIGAGAL_EYE_HEIGHT)
        // TODO: Initialize facing, probably with FACING.RIGHT
        facing = Facing.RIGHT
    }

    fun update(delta:Float) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft(delta)
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight(delta)
        }
    }

    private fun moveLeft(delta:Float) {
        // TODO: Update facing direction
        facing = Facing.LEFT
        position.x -= delta * Constants.GIGAGAL_MOVEMENT_SPEED
    }

    private fun moveRight(delta: Float) {
        // TODO: Update facing direction
        facing = Facing.RIGHT
        position.x += delta * Constants.GIGAGAL_MOVEMENT_SPEED
    }

    fun render(batch:SpriteBatch) {

        val region:TextureRegion

        // TODO: Set region to the correct sprite for the current facing direction
        if (facing == Facing.RIGHT)
            region = Assets.gigaGalAssets.standingRight
        else
            region = Assets.gigaGalAssets.standingLeft

        
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

    // TODO: DO THIS FIRST!!! Create an enum called Facing, with LEFT and RIGHT members
    enum class Facing {
        LEFT, RIGHT
    }
}