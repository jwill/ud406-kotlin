package com.udacity.gamedev.gigagal

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.udacity.gamedev.gigagal.entities.GigaGal
import com.udacity.gamedev.gigagal.entities.Platform
import com.badlogic.gdx.utils.Array

class Level {

    var gigaGal: GigaGal

    var platforms: Array<Platform>

    init {
        gigaGal = GigaGal()

        platforms = Array<Platform>()

        // TODO: Add a test platform
        platforms.add(Platform(50f,50f, 50f, 20f))
    }

    fun update(delta:Float) {
        gigaGal.update(delta)
    }

    // TODO: Remove the ShapeRenderer calls
    // TODO: Remove batch.begin and end
    fun render(batch:SpriteBatch) {

        for (platform in platforms) {
            platform.render(batch)
        }

        gigaGal.render(batch)

    }
}
