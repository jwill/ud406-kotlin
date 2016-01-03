package com.udacity.gamedev.gigagal

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.udacity.gamedev.gigagal.entities.GigaGal
import javax.swing.Renderer

class Level {

    var gigaGal: GigaGal

    // TODO: Add an Array of Platforms

    init {
        gigaGal = GigaGal()

        // TODO: Initialize the platform array

        // TODO: Add a test platform
    }

    fun update(delta:Float) {
        gigaGal.update(delta)
    }

    fun render(batch:SpriteBatch, renderer: ShapeRenderer) {

        renderer.begin(ShapeRenderer.ShapeType.Filled)

        // TODO: Render all platforms in the platform array

        renderer.end()

        gigaGal.render(batch)
    }
}
