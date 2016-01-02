package com.udacity.gamedev.gigagal.util

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Vector2


object Constants {

    val BACKGROUND_COLOR: Color = Color.SKY

    val WORLD_SIZE: Float = 128f
    val TEXTURE_ATLAS = "images/gigagal.pack.atlas"

    val STANDING_RIGHT = "standing-right"
    val STANDING_LEFT = "standing-left"
    val JUMPING_RIGHT = "jumping-right"
    val JUMPING_LEFT = "jumping-left"

    val WALKING_RIGHT = "walk-2-right"
    val WALKING_LEFT = "walk-2-left"

    // TODO: Add constants for the 4 other walking sprites


    // TODO: Add constant for walk loop duration
    // Something like 0.25 works well.

    val GIGAGAL_EYE_POSITION = Vector2(12f, 24f)
    val GIGAGAL_EYE_HEIGHT = 16f

    val GIGAGAL_MOVEMENT_SPEED = 64f

    val JUMP_SPEED = 250f
    val MAX_JUMP_DURATION = 0.15f

    val GRAVITY = 1000f
}