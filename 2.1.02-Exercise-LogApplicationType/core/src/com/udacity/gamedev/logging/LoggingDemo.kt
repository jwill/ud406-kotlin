package com.udacity.gamedev.logging

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class LoggingDemo : ApplicationAdapter() {
    // TODO: Give your ApplicationListener a log TAG

    lateinit var batch: SpriteBatch
    lateinit var img: Texture

    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")

        // TODO: Use Gdx.app to find what ApplicationType we're running
        // TODO: Use Gdx.app to log the result
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(img, 0f, 0f)
        batch.end()
    }

    // TODO: Run the Desktop app and find your log message
    // TODO: Run the Android app and find your log message
}
