package com.udacity.gamedev.filtering

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.ScreenViewport


// TODO: Check it out!
class Filtering : ApplicationAdapter() {

    lateinit var batch: SpriteBatch

	lateinit var nearest: Texture
	lateinit var linear: Texture

	lateinit var viewport: ScreenViewport

    override fun create() {
        batch = SpriteBatch()
        viewport = ScreenViewport()
        nearest = Texture("standing-right.png")
        linear = Texture("standing-right.png")
        linear.setFilter(TextureFilter.Linear, TextureFilter.Linear)
    }

    override fun render() {
        viewport.apply()

        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.projectionMatrix = viewport.camera.combined
        batch.begin()
        renderTextureCentered(batch, nearest, viewport.worldWidth * 1.5f / 6, viewport.worldHeight * 1 / 2, SCALE)
        renderTextureCentered(batch, nearest, viewport.worldWidth * 3 / 6, viewport.worldHeight * 1 / 2, 1.0f)
        renderTextureCentered(batch, linear, viewport.worldWidth * 4.5f / 6, viewport.worldHeight * 1 / 2, SCALE)
        batch.end()
    }

    private fun renderTextureCentered(batch: SpriteBatch, texture: Texture, x: Float, y: Float, scale: Float) {
        val scaledWidth = texture.width * scale
        val scaledHeight = texture.height * scale
        batch.draw(texture, x - scaledWidth / 2, y - scaledHeight / 2, scaledWidth, scaledHeight)
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    companion object {

        private val SCALE = 6.0f
    }
}