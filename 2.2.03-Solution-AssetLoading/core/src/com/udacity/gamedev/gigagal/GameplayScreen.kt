package com.udacity.gamedev.gigagal

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.udacity.gamedev.gigagal.util.Assets
import com.udacity.gamedev.gigagal.util.Constants

class GameplayScreen : ScreenAdapter() {
    companion object {
        var TAG = GameplayScreen::class.java.toString()
    }

    // TODO: Add a SpriteBatch
    lateinit var batch: SpriteBatch

    // TODO:Add an ExtendViewport
    lateinit var viewport: ExtendViewport

    override fun show() {
        // TODO: Initialize the Assets instance
        Assets.init()

        // TODO: Initalize the SpriteBatch
        batch = SpriteBatch()

        // TODO: Initialize the viewport
        viewport = ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE)

    }

    override fun resize(width: Int, height: Int) {
        // TODO: Update the viewport
        viewport.update(width, height, true)
    }

    override fun dispose() {
        // TODO: Dispose of the Assets instance
        Assets.dispose()

        // TODO: Dispose of the SpriteBatch
        batch.dispose()
    }

    override fun render(delta: Float) {
        // TODO: Apply the viewport
        viewport.apply()

        // TODO: Clear the screen to the BACKGROUND_COLOR
        with(Constants.BACKGROUND_COLOR) {
            Gdx.gl.glClearColor(r, g, b, a)
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)


        // TODO: Set the SpriteBatch's projection matrix
        batch.projectionMatrix = viewport.camera.combined

        // TODO: Begin the SpriteBatch
        batch.begin()


        // TODO: Draw the standing right AtlasRegion
        var region = Assets.gigaGalAssets.standingRight

        batch.draw(
                region.texture,
                50f,
                50f,
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


        // TODO: End the SpriteBatch
        batch.end()
    }
}
