package com.udacity.gamedev.gigagal

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.udacity.gamedev.gigagal.util.Assets
import com.udacity.gamedev.gigagal.util.Constants

class GameplayScreen : ScreenAdapter() {
    companion object {
        var TAG = GameplayScreen::class.java.toString()
    }

    lateinit var level:Level

    lateinit var batch: SpriteBatch
    lateinit var viewport: ExtendViewport

    // TODO: Remove Shape Renderer and all references from this class
    lateinit var renderer:ShapeRenderer

    override fun show() {
        Assets.init()

        level = Level()

        batch = SpriteBatch()
        viewport = ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE)

        // TODO: Initialize shape renderer
        renderer = ShapeRenderer()

    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun dispose() {
        Assets.dispose()
        batch.dispose()
    }

    override fun render(delta: Float) {
        level.update(delta)

        viewport.apply()

        with(Constants.BACKGROUND_COLOR) {
            Gdx.gl.glClearColor(r, g, b, a)
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)


        batch.projectionMatrix = viewport.camera.combined
        // TODO: Set the projectMatrix on the ShapeRenderer
        renderer.projectionMatrix = viewport.camera.combined

        // TODO: Comment out the batch.begin() and end() instructions as they will be
        // handled by Level for the time being
        //batch.begin()

        // TODO: Modify this call to render to also accept ShapeRenderer
        level.render(batch, renderer)

        //batch.end()
    }
}
