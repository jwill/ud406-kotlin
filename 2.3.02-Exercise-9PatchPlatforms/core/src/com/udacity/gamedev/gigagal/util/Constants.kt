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

    val WALKING_RIGHT_2 = "walk-2-right"
    val WALKING_LEFT_2 = "walk-2-left"

    val WALKING_RIGHT_1 = "walk-1-right"
    val WALKING_LEFT_1 = "walk-1-left"
    val WALKING_RIGHT_3 = "walk-3-right"
    val WALKING_LEFT_3 = "walk-3-left"

    val WALK_LOOP_DURATION = 0.25f

    // TODO: Add String constant for the name of the platform sprite


    // TODO: Add a constant holding the size of the stretchable edges in the platform 9 patch
    // (8 pixels)


    val GIGAGAL_EYE_POSITION = Vector2(12f, 24f)
    val GIGAGAL_EYE_HEIGHT = 16f

    val GIGAGAL_MOVEMENT_SPEED = 64f

    val JUMP_SPEED = 250f
    val MAX_JUMP_DURATION = 0.15f

    val GRAVITY = 1000f
}