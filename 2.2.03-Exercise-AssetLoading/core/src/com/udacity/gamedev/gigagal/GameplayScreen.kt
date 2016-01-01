package com.udacity.gamedev.gigagal

import com.badlogic.gdx.ScreenAdapter

class GameplayScreen:ScreenAdapter() {
    companion object {
        var TAG = GameplayScreen::class.java.toString()
    }

    // TODO: Add a SpriteBatch

    // Add an ExtendViewport

    override fun show() {
        // TODO: Initialize the Assets instance


        // TODO: Initalize the SpriteBatch


        // TODO: Initialize the viewport

    }

    override fun resize(width: Int, height: Int) {
        // TODO: Update the viewport
    }

    override fun dispose() {
        // TODO: Dispose of the Assets instance


        // TODO: Dispose of the SpriteBatch
    }

    override fun render(delta: Float) {
        // TODO: Apply the viewport


        // TODO: Clear the screen to the BACKGROUND_COLOR


        // TODO: Set the SpriteBatch's projection matrix


        // TODO: Begin the SpriteBatch


        // TODO: Draw the standing right AtlasRegion


        // TODO: End the SpriteBatch

    }
}
