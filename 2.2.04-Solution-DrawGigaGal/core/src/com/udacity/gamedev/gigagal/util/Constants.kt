package com.udacity.gamedev.gigagal.util

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Vector2


object Constants {

    val BACKGROUND_COLOR: Color = Color.SKY

    val WORLD_SIZE: Float = 128f

    var TEXTURE_ATLAS = "images/gigagal.pack.atlas"

    val STANDING_RIGHT = "standing-right"

    // TODO: Define a Vector2 Constant for GigaGal's eye position within her sprites (12, 24)
    val GIGAGAL_EYE_POSITION = Vector2(12f, 24f)

    // TODO: Define a float constant for the height of GigaGal's eye above her feet (16)
    val GIGAGAL_EYE_HEIGHT = 16f

}