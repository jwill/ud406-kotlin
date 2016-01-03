package com.udacity.gamedev.gigagal

import com.badlogic.gdx.graphics.g2d.SpriteBatch
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
        // Remember that we updated GigaGal's signature
        gigaGal.update(delta, platforms)
    }

    fun render(batch:SpriteBatch) {

        for (platform in platforms) {
            platform.render(batch)
        }

        gigaGal.render(batch)
    }
}
