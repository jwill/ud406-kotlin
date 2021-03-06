package com.udacity.gamedev.gigagal.util

import com.badlogic.gdx.graphics.Color


object Constants {

    // TODO: Set a BACKGROUND_COLOR We recommend Color.SKY
    val BACKGROUND_COLOR: Color = Color.SKY

    // TODO: Set a WORLD_SIZE
    /**
     * We'll draw our sprites at their natural size, so this is the number of pixels of our Pixel
     * art that will fit on the screen. We're going to use this size to initialize both dimensions
     * of an ExtendViewport, and we'll run the game in landscape mode, so this will really end up
     * specifying the height of the world. We recommend 128.
     */
    val WORLD_SIZE: Float = 128f

    internal var TEXTURE_ATLAS = "images/gigagal.pack.atlas"

    // TODO: Add a constant for the name of the standing-right sprite
    val STANDING_RIGHT = "standing-right"

}