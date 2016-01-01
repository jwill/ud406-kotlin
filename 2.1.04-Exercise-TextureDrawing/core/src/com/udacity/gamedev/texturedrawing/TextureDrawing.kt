package com.udacity.gamedev.texturedrawing

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.utils.viewport.ExtendViewport

class TextureDrawing : ApplicationAdapter() {

    lateinit var viewport: ExtendViewport

    // TODO: Declare a SpriteBatch


    // TODO: Declare a Texture for the Udacity Logo


    override fun create() {
        viewport = ExtendViewport(WORLD_SIZE, WORLD_SIZE)

        // TODO: Initialize the SpriteBatch


        // TODO: Load the Udacity logo Texture (look in android/assets)

    }

    override fun render() {
        viewport.apply()
        Gdx.gl.glClearColor(UDACITY_ORANGE.r, UDACITY_ORANGE.g, UDACITY_ORANGE.b, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        // TODO: Set the SpriteBatch's projection matrix


        // TODO: Begin the sprite batch


        // TODO: First just draw the udacity logo at LOGO_SIZE in the bottom left of the screen


        // TODO: Then try centering the logo


        // TODO: End the sprite batch

    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    companion object {

        private val UDACITY_ORANGE = Color(228.0f / 225.0f, 127.0f / 225.0f, 57.0f / 225.0f, 1.0f)
        private val WORLD_SIZE = 100.0f
        private val LOGO_SIZE = 0.5f * WORLD_SIZE
    }
}
