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
    var facing:Facing

    // TODO: Add a Vector2 for GigaGal's velocity


    // TODO: Add a JumpState


    // TODO: Add a long for jumpStartTime

    init {
        position = Vector2(20f, Constants.GIGAGAL_EYE_HEIGHT)
        facing = Facing.RIGHT

        // TODO: Initialize velocity


        // TODO: Initialize JumpState (probably to FALLING)
    }

    fun update(delta:Float) {
        // TODO: Accelerate GigaGal down
        // Multiple delta by the acceleration due to gravity and subtract it from GG's vertical velocity


        // TODO: Apply GigaGal's velocity to her position
        // Vector2.mulAdd() is very convenient.


        // TODO: If GigaGal isn't JUMPING, make her now FALLING


        // TODO: Check if GigaGal has landed on the ground
        // Remember that position keeps track of GigaGal's eye position, not her feet.
        // If she has indeed landed, change her jumpState to GROUNDED, set her vertical velocity to 0,
        // and make sure her feet aren't sticking into the floor.

        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            // TODO: Handle jump key
            // Add a switch statement. If the jump key is pressed and GG is GROUNDED, then startJump()
            // If she's JUMPING, then continueJump()
            // If she's falling, then don't do anything
        } else {
            // TODO: If the jump key wasn't pressed, endJump()
        }


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft(delta)
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight(delta)
        }
    }

    private fun moveLeft(delta:Float) {
        facing = Facing.LEFT
        position.x -= delta * Constants.GIGAGAL_MOVEMENT_SPEED
    }

    private fun moveRight(delta: Float) {
        facing = Facing.RIGHT
        position.x += delta * Constants.GIGAGAL_MOVEMENT_SPEED
    }

    private fun startJump() {
        // TODO: Set jumpState to JUMPING

        // TODO: Set the jump start time
        // Using TimeUtils.nanoTime()

        // TODO: Call continueJump()

    }

    private fun continueJump() {
        // TODO: First, check if we're JUMPING, if not, just return

        // TODO: Find out how long we've been jumping

        // TODO: If we have been jumping for less than the max jump duration, set GG's vertical speed to the jump speed constant
        // TODO: Else, call endJump()
    }

    private fun endJump() {
        // TODO: If we're JUMPING, now we're FALLING
    }

    fun render(batch:SpriteBatch) {

        val region:TextureRegion

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

    // TODO: Do this first! Add a JumpState enum containing JUMPING, FALLING, and GROUNDED


    enum class Facing {
        LEFT, RIGHT
    }
}