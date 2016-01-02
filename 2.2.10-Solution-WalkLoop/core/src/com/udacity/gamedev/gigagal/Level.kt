package com.udacity.gamedev.gigagal

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.udacity.gamedev.gigagal.entities.GigaGal

class Level {

    var gigaGal: GigaGal

    init {
        gigaGal = GigaGal()
    }

    fun update(delta:Float) {
        gigaGal.update(delta)
    }

    fun render(batch:SpriteBatch) {
        gigaGal.render(batch)
    }
}
