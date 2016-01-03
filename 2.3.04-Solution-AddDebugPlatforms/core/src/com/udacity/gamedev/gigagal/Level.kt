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

        addDebugPlatforms()
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

    /**
     * TODO: Add more platforms to create a fun jumping challenge!
     *
     * Note that you'll want to add the platforms in the order you want them drawn. That'll
     * generally mean you want the platforms at the top of the screen to be rendered before the ones
     * lower down.
     */
    private fun addDebugPlatforms() {
        platforms.add(Platform(15f, 100f, 30f, 20f))
        platforms.add(Platform(75f, 90f, 100f, 65f))
        platforms.add(Platform(35f, 55f, 50f, 20f))
        platforms.add(Platform(10f, 20f, 20f, 9f))
    }
}
