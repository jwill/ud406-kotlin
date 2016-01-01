package com.udacity.gamedev.gigagal

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.udacity.gamedev.gigagal.entities.GigaGal

class Level {

    // TODO: Add a GigaGal member variable
    var gigaGal: GigaGal

    init {
        // TODO: Initialize GigaGal
        gigaGal = GigaGal()
    }

    fun update(delta:Float) {
        // TODO: Update GigaGal
        gigaGal.update(delta)
    }

    fun render(batch:SpriteBatch) {
        // TODO: Render GigaGal
        gigaGal.render(batch)
    }
}
