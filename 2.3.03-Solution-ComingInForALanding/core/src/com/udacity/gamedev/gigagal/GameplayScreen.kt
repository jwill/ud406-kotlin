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

    override fun show() {
        Assets.init()

        level = Level()

        batch = SpriteBatch()
        viewport = ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE)


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

        batch.begin()
        level.render(batch)

        batch.end()
    }
}
