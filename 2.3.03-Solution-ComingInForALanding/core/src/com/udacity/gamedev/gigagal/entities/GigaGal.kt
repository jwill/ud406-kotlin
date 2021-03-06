package com.udacity.gamedev.gigagal.entities

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.utils.TimeUtils
import com.udacity.gamedev.gigagal.util.Assets
import com.udacity.gamedev.gigagal.util.Constants

class GigaGal {
    companion object {
        val TAG = GigaGal::class.java.toString()
    }

    var position:Vector2
    var facing:Facing

    var velocity:Vector2

    var jumpState:JumpState
    var walkState:WalkState

    var jumpStartTime:Long = 0
    var walkStartTime:Long = 0

    // TODO: Add Vector2 to hold GigaGal's position last frame
    var lastFramePosition:Vector2


    init {
        position = Vector2(20f, Constants.GIGAGAL_EYE_HEIGHT)
        facing = Facing.RIGHT
        velocity = Vector2()
        jumpState = JumpState.FALLING
        walkState = WalkState.STANDING

        // TODO: Initialize a new Vector2 for lastFramePosition
        lastFramePosition = Vector2()
    }

    // TODO: Note that we're now passing in the platform array to GigaGal's update method
    fun update(delta:Float, platforms: Array<Platform>) {
        // TODO: Update lastFramePosition
        // You'll want to use Vector2.set()
        lastFramePosition.set(position)

        velocity.y -= delta * Constants.GRAVITY

        position.mulAdd(velocity, delta)

        if (jumpState != JumpState.JUMPING) {
            jumpState = JumpState.FALLING


            if (position.y - Constants.GIGAGAL_EYE_HEIGHT < 0) {
                jumpState = JumpState.GROUNDED
                position.y = Constants.GIGAGAL_EYE_HEIGHT
                velocity.y = 0f
            }

            // TODO: For each platform, call landedOnPlatform()
            for(platform in platforms) {
                if (landedOnPlatform(platform)) {

                    // TODO: If true, set jumpState to GROUNDED
                    jumpState = JumpState.GROUNDED

                    // TODO: Zero vertical velocity
                    velocity.y = 0f

                    // TODO: Make sure GigaGal's feet aren't sticking into the platform
                    position.y = platform.top + Constants.GIGAGAL_EYE_HEIGHT
                }
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            when(jumpState) {
                JumpState.GROUNDED -> startJump()
                JumpState.JUMPING -> continueJump()
            }
        } else {
            endJump()
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft(delta)
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight(delta)
        } else {
            walkState = WalkState.STANDING
        }
    }

    fun landedOnPlatform(platform: Platform): Boolean {
        var leftFootIn = false
        var rightFootIn = false
        var straddle = false

        // TODO: First check if GigaGal's feet were above the platform top last frame and below the platform top this frame
        if (lastFramePosition.y - Constants.GIGAGAL_EYE_HEIGHT >= platform.top &&
                position.y - Constants.GIGAGAL_EYE_HEIGHT < platform.top) {

            // TODO: If so, find the position of GigaGal's left and right toes
            var leftFoot = position.x - Constants.GIGAGAL_STANCE_WIDTH / 2
            var rightFoot = position.x + Constants.GIGAGAL_STANCE_WIDTH / 2

            // TODO: See if either of GigaGal's toes are on the platform
            leftFootIn = (platform.left < leftFoot && platform.right  > leftFoot)
            rightFootIn = (platform.left < rightFoot && platform.right > rightFoot)

            // TODO: See if GigaGal is straddling the platform
            straddle = (platform.left > leftFoot && platform.right < rightFoot)
        }

        // TODO: Return whether or not GigaGal had landed on the platform
        return leftFootIn || rightFootIn || straddle
    }

    private fun moveLeft(delta:Float) {
        // TODO if we're GROUNDED and not WALKING, save the walkStartTime
        if (jumpState == JumpState.GROUNDED && walkState != WalkState.WALKING)
            walkStartTime = TimeUtils.nanoTime()

        walkState = WalkState.WALKING
        facing = Facing.LEFT
        position.x -= delta * Constants.GIGAGAL_MOVEMENT_SPEED
    }

    private fun moveRight(delta: Float) {
        // TODO if we're GROUNDED and not WALKING, save the walkStartTime
        if (jumpState == JumpState.GROUNDED && walkState != WalkState.WALKING)
            walkStartTime = TimeUtils.nanoTime()

        walkState = WalkState.WALKING
        facing = Facing.RIGHT
        position.x += delta * Constants.GIGAGAL_MOVEMENT_SPEED
    }

    private fun startJump() {
        jumpState = JumpState.JUMPING
        jumpStartTime = TimeUtils.nanoTime()
        continueJump()
    }

    private fun continueJump() {
        if (jumpState == JumpState.JUMPING) {
            val jumpDuration = MathUtils.nanoToSec * (TimeUtils.nanoTime() - jumpStartTime)
            if (jumpDuration < Constants.MAX_JUMP_DURATION) {
                velocity.y = Constants.JUMP_SPEED
            }
        }
    }

    private fun endJump() {
        if (jumpState == JumpState.JUMPING) {
            jumpState = JumpState.FALLING
        }
    }

    fun render(batch:SpriteBatch) {
        val region:TextureRegion

        if (facing == Facing.RIGHT) {
            if (jumpState == JumpState.JUMPING || jumpState == JumpState.FALLING) {
                region = Assets.gigaGalAssets.jumpingRight
            } else if (walkState == WalkState.STANDING) {
                region = Assets.gigaGalAssets.standingRight
            } else {
                // TODO: Calculate how long we've been walking in seconds
                val walkTimeSeconds = MathUtils.nanoToSec * (TimeUtils.nanoTime() - walkStartTime)


                // TODO: Select the correct frame from the walking right animation
                region = Assets.gigaGalAssets.walkingRightAnimation.getKeyFrame(walkTimeSeconds)
            }
        } else {
            if (jumpState == JumpState.JUMPING || jumpState == JumpState.FALLING) {
                region = Assets.gigaGalAssets.jumpingLeft
            } else if (walkState == WalkState.STANDING) {
                region = Assets.gigaGalAssets.standingLeft
            } else {
                // TODO: Calculate how long we've been walking in seconds
                val walkTimeSeconds = MathUtils.nanoToSec * (TimeUtils.nanoTime() - walkStartTime)


                // TODO: Select the correct frame from the walking right animation
                region = Assets.gigaGalAssets.walkingLeftAnimation.getKeyFrame(walkTimeSeconds)
            }
        }

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

    enum class JumpState {
        JUMPING, FALLING, GROUNDED
    }

    enum class Facing {
        LEFT, RIGHT
    }

    enum class WalkState {
        STANDING, WALKING
    }
}