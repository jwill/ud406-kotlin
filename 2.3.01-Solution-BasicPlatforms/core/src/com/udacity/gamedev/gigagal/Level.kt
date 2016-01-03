package com.udacity.gamedev.gigagal

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.udacity.gamedev.gigagal.entities.GigaGal
import com.udacity.gamedev.gigagal.entities.Platform
import com.badlogic.gdx.utils.Array

class Level {

    var gigaGal: GigaGal

    // TODO: Add an Array of Platforms
    var platforms: Array<Platform>

    init {
        gigaGal = GigaGal()

        // TODO: Initialize the platform array
        platforms = Array<Platform>()

        // TODO: Add a test platform
        platforms.add(Platform(50f,50f, 50f, 20f))
    }

    fun update(delta:Float) {
        gigaGal.update(delta)
    }

    fun render(batch:SpriteBatch, renderer: ShapeRenderer) {

        renderer.begin(ShapeRenderer.ShapeType.Filled)

        // TODO: Render all platforms in the platform array
        for (platform in platforms) {
            platform.render(renderer)
        }

        renderer.end()

        batch.begin()

        gigaGal.render(batch)

        batch.end()
    }
}
