package com.udacity.gamedev.gigagal.util

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Vector2


object Constants {

    val BACKGROUND_COLOR: Color = Color.SKY

    val WORLD_SIZE: Float = 128f
    val TEXTURE_ATLAS = "images/gigagal.pack.atlas"

    val STANDING_RIGHT = "standing-right"

    val STANDING_LEFT = "standing-left"

    val GIGAGAL_EYE_POSITION = Vector2(12f, 24f)
    val GIGAGAL_EYE_HEIGHT = 16f

    val GIGAGAL_MOVEMENT_SPEED = 64f

    // TODO: Add constant for GigaGal's jump speed
    // Something around 250 works well.
    val JUMP_SPEED = 250f

    // TODO: Add constant for GigaGal's max jump duration
    // Meaning how long you can hold the jump key to continue to jump higher. 0.15 seconds works well
    val MAX_JUMP_DURATION = 0.15f

    // TODO: Add constant for acceleration due to gravity
    // Something like 1000 works well.
    val GRAVITY = 1000f
}